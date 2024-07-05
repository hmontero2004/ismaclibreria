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

import com.distribuida.dao.AutorDAO;
import com.distribuida.entities.Autor;



@Controller
@RequestMapping("/Autor") //path principal 
public class AutorController {

	
	@Autowired
	private AutorDAO AutorDAO;
	
	
	@GetMapping("/finAll")   //path segundario
	public String finAll(Model model) {
		
		//try {
			List<Autor> autor = AutorDAO.findALL();
			
			model.addAttribute("Autor", autor); //ej clave = KeyAutors
			
			return "listar-Autor";   // Nombre del formulario Ej. listar - Autors html o jsp
			
			
		//}catch (Exception e) {
		// TODO: handle exception
		//	e.printStackTrace();
		//}
		
		
	}
	
	@GetMapping("/findOne")
	public String findOne(@RequestParam("idAutor") @Nullable Integer idAutor
	                    , @RequestParam("opcion") @Nullable Integer opcion
	                    , Model model ){
	
	
	//try {
	
	if(idAutor !=null) {
		Autor autor = AutorDAO.findOne(idAutor);
		model.addAttribute("Autor", autor);
	}
	
	if(opcion ==1) return "add-Autor";
	
	else  return "del-Autor";
//}catch(Exception e)
	}

	
	@PostMapping("/add")
	public String add(@RequestParam("idAutor")@Nullable Integer idAutor
			
	         ,@RequestParam("nombre") @Nullable String nombre
	         ,@RequestParam("apellido") @Nullable String apellido
	         ,@RequestParam("pais") @Nullable String pais
	         ,@RequestParam("direccion") @Nullable String direccion
	         ,@RequestParam("telefono") @Nullable String telefono
	         ,@RequestParam("correo") @Nullable String correo
	         , Model model
			
			) {
		
		//try {
		
		if(idAutor == null) {
			Autor autor = new Autor(0, nombre, apellido, pais, direccion, telefono, correo);
			AutorDAO.add(autor); 
			}else { 
				Autor Autor2 = new Autor(idAutor, nombre, apellido, pais ,direccion, telefono, correo);
				AutorDAO.up(Autor2); 
			}
			return "redirect:/Autors/finDALL";  //IR A FROMULARIO WEB POR PATH O URL
			
	//} catch (Exception e) {
		// TODO: handle exception
	//}
		
	}
	
	
	@GetMapping("/del")
	public String del(@RequestParam("idAutor")@Nullable Integer idautor) {
		
		//try {
		
		AutorDAO.del(idautor);
		return "redirect:/Autor/finDALL";
		
	//} catch (Exception e) {
		// TODO: handle exception
	//}
	
		
	}






}



