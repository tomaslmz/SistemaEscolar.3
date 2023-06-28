package views.Administrador;

import data.AdministradorDAO;
import views.Login;
import views.Administrador.GerenciarProfessor.TelaAdministradorProfessor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaAdministrador extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAdministrador frame = new TelaAdministrador();
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
	public TelaAdministrador() {
		AdministradorDAO admDAO = new AdministradorDAO();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Olá! Seja bem-vindo ao sistema.");
		lblNewLabel.setBounds(115, 11, 196, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Escolha a função que deseja usar:");
		lblNewLabel_1.setBounds(126, 82, 171, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnProfessores = new JButton("Gerenciar professores");
		btnProfessores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAdministradorProfessor telaAdmProf = new TelaAdministradorProfessor();
				telaAdmProf.setVisible(true);
				dispose();
			}
		});
		btnProfessores.setBounds(42, 147, 155, 43);
		contentPane.add(btnProfessores);
		
		JButton btnAlunos = new JButton("Gerenciar alunos");
		btnAlunos.setBounds(232, 147, 155, 43);
		contentPane.add(btnAlunos);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.setVisible(true);
				dispose();
			}
		});
		btnSair.setBounds(167, 216, 89, 23);
		contentPane.add(btnSair);
	}
}
