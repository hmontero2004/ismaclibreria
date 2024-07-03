package com.distribuida.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.distribuida.dao.ClienteDAO;
import com.distribuida.entities.Cliente;



@Controller
@RequestMapping("/clientes") //path principal 
public class ClienteController {

	
	@Autowired
	private ClienteDAO clienteDAO;
	
	
	@GetMapping("/finAll")   //path segundario
	public String finAll(Model model) {
		
		//try {
			List<Cliente> cliente = clienteDAO.findALL();
			
			model.addAttribute("Clientes", cliente); //ej clave = KeyClientes
			
			return "listar-clientes";   // Nombre del formulario Ej. listar - clientes html o jsp
			
			
		//}catch (Exception e) {
		// TODO: handle exception
		//	e.printStackTrace();
		//}
		
		
	}
	
	@GetMapping("/findOne")
	public String findOne(@RequestParam("idCliente") @Nullable Integer idcliente
	                    , @RequestParam("opcion") @Nullable Integer opcion
	                    , Model model ){
	
	
	//try {
	
	if(idcliente !=null) {
		Cliente cliente = clienteDAO.findOne(idcliente);
		model.addAttribute("cliente", cliente);
	}
	
	if(opcion ==1) return "add-clientes";
	
	else  return "del-clientes";
//}catch(Exception e)
	}

	
	@PostMapping("/add")
	public String add(@RequestParam("idCliente")@Nullable Integer idCliente
			,@RequestParam("cedula") @Nullable Integer cedula
	         ,@RequestParam("nombre") @Nullable String nombre
	         ,@RequestParam("apellido") @Nullable String apellido
	         ,@RequestParam("direccion") @Nullable String direccion
	         ,@RequestParam("telefono") @Nullable Integer telefono
	         ,@RequestParam("correo") @Nullable String correo
	         , Model model
			
			) {
		
		//try {
		
		if(idCliente == null) {
			Cliente cliente = new Cliente(0, correo, nombre, apellido, direccion, correo);
			clienteDAO.add(cliente); 
			}else { 
				Cliente cliente2 = new Cliente(idCliente, correo, nombre, apellido, direccion, correo);
				clienteDAO.up(cliente2); 
			}
			return "redirect:/clientes/finDALL";  //IR A FROMULARIO WEB POR PATH O URL
			
	//} catch (Exception e) {
		// TODO: handle exception
	//}
		
	}
	
	
	@GetMapping("/del")
	public String del(@RequestParam("idCliente")@Nullable Integer idCliente) {
		
		//try {
		
		clienteDAO.del(idCliente);
		return "redirect:/clientes/finDALL";
		
	//} catch (Exception e) {
		// TODO: handle exception
	//}
	
		
	}






}



