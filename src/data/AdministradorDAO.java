package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdministradorDAO {
	
	public boolean compararLogin(String user, String pswd) {
		String sql = "SELECT usuario, senha FROM Administradores WHERE usuario = ?";
		
		Conexao conexao = new Conexao();
		Connection id = conexao.conectar();
		
		ResultSet result = null;
		
		try {
			PreparedStatement command = id.prepareStatement(sql);
			command.setString(1, user);
			result = command.executeQuery();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(result.next()) {
				String user2 = result.getString("usuario");
				String pswd2 = result.getString("senha");
				
				if(user.equals(user2) && pswd.equals(pswd2)) {
					return true;
				} else {
					return false;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
