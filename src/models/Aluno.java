package models;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JOptionPane;
/**Criacao da classe aluno onde irá ser inserido os dados abaixo;<br>*/
public class Aluno extends Pessoa {
	/**<br>Telefone do Aluno;*/
    private String telefone_aluno = "(47) 9 12345678";//(Telefone,E-mail)
    /**<br>Nome do Responsável;*/
    private String responsavel = "Cristina Andrade";
    /**<br>Telefone do Responsável;*/
    private String telefone_responsavel = "(47) 9 87654321";
    
    /**<br> Agora a classe tera os seguintes metodos;*/
    /**<br> Metodo Construtor;*/
    public Aluno(String nome, String senha, String CPF, String dataNascimento, String Endereco, String telefone_aluno,String responsavel,String telefone_responsavel) {
    	this.setNome(nome);
    	this.setSenha(senha);
    	this.setCpf(CPF);
    	this.setDataNascimento(dataNascimento);
    	this.setEndereco(Endereco);
    	this.setTelefone_aluno(telefone_aluno);
    	this.setResponsavel(responsavel);
    	this.setTelefone_responsavel(telefone_responsavel);
    }
    public Aluno(int id, String nome, String senha, String cpf, String dataNascimento, String endereco, String telefone_aluno, String responsavel, String telefone_responsavel) {
    	setId(id);
    	setNome(nome);
    	setSenha(senha);
    	setCpf(cpf);
    	setDataNascimento(dataNascimento);
    	setEndereco(endereco);
    	setTelefone_aluno(telefone_aluno);
    	setResponsavel(responsavel);
    	setTelefone_responsavel(telefone_responsavel);
    }
    
    public Aluno(int id, String nome, String cpf, String dataNascimento, String endereco, String telefone_aluno, String responsavel, String telefone_responsavel) {
    	setId(id);
    	setNome(nome);
    	setCpf(cpf);
    	setDataNascimento(dataNascimento);
    	setEndereco(endereco);
    	setTelefone_aluno(telefone_aluno);
    	setResponsavel(responsavel);
    	setTelefone_responsavel(telefone_responsavel);
    }
    /**<br> Metodo Sobrecarga vazio;*/
    public Aluno() {
    }
    /**<br> Metodo Sobrecarga com alguns atributos;*/    
    public Aluno(String nome, String endereco, String responsavel) {
    	this.setNome(nome);
    	this.setEndereco(endereco);
    	this.setResponsavel(responsavel);
    }
    
	
    /**<br>Metodo que retorna o Telefone do Aluno;*/
    public String getTelefone(){
        return this.telefone_aluno;
    }
    
    /**<br>Metodo que define/altera o Telefone do Aluno;*/
	public void setTelefone_aluno(String telefonealuno) {
        if (telefonealuno.length()==11 || telefonealuno.length() == 10) {
            this.telefone_aluno=telefonealuno;
        }
	}
	
    /**<br>Metodo que define/altera o Nome do Responsavel do Aluno;*/
    public void setResponsavel(String responsavel1){
        if(responsavel1.length()>0) 
            this.responsavel = responsavel1;
        else{
            System.out.println("Digite um nome válido!"); // ADAPTAR PARA A TELA
        }
    }
    
    /**<br>Metodo que retorna o Nome do Responsavel do Aluno;*/
    public String getResponsavel(){
        return this.responsavel;
    }
    
    /**<br>Metodo que retorna o Telefone do Responsavel do Aluno;*/
	public String getTelefone_responsavel() {
		return telefone_responsavel;
	}
	
    /**<br>Metodo que define/altera o Telefone do Responsavel do Aluno;*/
	public void setTelefone_responsavel(String telefoneresponsavel) {
        if (telefoneresponsavel.length()==11 || telefoneresponsavel.length()==10) {
            this.telefone_responsavel=telefoneresponsavel;
        }
	}
}
