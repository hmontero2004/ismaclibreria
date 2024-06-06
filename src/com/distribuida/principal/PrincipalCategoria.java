package com.distribuida.principal;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.distribuida.dao.CategoriaDAO;
import com.distribuida.entities.Categoria;


public class PrincipalCategoria  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		CategoriaDAO categoriaDAO = context.getBean("categoriaDAOimpl",CategoriaDAO.class);

		List<Categoria> categoria = categoriaDAO.findALL();
		categoria.forEach(item -> {
			System.out.println(item.toString());
		});
				context.close();
	}

}
