package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import models.Aluno;

/**
* Criacao da classe AlunoDAO;<br>
**/

public class AlunoDAO {
	
	/**
	 * Metodo para listar os alunos;<br>
	 * */
	public ArrayList<Aluno> listarAlunos(){
		String mySql = "select nome,cpf,dataNascimento,endereco,telefone,Responsavel,telefoneResponsavel from Alunos";
		//Conectar ao Banco de Dados
		Conexao conexao = new Conexao();
		Connection id = conexao.conectar();
		//Comando SQL
		ArrayList<Aluno>informacoesAluno = new ArrayList<Aluno>();
		/**
		 * Tratamento de exceções<br> 
		 **/
		try {
			PreparedStatement execucao = id.prepareStatement(mySql);;
			/**
			 * Executa o SELECTe devolve o resultado, guarda no objeto "resultado"<br>
			 **/
			ResultSet resultadoSelect = execucao.executeQuery();
			
			
			Aluno pRead = new Aluno();
			//Pegar todos os valores da primeira linha...
			while(resultadoSelect.next()) {
				pRead.setNome(resultadoSelect.getString("nome"));
				//System.out.println(resultadoSelect.getString("nome"));
				pRead.setCpf(resultadoSelect.getString("cpf"));
				//System.out.println(resultadoSelect.getString("cpf"));
				pRead.setDataNascimento(resultadoSelect.getString("dataNascimento"));
				//System.out.println(resultadoSelect.getString("dataNascimento"));
				pRead.setEndereco(resultadoSelect.getString("endereco"));
				//System.out.println(resultadoSelect.getString("endereco"));
				pRead.setTelefone(resultadoSelect.getString("telefone"));
				//System.out.println(resultadoSelect.getString("telefone"));
				pRead.setResponsavel(resultadoSelect.getString("responsavel"));
				//System.out.println(resultadoSelect.getString("responsavel"));
				//System.out.println(resultadoSelect.getString("telefoneResponsavel"));
				informacoesAluno.add(pRead);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Erro"+ e);
		}
		
		return informacoesAluno;
		
	}
	/**
	 * Metodo para comparar o login;<br>
	 * */
	public boolean compararLogin(Aluno a) {
		String sql = "SELECT cpf, senha FROM Alunos WHERE cpf = ? AND senha = ?";
		
		Conexao conexao = new Conexao();
		Connection id = conexao.conectar();
		
		ResultSet result = null;
		
		try {
			PreparedStatement command = id.prepareStatement(sql);
			command.setString(1, a.getCpf());
			command.setString(2, a.getSenha());
			result = command.executeQuery();
		} catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao procurar o aluno!");
			return false;
		}
		
		try {
			if(result.next()) {
				if(result.getString("cpf").equals(a.getCpf())) {
					if(result.getString("senha").equals(a.getSenha())) {
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
			JOptionPane.showMessageDialog(null, "Não foi possível encontrar o aluno!");
			return false;
		}
		return false;
	}
}
