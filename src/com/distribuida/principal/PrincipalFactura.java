package com.distribuida.principal;

import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.distribuida.dao.ClienteDAO;
import com.distribuida.dao.FacturaDAO;
import com.distribuida.entities.Factura;



public class PrincipalFactura {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		FacturaDAO facturaDAO = context.getBean("facturaDAOimpl",FacturaDAO.class);
		ClienteDAO clienteDAO = context.getBean("clienteDAOimpl",ClienteDAO.class);
		
		// crud, create, read, update, delete 
		
		//add
		Factura factura = new Factura(0,"FAC-0090",new Date(),60.63,15.36,76.35);
		factura.setCliente(clienteDAO.findOne(1));
		//facturaDAO.add(factura);
	
		//up
		Factura factura2 = new Factura(86,"FAC-0091",new Date(),60.632,15.362,76.352);
		factura2.setCliente(clienteDAO.findOne(2));
		//facturaDAO.up(factura2);
		
		//del
		facturaDAO.del(86);
		//finone
		System.out.print("*******************Del****************"+facturaDAO.findOne(86));
		//findall
		//List<Factura> Facturas = FacturaDAO.findALL();
		facturaDAO.findALL().forEach(item -> { System.out.println(item.toString()); });
				context.close();
	}

}
