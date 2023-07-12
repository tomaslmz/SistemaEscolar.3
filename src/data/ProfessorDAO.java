package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import models.Professor;

public class ProfessorDAO {
	public static boolean compararLogin(Professor p) {
		String sql = "SELECT cpf, senha FROM professors WHERE cpf = ? AND senha = ?";
		
		Conexao conexao = new Conexao();
		Connection id = conexao.conectar();
		
		ResultSet result = null;
		
		try {
			PreparedStatement command = id.prepareStatement(sql);
			command.setString(1, p.getCpf());
			command.setString(2, p.getSenha());
			result = command.executeQuery();
		} catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao procurar o professor!");
			return false;
		}
		
		try {
			if(result.next()) {
				if(result.getString("cpf").equals(p.getCpf())) {
					if(result.getString("senha").equals(p.getSenha())) {
						return true;
					} else {
						JOptionPane.showMessageDialog(null, "Senha incorreta!");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Nome de usuário não existe!");
					return false;
				}
			}
		} catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Não foi possível encontrar o professor!");
			return false;
		}
		return false;
	}

}
