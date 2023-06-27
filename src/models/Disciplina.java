package models;

import java.util.ArrayList;
/**Criacao da classe Cursos onde iremos inserir os dados*/
public class Disciplina {
	/**<br>Inicio da declaracao dos dados do curso*/
	/**<br>Nome do curso*/
	private String nome;
	/**<br>Duracao do curso*/
	private int duracao;
	/**<br>Aluno do curso*/
	private Aluno aluno;
	/**<br>Alunos do curso*/
	private ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	/**<br>Professor do curso*/
	private Professor professor;
	
	/**<br>Agora, a classe tera os seguintes metodos:*/
	/**<br>Metodo construtor*/
	public void Curso(String nome, int duracao) {
		this.nome = nome;
		this.duracao = duracao;
	}
	
	/**Metodo sobrecarga*/
	public void Curso(String nome) {
		this.nome = nome;
	}
	/**<br>Definir o nome do curso*/
	public void setNome(String nome) {
		if(!nome.isEmpty()) {
			this.nome = nome;
		}
	}
	
	/**<br>Obter o nome do curso*/
	public String getNome() {
		return nome;
	}
	
	/**<br>Definir a duracao do curso*/
	public void setDuracao(int duracao) {
		if(duracao > 0) {
			this.duracao = duracao;
		}
	}
	
	/**<br>Obter a duracao do curso*/
	public int getDuracao() {
		return duracao;
	}
	
	/**<br>Definir o aluno do curso*/
	public void setAluno(Aluno aluno) {
		this.alunos.add(aluno);
	}
	
	/**<br>Obter o nome dos alunos*/
	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}
	
	/**<br>Obter o nome de algum aluno*/
	public Aluno getAlunoEspecifico(int i) {
		return alunos.get(i);
	}
	
	/**<br>Definir o professor do curso*/
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	/**<br>Obter o nome do professor*/
	public Professor getProfessor() {
		return professor;
	}
}