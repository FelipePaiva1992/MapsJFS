package dao;


import java.sql.Connection;
import java.sql.DriverManager;
//import java.util.Date;


public class ConnectionFactory {
	
	// ALTERAR ESTAS CONSTANTES DE ACORDO COM A CONFIGURACAO DO SEU BD
	private static final String DATABASE = "academico";
	
	//EM ACQUA MANAGER
//	private static final String USER = "ramais_user";
//	private static final String PASSWORD = "ramaisht";
//	private static final String HOST = "192.168.1.203";
	
	//EM CASA
	private static final String USER = "academico_user";
	private static final String PASSWORD = "academico";
	private static final String HOST = "192.168.1.203";	
	
	//----------------------------------------------------------------

	private Connection connection;

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://"+HOST+":3306/"+DATABASE, USER, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println("Aberta conexao com banco de dados "+DATABASE+" em: "+new Date());
		return connection;
	}

	public void destroy(Connection connection) {
		try {
			connection.close();
			////*****APENAS DESREGISTRAR O DRIVER JDBC QUANDO UMA CONEXAO SEMPRE ATIVA EH MANTIDA!
			//DESREGISTRANDO DRIVER JDBC : http://www.guj.com.br/java/208867-memory-leak | https://issues.apache.org/jira/browse/DBCP-332
			//DriverManager.deregisterDriver(DriverManager.getDriver("jdbc:mysql://"+HOST+":3306/"+DATABASE));
			//----------------------------------------------------------------------------------------------------------------------
			//System.out.println("Encerrada conexao com o banco de dados "+DATABASE+" em: "+new Date());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

