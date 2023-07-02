package views.Administrador.GerenciarAluno;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.AdministradorDAO;
import models.Aluno;
import models.Professor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class TelaAdmRegistrarAluno extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtDataNascimento;
	private JTextField txtEndereco;
	private JTextField txtTelefone;
	private JTextField txtResponsavel;
	private JPasswordField pswdSenha;
	private JTextField txtTelefoneResponsavel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAdmRegistrarAluno frame = new TelaAdmRegistrarAluno();
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
	public TelaAdmRegistrarAluno() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Preencha os dados do aluno corretamente.");
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
		
		txtResponsavel = new JTextField();
		txtResponsavel.setBounds(90, 130, 86, 20);
		contentPane.add(txtResponsavel);
		txtResponsavel.setColumns(10);
		
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
		
		JLabel lbResponsavel = new JLabel("Responsável");
		lbResponsavel.setBounds(34, 135, 46, 14);
		contentPane.add(lbResponsavel);
		
		pswdSenha = new JPasswordField();
		pswdSenha.setBounds(90, 67, 86, 17);
		contentPane.add(pswdSenha);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String senha = new String(pswdSenha.getPassword());
				if(!txtNome.getText().isEmpty() && !senha.isEmpty() && (txtCpf.getText().length() == 11 || txtCpf.getText().isEmpty()) && 
						txtDataNascimento.getText().matches("\\d{2}/\\d{2}/\\d{4}") && !txtEndereco.getText().isEmpty()
						&& (txtTelefone.getText().length() == 11 || txtTelefone.getText().length() == 10) && !txtResponsavel.getText().isEmpty() && (txtTelefoneResponsavel.getText().length() == 10 || txtTelefoneResponsavel.getText().length() == 10)) {
					Aluno aluno = new Aluno(txtNome.getText(), senha, txtCpf.getText(), txtDataNascimento.getText(), txtEndereco.getText(), txtTelefone.getText(), txtResponsavel.getText(), txtTelefoneResponsavel.getText());
					AdministradorDAO admDao = new AdministradorDAO();
					if(admDao.registrarAluno(aluno)) {
						TelaAdministradorAluno telaAdmAluno = new TelaAdministradorAluno();
						telaAdmAluno.setVisible(true);
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
				TelaAdministradorAluno telaAdmAluno = new TelaAdministradorAluno();
				telaAdmAluno.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(250, 210, 89, 23);
		contentPane.add(btnVoltar);
		
		JLabel lbTelefoneResponsavel = new JLabel("Telefone do responsável");
		lbTelefoneResponsavel.setBounds(206, 132, 107, 17);
		contentPane.add(lbTelefoneResponsavel);
		
		txtTelefoneResponsavel = new JTextField();
		txtTelefoneResponsavel.setBounds(323, 130, 86, 21);
		contentPane.add(txtTelefoneResponsavel);
		txtTelefoneResponsavel.setColumns(10);
		
		
	}
}
