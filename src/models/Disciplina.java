package models;

import java.util.ArrayList;
/**Criacao da classe Disciplinas onde iremos inserir os dados*/
public class Disciplina {
	/**<br>Inicio da declaracao dos dados do Disciplina*/
	private int id;
	/**<br>Nome do Disciplina*/
	private String nome;
	/**<br>ID do professor da disciplina*/
	private int idProfessor;
	
	private String nomeProfessor;

	/**<br>Agora, a classe tera os seguintes metodos:*/
	/**<br>Metodo construtor*/
	public Disciplina(int id, String nome, int idProfessor) {
		setId(id);
		setNome(nome);
		setIdProfessor(idProfessor);
	}
	
	/**Metodo sobrecarga*/
	public Disciplina(String nome, int idProfessor) {
		setNome(nome);
		setIdProfessor(idProfessor);
	}
	
	public Disciplina(int id, String nome, String nomeProfessor) {
		setId(id);
		setNome(nome);
		setNomeProfessor(nomeProfessor);
	}
	
	public void setId(int id) {
		if(id >= 0) {
			this.id = id;
		}
	}
	
	public void setNomeProfessor(String nome) {
		nomeProfessor = nome;
	}
	
	public String getNomeProfessor() {
		return nomeProfessor;
	}
	
	public int getId() {
		return id;
	}
	
	/**<br>Definir o nome do Disciplina*/
	public void setNome(String nome) {
		if(!nome.isEmpty()) {
			this.nome = nome;
		}
	}
	
	/**<br>Obter o nome do Disciplina*/
	public String getNome() {
		return nome;
	}
	
	public void setIdProfessor(int id) {
		if(id > -1) {
			this.idProfessor = id;
		}
	}
	
	public int getIdProfessor() {
		return idProfessor;
	}
}