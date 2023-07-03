package models;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JOptionPane;

public class Pessoa {
	private int id;
	/**Aqui iremos inserir os seguintes dados de uma pessoa:<br> Nome da pessoa;*/
	private String nome;
	/**<br>Senha da pessoa;*/
	private String senha;
	/**<br>CPF da pessoa;*/
	private String cpf;
	/**<br>Data de nascimento da pessoa;*/
	private Calendar dataNascimento;
	/**<br>Endereco da pessoa;*/
	private String endereco;
	/**<br>Telefone da pessoa;*/
	private String telefone;
	
	/**<br>Método para definir o id da pessoa;*/
	public void setId(int id) {
    	this.id = id;   	
    }
    
	/**<br>Método para obter o id da pessoa;*/
    public int getId() {
    	return id;
    }
    
	/**<br>Metodo para retornar o nome da pessoa;*/
	public String getNome() {
		return nome;
	}
	
	/**<br>Metodo para definir o nome da pessoa;*/
	public void setNome(String nome) {
		if(!nome.isEmpty()) {
			this.nome = nome;
		} else {
			JOptionPane.showMessageDialog(null, "Nome inválido!");
		}
	}
	
	/**<br>Metodo para retornar a senha da pessoa;*/
	public String getSenha() {
		return senha;
	}
	
	/**<br>Metodo para definir a senha da pessoa;*/
	public void setSenha(String senha) {
		/*if(senha.matches("?=^.{8,}$)(?=.*\\d)(?=.*[!@#$%^&*]+)(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$") {
		 * this.senha = senha;
		 * }*/
		this.senha = senha;
	}
	
	/**<br>Metodo para comparar a senha atual da pessoa;*/
	public boolean checkSenha(String senha) {
		if(senha.equals(this.senha)) {
			this.senha = senha;
			return true;
		}
		return false;
	}
	
	/**<br>Metodo para retornar o CPF da pessoa;*/
	public String getCpf() {
		return cpf;
	}
	
	/**<br>Metodo para definir o CPF da pessoa;*/
	public void setCpf(String cpf) {
		if(cpf.length() == 11) {
			this.cpf = cpf;
		}
	}
	
	/**<br>Metodo para retornar a data de nascimento da pessoa;*/
	public String getDataNascimento() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return "" + sdf.format(dataNascimento.getTime());
	}
	
	/**<br>Metodo para definir a data de nascimento da pessoa;*/
	public void setDataNascimento(String dataNascimento) {
		String array[] = new String[3];
		
		if(dataNascimento.matches("\\d{2}/\\d{2}/\\d{4}")) {
			array = dataNascimento.split("/");
			Calendar data = Calendar.getInstance();
			
			int dia = Integer.parseInt(array[0]);
			int mes = Integer.parseInt(array[1]);
			int ano = Integer.parseInt(array[2]);
			
			data.set(ano, mes-1, dia);
			
			this.dataNascimento = data;
		} else if(dataNascimento.matches("([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))")) {
			array = dataNascimento.split("-");
			Calendar data = Calendar.getInstance();
			
			int dia = Integer.parseInt(array[2]);
			int mes = Integer.parseInt(array[1]);
			int ano = Integer.parseInt(array[0]);
			
			data.set(ano, mes-1, dia);
			
			this.dataNascimento = data;
		} else {
			JOptionPane.showMessageDialog(null, "Data de nascimento inválida!");
		}
	}
	
	/**<br>Metodo para retornar o endereco da pessoa;*/
	public String getEndereco() {
		return endereco;
	}
	
	/**<br>Metodo para definir o endereco da pessoa;*/
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	/**<br>Metodo para retornar o número de telefone da pessoa;*/
	public String getTelefone() {
		return telefone;
	}
	
	/**<br>Metodo para definir o número de telefone da pessoa;*/
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
