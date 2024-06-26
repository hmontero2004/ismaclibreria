package com.distribuida.principal;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.distribuida.dao.AutorDAO;
import com.distribuida.entities.Autor;



public class PrincipalAutor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		AutorDAO autorDAO = context.getBean("autorDAOimpl",AutorDAO.class);

		// crud, create, read, update, delete 
		
				//add
				Autor Autor = new Autor(0,"Hammer","Montero", "pais","sv. por ahi...","0999999999","josmr@gmail.com");
				//autorDAO.add(Autor);
			
				//up
				Autor Autor2 = new Autor(56,"Jose","Roo","pais2","sv. por ahi...","0899999999","hmont@gmail.com");
				//autorDAO.up(Autor2);
				
				//del
				//autorDAO.del(56);
				//finone
				//System.out.print("*******************Del****************"+autorDAO.findOne(39));
				try{System.out.print("*******************Del****************"+autorDAO.findOne(56));} catch(Exception e) {e.printStackTrace();}  
				//findall
				//List<Autor> Autors = AutorDAO.findALL();
				autorDAO.findALL().forEach(item -> { System.out.println(item.toString());});
						context.close();
			}
}