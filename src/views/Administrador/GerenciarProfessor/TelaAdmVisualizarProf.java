package views.Administrador.GerenciarProfessor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import data.AdministradorDAO;
import models.Professor;

import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TelaAdmVisualizarProf extends JFrame {

	private JPanel contentPane;
	private JTable tbProfessores;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAdmVisualizarProf frame = new TelaAdmVisualizarProf();
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
	public TelaAdmVisualizarProf() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tbProfessores = new JTable();
		tbProfessores.setCellSelectionEnabled(true);
		tbProfessores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbProfessores.setRowSelectionAllowed(false);
		tbProfessores.setEnabled(false);
		tbProfessores.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "CPF", "Data de nascimento", "Endere\u00E7o", "Telefone", "Sal\u00E1rio"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, true, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tbProfessores.setBounds(103, 134, 404, 160);
		contentPane.add(tbProfessores);
		
		JScrollPane scrollPane = new JScrollPane(tbProfessores);
		scrollPane.setBounds(0, 133, 974, 160);
		contentPane.add(scrollPane);
		
		AdministradorDAO admDao = new AdministradorDAO();
		
		DefaultTableModel modelo = (DefaultTableModel) tbProfessores.getModel();
		
		ArrayList<Professor> listaProfessores = admDao.selecionarProfessores();
		
		for(int i = 0; i<listaProfessores.size(); i++) {
			modelo.addRow(new Object[] {listaProfessores.get(i).getNome(), listaProfessores.get(i).getCpf(), 
					listaProfessores.get(i).getDataNascimento(), listaProfessores.get(i).getEndereco(), 
					listaProfessores.get(i).getTelefone(), listaProfessores.get(i).getSalario()});
		}
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAdministradorProfessor telaAdmProf = new TelaAdministradorProfessor();
				telaAdmProf.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(432, 339, 89, 23);
		contentPane.add(btnVoltar);
	}
}
