package views;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {// Feito por Gabriely e Tomás

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/**<br>Criacao do JButton Estudante;*/
		JButton btnEstudante = new JButton("Estudante");
		/**<br>Criacao do Evento relacionado a botao Estudante;*/
		btnEstudante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginAluno loginAluno = new LoginAluno();
				loginAluno.setVisible(true);
				dispose();
			}
		});
		btnEstudante.setBounds(162, 110, 100, 33);
		contentPane.add(btnEstudante);

		/**<br>Criacao do JButton Professor;*/
		JButton btnProfessor = new JButton("Professor");
		/**<br>Criacao do Evento relacionado a botao Professor;*/
		btnProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginProfessor telaProf = new LoginProfessor();
				telaProf.setVisible(true);
				dispose();
			}
		});
		btnProfessor.setBounds(162, 154, 100, 33);
		contentPane.add(btnProfessor);
		
		/**<br>Criacao do JLabel para mostrar a mensagem na tela*/
		JLabel lblNewLabel = new JLabel("Selecione o tipo de conta que deseja acessar");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(53, 35, 341, 30);
		contentPane.add(lblNewLabel);
		
		/**<br>Criacao do JButton Administrador;*/
		JButton btnAdministrador = new JButton("Administrador");
		/**<br>Criacao do Evento relacionado a botao Administrador;*/
		btnAdministrador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TelaAdm telaAdministrador = new TelaAdm();
				//telaAdministrador.setVisible(true);
			}
		});
		btnAdministrador.setBounds(162, 198, 100, 33);
		contentPane.add(btnAdministrador);
	}
}
