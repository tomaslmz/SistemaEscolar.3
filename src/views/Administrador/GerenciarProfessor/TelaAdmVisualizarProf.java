package views.Administrador.GerenciarProfessor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
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
		setBounds(100, 100, 633, 436);
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
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(112, 107, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CPF");
		lblNewLabel_1.setBounds(181, 109, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Data de nascimento");
		lblNewLabel_2.setBounds(237, 109, 71, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Endereço");
		lblNewLabel_3.setBounds(318, 109, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Telefone");
		lblNewLabel_4.setBounds(385, 109, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Salário");
		lblNewLabel_5.setBounds(454, 109, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		AdministradorDAO admDao = new AdministradorDAO();
		
		DefaultTableModel modelo = (DefaultTableModel) tbProfessores.getModel();
		
		ArrayList<Professor> listaProfessores = admDao.selecionarProfessores();
		
		for(int i = 0; i<admDao.quantidadeProfessores(); i++) {
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
		btnVoltar.setBounds(257, 349, 89, 23);
		contentPane.add(btnVoltar);
	}
}
