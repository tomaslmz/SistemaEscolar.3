package models;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JOptionPane;
/**Criacao da classe aluno onde irá ser inserido os dados abaixo;<br>*/
public class Aluno {
	/**Inicio da declaração dos dados do aluno; <br>*/
	private int id;
	/**<br>Nome do Aluno;*/
	private String nome = "Gabriely Andrade"; 
	
	private String senha;
	/**<br>CPF do Aluno;*/
	private String cpf = "12345678978";
	/**<br>Data de Nascimento de Aluno;*/
	private Calendar dataNascimento; // 06/01/2003 -> SENHA DO ALUNO
	/**<br>Endereco do Aluno;*/
	private String endereco = "Rua Cecilia Rosa Eberle, 40";//(Rua,Número,Bairro,Cidade)
	/**<br>Telefone do Aluno;*/
    private String telefone_aluno = "(47) 9 12345678";//(Telefone,E-mail)
    /**<br>Nome do Responsável;*/
    private String responsavel = "Cristina Andrade";
    /**<br>Telefone do Responsável;*/
    private String telefone_responsavel = "(47) 9 87654321";
    /**<br>Curso do Aluno;*/
    private Disciplina curso;
    /**<br>Cursos do Aluno;*/
    private ArrayList<Disciplina> cursos = new ArrayList<Disciplina>(); 
    
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
    
	public void setId(int id) {
    	this.id = id;
    }
    
    public int getId() {
    	return id;
    }
    
    /**<br> Metodo para alterar/definir o Nome do Aluno;*/ 
    public void setNome(String nome1){
        if(nome1.length()>0) 
            this.nome = nome1;
        else{
            System.out.println("Digite um nome válido!"); // ADAPTAR PARA A TELA
        }
    }
    
    /**<br> Metodo para retornar o Nome do Aluno;*/
    public String getNome(){
        return this.nome;
    }
    
    public void setSenha(String senha) {
    	this.senha = senha;
    }
    
    public String getSenha() {
    	return senha;
    }
    
    /**<br>Metodo para alterar/definir o CPF do aluno;*/
    public void setCpf(String cpf1){
        if (cpf1.length()==11) {
            this.cpf=cpf1;
        }else{
            this.cpf = "NÃO TEM";// ADAPTAR PARA A TELA
        }
    }
    
    /**<br>Metodo para retornar o CPF do Aluno;*/
    public String getCpf(){
        return this.cpf;
    }
    
    /**<br>Metodo para alterar/definir a Data de Nascimento do Aluno;*/
    /**<br>Metodo para retornar a data de nascimento do aluno;*/
	public String getDataNascimento() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return "" + sdf.format(dataNascimento.getTime());
	}
	
	/**<br>Metodo para definir a data de nascimento do aluno;*/
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
    
    /**<br>Metodo que define/altera o Endereco do Aluno;*/
    public void setEndereco(String endereco1){
        if (endereco1.length()>0) {
            this.endereco=endereco1;
           }
        else{
            System.out.println("Digite um endereço válido!");
        }
    }
    
    /**<br>Metodo que retorna o Endereco do Aluno;*/
    public String getEndereco(){
        return this.endereco;
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
	
	/**<br>Metodo para definir o curso;*/
	public void setCurso(Disciplina curso) {
		cursos.add(curso);
	}
	
	/**<br>Metodo para retornar curso especifico;*/
	public Disciplina getCursoEspecifico(int i) {
		return cursos.get(i);
	}
	
	/**<br>Metodo para retornar os cursos;*/
	public ArrayList<Disciplina> getCursos() {
		return cursos;
	}
}
