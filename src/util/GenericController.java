package util;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import dao.ConnectionFactory;



public abstract class GenericController {

	private Connection connection;
	private ConnectionFactory conFactory;
	
	
	public GenericController(){
		this.conFactory = new ConnectionFactory();
	}

	public Connection connectDb(){
		this.connection = conFactory.getConnection();
		return this.connection;
	}
	
	public void disconnectDb(Connection connection){
		this.conFactory.destroy(connection);
	}
	
	
	/**
	 * Metodo  execute()
	 * 
	 * 
	 * 
	 * */
	public abstract Object execute(HttpServletRequest request);
	
}
