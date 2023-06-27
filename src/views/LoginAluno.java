package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.Aluno;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginAluno extends JFrame { // Feito por Gabriely Andrade

	private JPanel contentPane;
	private JPasswordField passwordAluno;
	private JTextField txCPF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginAluno frame = new LoginAluno();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginAluno() {
		/**<br>Criacao do objeto Aluno;*/
		Aluno aluno = new Aluno();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/**<br>Criacao do JLabel para mostrar o que deve ser digitado no JTextField ao lado*/
		JLabel lbLogin = new JLabel("CPF:");
		lbLogin.setBounds(95, 66, 46, 14);
		contentPane.add(lbLogin);
		
		/**<br>Criacao do JLabel para mostrar o que deve ser digitado no JTextField ao lado*/
		JLabel lbSenha = new JLabel("Senha:");
		lbSenha.setBounds(95, 123, 46, 14);
		contentPane.add(lbSenha);
		
		/**<br>Criacao do JPasswordField o usuario digitar a sua senha e a mesma ser censurada*/
		passwordAluno = new JPasswordField();
		passwordAluno.setBounds(138, 120, 207, 20);
		contentPane.add(passwordAluno);
		
		/**<br>Criacao do JTextField para digitar o CPF do aluno, que é utilizada como login*/
		txCPF = new JTextField();
		txCPF.setBounds(138, 63, 207, 20);
		contentPane.add(txCPF);
		txCPF.setColumns(10);
		
		/**<br>Criacao do JButton para realizar o login*/
		JButton btEntrar = new JButton("Logar");
		/**<br>Criacao do Evento relacionado a botao Entrar;*/
		btEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txCPF.equals(aluno.getCpf()) && passwordAluno.toString().equals(aluno.getDataNascimento())) {
					TelaAluno telaEstudante = new TelaAluno();
					telaEstudante.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Senha incorreta");
				}
			}
		});
		btEntrar.setBounds(256, 174, 89, 23);
		contentPane.add(btEntrar);
		
		/**<br>Criacao do JButton para realizar o login*/
		JButton btVoltar = new JButton("Voltar");
		/**<br>Criacao do Evento relacionado a botao Voltar;*/
		btVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login telaLogin = new Login();
				telaLogin.setVisible(true);
			}
		});
		btVoltar.setBounds(138, 174, 89, 23);
		contentPane.add(btVoltar);
	}
}
