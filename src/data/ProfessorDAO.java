package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import models.Aluno;
import models.Professor;

/**
* Criacao da classe ProfessorDAO;<br>
**/
public class ProfessorDAO {//Feito por Tomas
	
	/**
	 * Metodo para listar os professores;<br>
	 * */
	
	public ArrayList<Professor> listarProfessores(){
		String mySql = "SELECT id, nome, cpf, dataNascimento, endereco, telefone, salario FROM Professores";
		//Conectar ao Banco de Dados
		Conexao conexao = new Conexao();
		Connection id = conexao.conectar();
		//Comando SQL

		ArrayList<Professor> listaProfessor = new ArrayList<Professor>();
		ResultSet result = null;
		/**
		 * Tratamento de exceções
		 */
		try {
			PreparedStatement command = id.prepareStatement(mySql);
			result = command.executeQuery();

			
			while(result.next()) {
				listaProfessor.add(new Professor(result.getInt("id"), result.getString("nome"), result.getString("cpf"), 
					result.getString("dataNascimento"), result.getString("endereco"), result.getString("telefone"), result.getFloat("salario")));
			}
			id.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return listaProfessor;
	}
	
	/**
	 * Metodo para comparar o login;<br>
	 * */
	public boolean compararLogin(Professor p) {
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
