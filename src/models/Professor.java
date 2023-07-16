package models;

/**Criacao da classe professor onde iremos inserir os dados. <br>*/
public class Professor extends Pessoa {//Feito por Tomas
	/**<br>Salario do professor;*/
	private float salario;
	
	
	/**<br>Agora, a classe tera os seguintes Metodos:*/
	/**<br>Metodo construtor;*/
	public Professor(String nome, String senha, String cpf, String dataNascimento, String endereco, 
			String telefone, float salario) {
		setNome(nome);
		setSenha(senha);
		setCpf(cpf);
		setDataNascimento(dataNascimento);
		setEndereco(endereco);
		setTelefone(telefone);
		setSalario(salario);
	}
	
	public Professor(int id, String nome, String cpf, String dataNascimento, String endereco, 
			String telefone, float salario) {
		setId(id);
		setNome(nome);
		setCpf(cpf);
		setDataNascimento(dataNascimento);
		setEndereco(endereco);
		setTelefone(telefone);
		setSalario(salario);
	}
	
	public Professor(String nome, String cpf, String dataNascimento, String endereco, 
			String telefone, float salario) {
		setNome(nome);
		setCpf(cpf);
		setDataNascimento(dataNascimento);
		setEndereco(endereco);
		setTelefone(telefone);
		setSalario(salario);
	}
	
    /**<br> Metodo Sobrecarga;*/    
    public Professor(String nome, String Endereco, Float salario) {
    	this.setNome(nome);
    	this.setEndereco(Endereco);
    	this.setSalario(salario);
    }
    /**<br> Metodo sobrecarga vazio*/
    public Professor() {
    	
    }
	
	/**<br>Metodo para retornar o salario do professor;*/
	public float getSalario() {
		return salario;
	}
	
	/**<br>Metodo para definir o salario do professor;*/
	public void setSalario(float salario) {
		this.salario = salario;
	}
}
