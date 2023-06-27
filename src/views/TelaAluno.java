package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.Aluno;

import javax.swing.JLabel;
/**
 * Criacao da classe TelaAluno onde sera demonstrado os dados cadastrados pelo Administrador;<br>
 * */
public class TelaAluno extends JFrame { // Feito por Gabriely Andrade

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAluno frame = new TelaAluno();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Criacao do frame.
	 */
	public TelaAluno() {
		/**<br>Criacao do objeto Aluno;*/
		Aluno aluno = new Aluno();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/**<br>Criacao do JLabel para mostrar o nome do aluno na tela*/
		JLabel lbNome = new JLabel("Nome: "+ aluno.getNome());
		lbNome.setBounds(75, 30, 333, 14);
		contentPane.add(lbNome);
		
		/**<br>Criacao do JLabel para mostrar o CPF do aluno na tela*/
		JLabel lbCPF = new JLabel("CPF: "+ aluno.getCpf());
		lbCPF.setBounds(75, 55, 333, 14);
		contentPane.add(lbCPF);
		
		/**<br>Criacao do JLabel para mostrar a data de nascimento do aluno na tela*/
		JLabel lbDataNascimento = new JLabel("Data de Nascimento: "+ "06/01/2003" );
		lbDataNascimento.setBounds(75, 80, 333, 14);
		contentPane.add(lbDataNascimento);
		
		/**<br>Criacao do JLabel para mostrar o endereco do aluno na tela*/
		JLabel lbEndereco = new JLabel("Endereco: "+ aluno.getEndereco() );
		lbEndereco.setBounds(75, 105, 333, 14);
		contentPane.add(lbEndereco);
		
		/**<br>Criacao do JLabel para mostrar o telefone do aluno na tela*/
		JLabel lbTelefone = new JLabel("Telefone: "+ aluno.getTelefone() );
		lbTelefone.setBounds(75, 130, 333, 14);
		contentPane.add(lbTelefone);
		
		/**<br>Criacao do JLabel para mostrar o nome do responsavel do aluno na tela*/
		JLabel lbNomeResponsavel = new JLabel("Nome Responsavel: "+ aluno.getResponsavel());
		lbNomeResponsavel.setBounds(75, 155, 333, 14);
		contentPane.add(lbNomeResponsavel);
		
		/**<br>Criacao do JLabel para mostrar o telefone do responsavel do aluno na tela*/
		JLabel lbTelefoneResponsavel = new JLabel("Telefone Responsável: "+ aluno.getTelefone_responsavel());
		lbTelefoneResponsavel.setBounds(75, 180, 333, 14);
		contentPane.add(lbTelefoneResponsavel);
	}
}
