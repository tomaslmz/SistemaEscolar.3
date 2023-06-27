package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.Professor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginProfessor extends JFrame {//Feito por Tomás

	private JPanel contentPane;
	private JTextField txtCpf;
	private JPasswordField pswdSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginProfessor frame = new LoginProfessor();
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
	public LoginProfessor() {
		
		/**<br>Definindo as labels*/
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CPF:");
		lblNewLabel.setBounds(126, 67, 34, 26);
		contentPane.add(lblNewLabel);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(170, 70, 125, 20);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);
		
		pswdSenha = new JPasswordField();
		pswdSenha.setBounds(170, 118, 125, 20);
		contentPane.add(pswdSenha);
		
		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setBounds(114, 121, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		/**<br>Definindo o botão de Entrar*/
		JButton btnEntrar = new JButton("Entrar");
		/**<br>Definindo a ação do botão*/
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtCpf.getText().isEmpty() || pswdSenha.getPassword().toString().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Os credenciais não podem estar vazios!");
				} else {
					Professor professor = new Professor();
					if(professor.getCpf().equals(txtCpf.getText())) {
						if(String.valueOf(pswdSenha.getPassword()).equals(professor.getSenha())) {
							
							TelaProfessor telaProfessor = new TelaProfessor();
							telaProfessor.setVisible(true);
							dispose();
						} else {
							JOptionPane.showMessageDialog(null, "Senha incorreta!");
						}
					} else {
						JOptionPane.showMessageDialog(null, "CPF inválido!");
					}
				}
			}
		});
		btnEntrar.setBounds(225, 190, 117, 42);
		contentPane.add(btnEntrar);
		/**<br>Definindo o botão voltar*/
		JButton btnVoltar = new JButton("Voltar");
		/**<br>Definindo a ação do botão*/
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login telaLogin = new Login();
				telaLogin.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(84, 190, 117, 42);
		contentPane.add(btnVoltar);
	}
}
