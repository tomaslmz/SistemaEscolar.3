package views.Administrador.GerenciarProfessor;

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
import models.Professor;

import javax.swing.JButton;
import javax.swing.JTextField;

public class TelaAdmAtualizarProf extends JFrame {

	private JPanel contentPane;
	private JTable tbProfessores;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtDataNascimento;
	private JTextField txtEndereco;
	private JTextField txtTelefone;
	private JTextField txtSalario;
	//Feito por Tomas
	/**
	 * Criacao da tela para atualizar dados dos professores do administrador;<br>
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAdmAtualizarProf frame = new TelaAdmAtualizarProf();
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
	public TelaAdmAtualizarProf() {
		/**
		 * Configuracoes da tela;<br>
		 * */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tbProfessores = new JTable();
		tbProfessores.setToolTipText("");
		tbProfessores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbProfessores.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "CPF", "Data de nascimento", "Endere\u00E7o", "Telefone", "Sal\u00E1rio"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tbProfessores.setBounds(73, 162, 469, 160);
		contentPane.add(tbProfessores);
		
		JScrollPane scrollPane = new JScrollPane(tbProfessores);
		scrollPane.setBounds(0, 133, 974, 160);
		contentPane.add(scrollPane);
		
		/**
		 * Inicio da logica para pegar os dados do banco de dados;<br>
		 * */
		
		AdministradorDAO admDao = new AdministradorDAO();
		
		DefaultTableModel modelo = (DefaultTableModel) tbProfessores.getModel();
		
		ArrayList<Professor> listaProfessores = admDao.selecionarProfessores();
		
		for(int i = 0; i<listaProfessores.size(); i++) {
			modelo.addRow(new Object[] {listaProfessores.get(i).getId(), listaProfessores.get(i).getNome(), listaProfessores.get(i).getCpf(), 
					listaProfessores.get(i).getDataNascimento(), listaProfessores.get(i).getEndereco(), 
					listaProfessores.get(i).getTelefone(), listaProfessores.get(i).getSalario()});
		}
		
		/**
		 * Inicio dos botoes para as funcionalidades da pagina;<br>
		 * */
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAdministradorProfessor telaAdmProf = new TelaAdministradorProfessor();
				telaAdmProf.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(522, 350, 89, 23);
		contentPane.add(btnVoltar);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(72, 139, 70, 15);
		contentPane.add(lblId);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				if(tbProfessores.getSelectedRow() > -1) {
					Professor p = new Professor();
					
					p.setId(Integer.parseInt(tbProfessores.getValueAt(tbProfessores.getSelectedRow(), 0).toString()));
					
					if(!txtNome.getText().isEmpty()) {
						p.setNome(txtNome.getText());
					} else {
						p.setNome(tbProfessores.getValueAt(tbProfessores.getSelectedRow(), 1).toString());
					}
					
					if(txtCpf.getText().length() == 11) {
						p.setCpf(txtCpf.getText());
					} else {
						p.setCpf(tbProfessores.getValueAt(tbProfessores.getSelectedRow(), 2).toString());
					}
					
					if(txtDataNascimento.getText().matches("\\d{2}/\\d{2}/\\d{4}")) {
						p.setDataNascimento(txtDataNascimento.getText());
					} else {
						p.setDataNascimento(tbProfessores.getValueAt(tbProfessores.getSelectedRow(), 3).toString());
					}
					
					if(!txtEndereco.getText().isEmpty()) {
						p.setEndereco(txtEndereco.getText());
					} else {
						p.setEndereco(tbProfessores.getValueAt(tbProfessores.getSelectedRow(), 4).toString());
					}
					
					if(txtTelefone.getText().length() == 10 || txtTelefone.getText().length() == 11) {
						p.setTelefone(txtTelefone.getText());
					} else {
						p.setTelefone(tbProfessores.getValueAt(tbProfessores.getSelectedRow(), 5).toString());
					}
					
					if(!txtSalario.getText().isEmpty()) {
						if(Float.parseFloat(txtSalario.getText()) > 0) {
							p.setSalario(Float.parseFloat(txtSalario.getText()));
							AdministradorDAO admDao = new AdministradorDAO();
							admDao.atualizarProfessor(p);
							
							DefaultTableModel modelo2 = (DefaultTableModel) tbProfessores.getModel();					
							while(modelo2.getRowCount() > 0) {
								modelo2.removeRow(0);
							}
							
							ArrayList<Professor> listaProfessores2 = admDao.selecionarProfessores();
							
							for(int i = 0; i<listaProfessores2.size(); i++) {
								modelo2.addRow(new Object[] {listaProfessores2.get(i).getId(), listaProfessores2.get(i).getNome(), listaProfessores2.get(i).getCpf(), 
										listaProfessores2.get(i).getDataNascimento(), listaProfessores2.get(i).getEndereco(), 
										listaProfessores2.get(i).getTelefone(), listaProfessores2.get(i).getSalario()});
							}
						} else {
							JOptionPane.showMessageDialog(null, "Insira um salário válido!!");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Insira um salário válido!!");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Selecione alguma linha para editar!");
				}
			}
		});
		btnAtualizar.setBounds(385, 350, 109, 23);
		contentPane.add(btnAtualizar);
		
		txtNome = new JTextField();
		txtNome.setBounds(236, 46, 114, 21);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(386, 46, 114, 21);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);
		
		txtDataNascimento = new JTextField();
		txtDataNascimento.setBounds(553, 46, 114, 21);
		contentPane.add(txtDataNascimento);
		txtDataNascimento.setColumns(10);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(236, 101, 114, 21);
		contentPane.add(txtEndereco);
		txtEndereco.setColumns(10);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(386, 101, 114, 21);
		contentPane.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		txtSalario = new JTextField();
		txtSalario.setBounds(553, 101, 114, 21);
		contentPane.add(txtSalario);
		txtSalario.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(236, 18, 58, 17);
		contentPane.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(386, 18, 58, 17);
		contentPane.add(lblCpf);
		
		JLabel lblDataDeNascimento = new JLabel("Data de nascimento");
		lblDataDeNascimento.setBounds(553, 18, 127, 17);
		contentPane.add(lblDataDeNascimento);
		
		JLabel lblEndereo = new JLabel("Endereço");
		lblEndereo.setBounds(236, 79, 58, 17);
		contentPane.add(lblEndereo);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(386, 79, 58, 17);
		contentPane.add(lblTelefone);
		
		JLabel lblSalrio = new JLabel("Salário");
		lblSalrio.setBounds(553, 78, 58, 17);
		contentPane.add(lblSalrio);
	}
}
