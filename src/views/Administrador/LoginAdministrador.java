package views.Administrador;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import data.Conexao;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.AdministradorDAO;
import models.Professor;
import views.Login;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
/**
 * Criacao da classe LoginAdministrador onde sera inserido os dados para realizar o login;<br>
 * */
public class LoginAdministrador extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField pswdSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginAdministrador frame = new LoginAdministrador();
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
	public LoginAdministrador() {
		/**
		 * Ligacao com o banco de dados;<br>
		 * */
		Conexao conexao = new Conexao();
		Connection id = conexao.conectar();
		/**
		 * Configuracoes da tela;<br>
		 * */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuário:");
		lblNewLabel.setBounds(114, 67, 46, 26);
		contentPane.add(lblNewLabel);
		
		txtUser = new JTextField();
		txtUser.setBounds(170, 70, 125, 20);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
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
				String pswd = new String(pswdSenha.getPassword());
				AdministradorDAO adm = new AdministradorDAO();
				if(adm.compararLogin(txtUser.getText(), pswd)) {
					TelaAdministrador tela = new TelaAdministrador();
					tela.setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Dados incorretos!");
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
