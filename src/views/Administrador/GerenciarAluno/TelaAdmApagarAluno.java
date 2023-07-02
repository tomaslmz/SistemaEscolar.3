package views.Administrador.GerenciarAluno;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
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

public class TelaAdmApagarAluno extends JFrame {

	private JPanel contentPane;
	private JTable tbAlunos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAdmApagarAluno frame = new TelaAdmApagarAluno();
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
	public TelaAdmApagarAluno() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 633, 436);
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
		scrollPane.setBounds(0, 133, 623, 160);
		contentPane.add(scrollPane);
		
		AdministradorDAO admDao = new AdministradorDAO();
		
		DefaultTableModel modelo = (DefaultTableModel) tbAlunos.getModel();
		
		ArrayList<Aluno> listaAlunos = admDao.selecionarAlunos();
		
		for(int i = 0; i<admDao.quantidadeAlunos(); i++) {
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
		btnVoltar.setBounds(313, 352, 89, 23);
		contentPane.add(btnVoltar);
		
		JButton btnApagar = new JButton("Apagar");
		btnApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tbAlunos.getSelectedRow() > -1) {
					int id = Integer.parseInt(tbAlunos.getValueAt(tbAlunos.getSelectedRow(), 0).toString());
					
					AdministradorDAO admDao = new AdministradorDAO();
					admDao.apagarAluno(id);
					
					DefaultTableModel modelo = (DefaultTableModel) tbAlunos.getModel();
					modelo.removeRow(tbAlunos.getSelectedRow());	
				}
			}
		});
		btnApagar.setBounds(176, 352, 109, 23);
		contentPane.add(btnApagar);
	}
}
