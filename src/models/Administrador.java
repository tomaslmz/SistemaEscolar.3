package models;

/**Criacao da classe Administrador que tera a permissao para registrar professores e alunos.*/
public class Administrador {
	/**<br>Os seguintes dados serao de login: */
	private String usuario = "admin";
	private String senha = "admin";
	
	/**<br>Funcao para retornar o usuario do Administrador.*/
	public String getUsuario() {
		return usuario;
	}
	
	/**<br>Funcao para retornar a senha do usuario Administrador.*/
	public String getSenha() {
		return senha;
	}
}