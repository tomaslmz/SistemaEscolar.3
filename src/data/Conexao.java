package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
* Criacao da classe Conexao;<br>
**/

public class Conexao {
	//Nome do banco de dados
	private String database = "SistemaEscolar";
	//Login do usuário para o banco de dados
	private String user = "root";
	private String password = "root";
	//Caminho para o banco de dados
	private String path = "jdbc:mysql://localhost:3306/" + database;
	
	public Connection conectar() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection conexao = null;
		
		try {
			conexao = DriverManager.getConnection(path, user, password);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return conexao;
	}
}
