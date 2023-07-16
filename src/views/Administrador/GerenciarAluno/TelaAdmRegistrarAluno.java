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
		/**
		 * Configuracoes da tela;<br>
		 * */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Preencha os dados do aluno corretamente.");
		lblNewLabel.setBounds(179, 10, 230, 14);
		contentPane.add(lblNewLabel);
		
		txtNome = new JTextField();
		txtNome.setBounds(156, 35, 86, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(156, 97, 86, 20);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);
		
		txtDataNascimento = new JTextField();
		txtDataNascimento.setBounds(346, 35, 105, 20);
		contentPane.add(txtDataNascimento);
		txtDataNascimento.setColumns(10);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(346, 66, 105, 20);
		contentPane.add(txtEndereco);
		txtEndereco.setColumns(10);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(346, 97, 105, 20);
		contentPane.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		txtResponsavel = new JTextField();
		txtResponsavel.setBounds(156, 129, 86, 20);
		contentPane.add(txtResponsavel);
		txtResponsavel.setColumns(10);
		
		JLabel lbNome = new JLabel("Nome");
		lbNome.setBounds(100, 37, 46, 14);
		contentPane.add(lbNome);
		
		JLabel lbSenha = new JLabel("Senha");
		lbSenha.setBounds(100, 71, 46, 14);
		contentPane.add(lbSenha);
		
		JLabel lbCpf = new JLabel("CPF");
		lbCpf.setBounds(100, 100, 46, 14);
		contentPane.add(lbCpf);
		
		JLabel lbDataNascimento = new JLabel("Data de nascimento");
		lbDataNascimento.setBounds(461, 36, 133, 14);
		contentPane.add(lbDataNascimento);
		
		JLabel lbEndereco = new JLabel("Endereço");
		lbEndereco.setBounds(461, 73, 133, 14);
		contentPane.add(lbEndereco);
		
		JLabel lbTelefone = new JLabel("Telefone");
		lbTelefone.setBounds(461, 104, 133, 14);
		contentPane.add(lbTelefone);
		
		JLabel lbResponsavel = new JLabel("Responsável");
		lbResponsavel.setBounds(100, 134, 46, 14);
		contentPane.add(lbResponsavel);
		
		pswdSenha = new JPasswordField();
		pswdSenha.setBounds(156, 66, 86, 17);
		contentPane.add(pswdSenha);
		
		/**
		 * Inicio dos botoes para as funcionalidades da pagina;<br>
		 * */
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String senha = new String(pswdSenha.getPassword());
				if(!txtNome.getText().isEmpty() && !senha.isEmpty() && txtCpf.getText().length() == 11 && 
						txtDataNascimento.getText().matches("\\d{2}/\\d{2}/\\d{4}") && !txtEndereco.getText().isEmpty()
						&& (txtTelefone.getText().length() == 11 || txtTelefone.getText().length() == 10) && !txtResponsavel.getText().isEmpty() && (txtTelefoneResponsavel.getText().length() == 10 || txtTelefoneResponsavel.getText().length() == 11)) {
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
		btnRegistrar.setBounds(179, 172, 89, 23);
		contentPane.add(btnRegistrar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAdministradorAluno telaAdmAluno = new TelaAdministradorAluno();
				telaAdmAluno.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(329, 172, 89, 23);
		contentPane.add(btnVoltar);
		
		JLabel lbTelefoneResponsavel = new JLabel("Telefone do responsável");
		lbTelefoneResponsavel.setBounds(461, 132, 133, 17);
		contentPane.add(lbTelefoneResponsavel);
		
		txtTelefoneResponsavel = new JTextField();
		txtTelefoneResponsavel.setBounds(346, 129, 105, 21);
		contentPane.add(txtTelefoneResponsavel);
		txtTelefoneResponsavel.setColumns(10);
		
		
	}
}
