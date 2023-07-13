package views.Administrador.GerenciarAluno;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import data.AdministradorDAO;
import models.Aluno;
import models.Professor;

import javax.swing.JButton;
import javax.swing.JTextField;

public class TelaAdmAtualizarAluno extends JFrame {

	private JPanel contentPane;
	private JTable tbAlunos;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtDataNascimento;
	private JTextField txtEndereco;
	private JTextField txtTelefone;
	private JTextField txtResponsavel;
	private JTextField txtTelefoneResponsavel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAdmAtualizarAluno frame = new TelaAdmAtualizarAluno();
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
	public TelaAdmAtualizarAluno() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tbAlunos = new JTable();
		tbAlunos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbAlunos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "CPF", "Data de nascimento", "Endere\u00E7o", "Telefone", "Respons\u00E1vel", "Telefone do respons\u00E1vel"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tbAlunos.setBounds(51, 133, 548, 160);
		contentPane.add(tbAlunos);
		
		JScrollPane scrollPane = new JScrollPane(tbAlunos);
		scrollPane.setBounds(10, 133, 964, 160);
		contentPane.add(scrollPane);
		
		AdministradorDAO admDao = new AdministradorDAO();
		
		DefaultTableModel modelo = (DefaultTableModel) tbAlunos.getModel();
		
		ArrayList<Aluno> listaAlunos = admDao.selecionarAlunos();
		
		for(int i = 0; i<listaAlunos.size(); i++) {
			modelo.addRow(new Object[] {listaAlunos.get(i).getId(), listaAlunos.get(i).getNome(), listaAlunos.get(i).getCpf(), 
					listaAlunos.get(i).getDataNascimento(), listaAlunos.get(i).getEndereco(), 
					listaAlunos.get(i).getTelefone(), listaAlunos.get(i).getResponsavel(), listaAlunos.get(i).getTelefone_responsavel()});
		}
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAdministradorAluno telaAdmAluno = new TelaAdministradorAluno();
				telaAdmAluno.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(491, 351, 89, 23);
		contentPane.add(btnVoltar);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(72, 139, 70, 15);
		contentPane.add(lblId);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				if(tbAlunos.getSelectedRow() > -1) {
					Aluno a = new Aluno();
					
					a.setId(Integer.parseInt(tbAlunos.getValueAt(tbAlunos.getSelectedRow(), 0).toString()));
					
					if(!txtNome.getText().isEmpty()) {
						a.setNome(txtNome.getText());
					} else {
						a.setNome(tbAlunos.getValueAt(tbAlunos.getSelectedRow(), 1).toString());
					}
					
					if(txtCpf.getText().length() == 11) {
						a.setCpf(txtCpf.getText());
					} else {
						a.setCpf(tbAlunos.getValueAt(tbAlunos.getSelectedRow(), 2).toString());
					}
					
					if(txtDataNascimento.getText().matches("\\d{2}/\\d{2}/\\d{4}")) {
						a.setDataNascimento(txtDataNascimento.getText());
					} else {
						a.setDataNascimento(tbAlunos.getValueAt(tbAlunos.getSelectedRow(), 3).toString());
					}
					
					if(!txtEndereco.getText().isEmpty()) {
						a.setEndereco(txtEndereco.getText());
					} else {
						a.setEndereco(tbAlunos.getValueAt(tbAlunos.getSelectedRow(), 4).toString());
					}
					
					if(txtTelefone.getText().length() == 10 || txtTelefone.getText().length() == 11) {
						a.setTelefone_aluno(txtTelefone.getText());
					} else {
						a.setTelefone_aluno(tbAlunos.getValueAt(tbAlunos.getSelectedRow(), 5).toString());
					}
					
					if(!txtResponsavel.getText().isEmpty()) {
						a.setResponsavel(txtResponsavel.getText());
					} else {
						a.setResponsavel(tbAlunos.getValueAt(tbAlunos.getSelectedRow(), 6).toString());
					}
					
					if(txtTelefoneResponsavel.getText().length() == 10 || txtTelefoneResponsavel.getText().length() == 11) {
						a.setTelefone_responsavel(txtTelefoneResponsavel.getText());
					} else {
						a.setTelefone_responsavel(tbAlunos.getValueAt(tbAlunos.getSelectedRow(), 7).toString());
					}
					
					AdministradorDAO admDao = new AdministradorDAO();
					admDao.atualizarAluno(a);
					
					DefaultTableModel modelo2 = (DefaultTableModel) tbAlunos.getModel();					
					while(modelo2.getRowCount() > 0) {
						modelo2.removeRow(0);
					}
					
					ArrayList<Aluno> listaAlunos2 = admDao.selecionarAlunos();
					
					for(int i = 0; i<listaAlunos2.size(); i++) {
						modelo2.addRow(new Object[] {listaAlunos2.get(i).getId(), listaAlunos2.get(i).getNome(), listaAlunos2.get(i).getCpf(), 
								listaAlunos2.get(i).getDataNascimento(), listaAlunos2.get(i).getEndereco(), 
								listaAlunos2.get(i).getTelefone(), listaAlunos2.get(i).getResponsavel(), listaAlunos2.get(i).getTelefone_responsavel()});
					}
					
				} else {
					JOptionPane.showMessageDialog(null, "Selecione alguma linha para editar!");
				}
			}
		});
		btnAtualizar.setBounds(354, 351, 109, 23);
		contentPane.add(btnAtualizar);
		
		txtNome = new JTextField();
		txtNome.setBounds(134, 30, 114, 21);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(287, 30, 114, 21);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);
		
		txtDataNascimento = new JTextField();
		txtDataNascimento.setBounds(427, 30, 114, 21);
		contentPane.add(txtDataNascimento);
		txtDataNascimento.setColumns(10);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(134, 85, 114, 21);
		contentPane.add(txtEndereco);
		txtEndereco.setColumns(10);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(284, 85, 114, 21);
		contentPane.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		txtResponsavel = new JTextField();
		txtResponsavel.setBounds(424, 85, 114, 21);
		contentPane.add(txtResponsavel);
		txtResponsavel.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(134, 11, 58, 17);
		contentPane.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(287, 11, 58, 17);
		contentPane.add(lblCpf);
		
		JLabel lblDataDeNascimento = new JLabel("Data de nascimento");
		lblDataDeNascimento.setBounds(427, 11, 127, 17);
		contentPane.add(lblDataDeNascimento);
		
		JLabel lblEndereo = new JLabel("Endereço");
		lblEndereo.setBounds(134, 62, 58, 17);
		contentPane.add(lblEndereo);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(287, 62, 58, 17);
		contentPane.add(lblTelefone);
		
		JLabel lbResponsavel = new JLabel("Responsável");
		lbResponsavel.setBounds(427, 62, 104, 17);
		contentPane.add(lbResponsavel);
		
		JLabel lblTelefoneResponsavel = new JLabel("Telefone Responsável");
		lblTelefoneResponsavel.setBounds(596, 11, 139, 17);
		contentPane.add(lblTelefoneResponsavel);
		
		txtTelefoneResponsavel = new JTextField();
		txtTelefoneResponsavel.setBounds(596, 30, 114, 21);
		contentPane.add(txtTelefoneResponsavel);
		txtTelefoneResponsavel.setColumns(10);
	}
}
