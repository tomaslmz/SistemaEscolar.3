package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Professor;

public class AdministradorDAO {
	
	public String buscarString(String tabela, String atributo, String dado) {
		String sql = "SELECT ? FROM ? WHERE ? = ?";
		
		Conexao conexao = new Conexao();
		Connection id = conexao.conectar();
		
		ResultSet result = null;
		
		try {
			PreparedStatement command = id.prepareStatement(sql);
			command.setString(1, atributo);
			command.setString(2, tabela);
			command.setString(3, atributo);
			command.setString(4, dado);
			result = command.executeQuery();
			id.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(result.next()) {
				return result.getString(tabela);
			} else {
				return "ERRO: NADA ENCONTRADO!";
			}
		} catch(SQLException e) {
			e.printStackTrace();
			return "ERRO: NADA ENCONTRADO!";
		}
	}
	
	public void atualizarProfessor(Professor p) {
		String sql = "UPDATE Professores SET nome = ?, cpf = ?, dataNascimento = ?, endereco = ?, telefone = ?, salario = ? WHERE id = ?";
		
		Conexao conexao = new Conexao();
		Connection id = conexao.conectar();
		
		try {
			PreparedStatement command = id.prepareStatement(sql);
			command.setString(1, p.getNome());
			command.setString(2, p.getCpf());
			command.setString(3, p.getDataNascimento());
			command.setString(4, p.getEndereco());
			command.setString(5, p.getTelefone());
			command.setFloat(6, p.getSalario());
			command.setInt(7, p.getId());
			
			command.executeUpdate();
			id.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Float buscarSalarioProfessor(int pid) {
		String sql = "SELECT salario FROM Professores WHERE id = ?";
		
		Conexao conexao = new Conexao();
		Connection id = conexao.conectar();
		
		ResultSet result = null;
		
		try {
			PreparedStatement command = id.prepareStatement(sql);
			command.setInt(1, pid);
			result = command.executeQuery();
			id.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		float salario = -1;
		
		try {
			salario = result.getFloat("salario");
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return salario;
	}
	
	public boolean registrarProfessor(Professor p) {
		String sql = "INSERT INTO Professores(nome, senha, cpf, dataNascimento, endereco, telefone, salario) VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		Conexao conexao = new Conexao();
		Connection id = conexao.conectar();
		
		try {
			PreparedStatement command = id.prepareStatement(sql);
			command.setString(1, p.getNome());
			command.setString(2, p.getSenha());
			command.setString(3, p.getCpf());
			command.setString(4, p.getDataNascimento());
			command.setString(5, p.getEndereco());
			command.setString(6, p.getTelefone());
			command.setFloat(7, p.getSalario());
			command.execute();
			id.close();
			return true;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void apagarProfessor(int pid) {
		String sql = "DELETE FROM Professores WHERE id = ?";
		
		Conexao conexao = new Conexao();
		Connection id = conexao.conectar();
		
		try {
			PreparedStatement command = id.prepareStatement(sql);
			command.setInt(1, pid);
			command.execute();
			id.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int quantidadeProfessores() {
		String sql = "SELECT COUNT(*) AS 'quantidade' FROM Professores";
		
		Conexao conexao = new Conexao();
		Connection id = conexao.conectar();
		
		ResultSet result = null;
		
		try {
			PreparedStatement command = id.prepareStatement(sql);
			result = command.executeQuery();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(result.next()) {
				return result.getInt("quantidade");
			} else {
				return 0;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public ArrayList<Professor> selecionarProfessores() {
		String sql = "SELECT id, nome, cpf, dataNascimento, endereco, telefone, salario FROM Professores";
		
		Conexao conexao = new Conexao();
		Connection id = conexao.conectar();
		
		ResultSet result = null;
		
		ArrayList<Professor> listaProfessor = new ArrayList<Professor>();
		
		try {
			PreparedStatement command = id.prepareStatement(sql);
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
				id.close();
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
