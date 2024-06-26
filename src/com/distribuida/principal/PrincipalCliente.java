package com.distribuida.principal;
 
import java.util.List;
 
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
import com.distribuida.dao.ClienteDAO;
import com.distribuida.entities.Cliente;
 
public class PrincipalCliente {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		ClienteDAO clienteDAO = context.getBean("clienteDAOimpl",ClienteDAO.class);

		// crud, create, read, update, delete 
		
		//add
		Cliente cliente = new Cliente(0,"123456789","Hammer","Montero","sv. por ahi...","0999999999");
		clienteDAO.add(cliente);
	
		//up
		Cliente cliente2 = new Cliente(42,"123456789","Jose","Roo","sv. por ahi...","0899999999");
		//clienteDAO.up(cliente2);
		
		//del
		//clienteDAO.del(39);
		//finone
		System.out.print("*******************Del****************"+clienteDAO.findOne(39));
		//findall
		//List<Cliente> clientes = clienteDAO.findALL();
		clienteDAO.findALL().forEach(item -> { System.out.println(item.toString());});
				context.close();
	}
}