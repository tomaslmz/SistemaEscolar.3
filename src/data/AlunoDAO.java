package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Aluno;

public class AlunoDAO {

	public ArrayList<Aluno> listarAlunos(Aluno a){
		String mySql = "select nome,cpf,dataNascimento,endereco,telefoneAluno,nomeResponsavel,telefoneResponsavel,curso from Aluno where nome = ?";
		//Conectar ao Banco de Dados
		Conexao conexao = new Conexao();
		Connection id = conexao.conectar();
		//Comando SQL
		try {
			PreparedStatement execucao = id.prepareStatement(mySql);
			execucao.setString(1, a.getNome());;
			//Executa o SELECTe devolve o resultado, guarda no objeto "resultado"
			ResultSet resultadoSelect = execucao.executeQuery();
			
			ArrayList<Aluno>informacoesAluno = new ArrayList<Aluno>();
			Aluno pRead = new Aluno();
			//Pegar todos os valores da primeira linha...
			while(resultadoSelect.next()) {
				pRead.setNome(resultadoSelect.getString("nome"));
				pRead.setNome(resultadoSelect.getString("cpf"));
				pRead.setNome(resultadoSelect.getString("dataNascimento"));
				pRead.setNome(resultadoSelect.getString("endereco"));
				pRead.setNome(resultadoSelect.getString("telefone"));
				pRead.setNome(resultadoSelect.getString("responsavel"));
				pRead.setNome(resultadoSelect.getString("telefoneResponsavel"));
				informacoesAluno.add(pRead);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
}
