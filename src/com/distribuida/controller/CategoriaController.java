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

import com.distribuida.dao.CategoriaDAO;
import com.distribuida.entities.Categoria;



@Controller
@RequestMapping("/Categorias") //path principal 
public class CategoriaController {

	
	@Autowired
	private CategoriaDAO CategoriaDAO;
	
	
	@GetMapping("/finAll")   //path segundario
	public String finAll(Model model) {
		
		//try {
			List<Categoria> categoria = CategoriaDAO.findALL();
			
			model.addAttribute("Categorias", categoria); //ej clave = KeyCategorias
			
			return "listar-Categorias";   // Nombre del formulario Ej. listar - Categorias html o jsp
			
			
		//}catch (Exception e) {
		// TODO: handle exception
		//	e.printStackTrace();
		//}
		
		
	}
	
	@GetMapping("/findOne")
	public String findOne(@RequestParam("idCategoria") @Nullable Integer idCategoria
	                    , @RequestParam("opcion") @Nullable Integer opcion
	                    , Model model ){
	
	
	//try {
	
	if(idCategoria !=null) {
		Categoria categoria = CategoriaDAO.findOne(idCategoria);
		model.addAttribute("Categoria", categoria);
	}
	
	if(opcion ==1) return "add-Categorias";
	
	else  return "del-Categorias";
//}catch(Exception e)
	}

	
	@PostMapping("/add")
	public String add(@RequestParam("idCategoria")@Nullable Integer idCategoria
			,@RequestParam("categoria") @Nullable String categoria
	         ,@RequestParam("descripcion") @Nullable String descripcion
	         , Model model
			
			) {
		
		//try {
		
		if(idCategoria == null) {
			Categoria Categoria = new Categoria(0, categoria, descripcion);
			CategoriaDAO.add(Categoria); 
			}else { 
				Categoria Categoria2 = new Categoria(idCategoria, categoria, descripcion);
				CategoriaDAO.up(Categoria2); 
			}
			return "redirect:/Categorias/finDALL";  //IR A FROMULARIO WEB POR PATH O URL
			
	//} catch (Exception e) {
		// TODO: handle exception
	//}
		
	}
	
	
	@GetMapping("/del")
	public String del(@RequestParam("idCategoria")@Nullable Integer idCategoria) {
		
		//try {
		
		CategoriaDAO.del(idCategoria);
		return "redirect:/Categorias/finDALL";
		
	//} catch (Exception e) {
		// TODO: handle exception
	//}
	
		
	}






}



