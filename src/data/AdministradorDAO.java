package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Aluno;
import models.Professor;
//Feito por Tomás

/**
 * Criacao da classe AdministradorDAO onde tera os metodos com integracao ao banco de dados;<br>
 * */
public class AdministradorDAO {
	
	/**
	 * Metodo para criar um aluno<br>
	 * */
	public boolean registrarAluno(Aluno a) {
		String sql = "INSERT INTO Alunos (nome, senha, cpf, dataNascimento, endereco, telefone, responsavel, telefoneResponsavel) VALUES"
				+ "(?, ?, ?, ?, ?, ?, ?, ?)";
		
		Conexao conexao = new Conexao();
		Connection id = conexao.conectar();
		
		try {
			PreparedStatement command = id.prepareStatement(sql);
			command.setString(1, a.getNome());
			command.setString(2, a.getSenha());
			command.setString(3, a.getCpf());
			command.setString(4, a.getDataNascimento());
			command.setString(5, a.getEndereco());
			command.setString(6, a.getTelefone());
			command.setString(7, a.getResponsavel());
			command.setString(8, a.getTelefone_responsavel());
			command.execute();
			id.close();
			return true;
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Metodo para apagar o aluno;<br>
	 * */
	
	public void apagarAluno(int pid) {
		String sql = "DELETE FROM Alunos WHERE id = ?";
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
	
	/**
	 * Metodo para atualizar um aluno;<br>
	 * */
	
	public void atualizarAluno(Aluno a) {
		String sql = "UPDATE Alunos SET nome = ?, cpf = ?, dataNascimento = ?, endereco = ?, telefone = ?, responsavel = ?, telefoneResponsavel = ? WHERE id = ?";
		
		Conexao conexao = new Conexao();
		Connection id = conexao.conectar();
		
		try {
			PreparedStatement command = id.prepareStatement(sql);
			command.setString(1, a.getNome());
			command.setString(2, a.getCpf());
			command.setString(3, a.getDataNascimento());
			command.setString(4, a.getEndereco());
			command.setString(5, a.getTelefone());
			command.setString(6, a.getResponsavel());
			command.setString(7, a.getTelefone_responsavel());
			command.setInt(8, a.getId());
			command.executeUpdate();
			id.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo para selecionar os alunos;<br>
	 * */
	
	public ArrayList<Aluno> selecionarAlunos() {
		String sql = "SELECT id, nome, cpf, dataNascimento, endereco, telefone, responsavel, telefoneResponsavel FROM Alunos";
		
		Conexao conexao = new Conexao();
		Connection id = conexao.conectar();
		
		ResultSet result = null;
		ArrayList<Aluno> listaAluno = new ArrayList<Aluno>();
		
		
		try {
			PreparedStatement command = id.prepareStatement(sql);
			result = command.executeQuery();
			
			while(result.next()) {
				listaAluno.add(new Aluno(result.getInt("id"), result.getString("nome"), result.getString("cpf"), 
						result.getString("dataNascimento"), result.getString("endereco"), result.getString("telefone"), 
						result.getString("responsavel"), result.getString("telefoneResponsavel")));
			}
			
			id.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return listaAluno;
	}
	
	
	/**
	 * Metodo para atualizar os professores;<br>
	 * */
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
	
	/**
	 * Metodo para registrar o professor;<br>
	 * */
	
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
			return false;
		}
		
	}
	
	/**
	 * Metodo para apagar o professor;<br>
	 * */
	
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
	
	
	/**
	 * Metodo para selecionar os professores;<br>
	 * */
	
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
	
	/**
	 * Metodo para comparar os logins;<br>
	 * */
	
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
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return false;
	}
}
