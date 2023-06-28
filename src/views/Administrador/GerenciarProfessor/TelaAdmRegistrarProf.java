package views.Administrador.GerenciarProfessor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.AdministradorDAO;
import models.Professor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class TelaAdmRegistrarProf extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtDataNascimento;
	private JTextField txtEndereco;
	private JTextField txtTelefone;
	private JTextField txtSalario;
	private JPasswordField pswdSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAdmRegistrarProf frame = new TelaAdmRegistrarProf();
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
	public TelaAdmRegistrarProf() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Preencha os dados do professor corretamente.");
		lblNewLabel.setBounds(100, 11, 230, 14);
		contentPane.add(lblNewLabel);
		
		txtNome = new JTextField();
		txtNome.setBounds(90, 36, 86, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(90, 98, 86, 20);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);
		
		txtDataNascimento = new JTextField();
		txtDataNascimento.setBounds(323, 36, 86, 20);
		contentPane.add(txtDataNascimento);
		txtDataNascimento.setColumns(10);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(323, 67, 86, 20);
		contentPane.add(txtEndereco);
		txtEndereco.setColumns(10);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(323, 98, 86, 20);
		contentPane.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		txtSalario = new JTextField();
		txtSalario.setBounds(182, 147, 86, 20);
		contentPane.add(txtSalario);
		txtSalario.setColumns(10);
		
		JLabel lbNome = new JLabel("Nome");
		lbNome.setBounds(34, 36, 46, 14);
		contentPane.add(lbNome);
		
		JLabel lbSenha = new JLabel("Senha");
		lbSenha.setBounds(34, 70, 46, 14);
		contentPane.add(lbSenha);
		
		JLabel lbCpf = new JLabel("CPF");
		lbCpf.setBounds(34, 101, 46, 14);
		contentPane.add(lbCpf);
		
		JLabel lbDataNascimento = new JLabel("Data de nascimento");
		lbDataNascimento.setBounds(211, 39, 102, 14);
		contentPane.add(lbDataNascimento);
		
		JLabel lbEndereco = new JLabel("Endereço");
		lbEndereco.setBounds(267, 70, 46, 14);
		contentPane.add(lbEndereco);
		
		JLabel lbTelefone = new JLabel("Telefone");
		lbTelefone.setBounds(267, 101, 46, 14);
		contentPane.add(lbTelefone);
		
		JLabel lbSalario = new JLabel("Salário");
		lbSalario.setBounds(130, 150, 46, 14);
		contentPane.add(lbSalario);
		
		pswdSenha = new JPasswordField();
		pswdSenha.setBounds(90, 67, 86, 17);
		contentPane.add(pswdSenha);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String senha = new String(pswdSenha.getPassword());
				if(!txtNome.getText().isEmpty() && !senha.isEmpty() && txtCpf.getText().length() == 11 && 
					txtDataNascimento.getText().matches("\\d{2}/\\d{2}/\\d{4}") && !txtEndereco.getText().isEmpty()
					&& (txtTelefone.getText().length() == 11 || txtTelefone.getText().length() == 10) && Float.parseFloat(txtSalario.getText()) > 0) {
					Professor prof = new Professor(txtNome.getText(), senha, txtCpf.getText(), txtDataNascimento.getText(), 
							txtEndereco.getText(), txtTelefone.getText(), Float.parseFloat(txtSalario.getText()));
					AdministradorDAO admDao = new AdministradorDAO();
					if(admDao.registrarProfessor(prof)) {
						TelaAdministradorProfessor telaAdmProf = new TelaAdministradorProfessor();
						telaAdmProf.setVisible(true);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Algo deu errado!");
					}
					
				} else {
					JOptionPane.showMessageDialog(null, "Verifique se os dados estão corretos!");
				}
			}
		});
		btnRegistrar.setBounds(100, 210, 89, 23);
		contentPane.add(btnRegistrar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAdministradorProfessor telaAdmProf = new TelaAdministradorProfessor();
				telaAdmProf.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(250, 210, 89, 23);
		contentPane.add(btnVoltar);
		
		
	}
}
