package com.distribuida.principal;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.distribuida.dao.FacturaDetalleDAO;
import com.distribuida.entities.FacturaDetalle;


public class PrincipalFacturaDetalle  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		FacturaDetalleDAO FacturaDetalleDAO = context.getBean("FacturaDetalleDAOimpl",FacturaDetalleDAO.class);
		List<FacturaDetalle> FacturaDetalle = FacturaDetalleDAO.findALL();
		FacturaDetalle.forEach(item -> {
			System.out.println(item.toString());
		});
				context.close();
	}

}
