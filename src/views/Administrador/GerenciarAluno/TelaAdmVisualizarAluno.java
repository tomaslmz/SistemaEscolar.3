package views.Administrador.GerenciarAluno;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import data.AdministradorDAO;
import models.Aluno;

import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TelaAdmVisualizarAluno extends JFrame {

	private JPanel contentPane;
	private JTable tbAlunos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAdmVisualizarAluno frame = new TelaAdmVisualizarAluno();
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
	public TelaAdmVisualizarAluno() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 633, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tbAlunos = new JTable();
		tbAlunos.setCellSelectionEnabled(true);
		tbAlunos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbAlunos.setRowSelectionAllowed(false);
		tbAlunos.setEnabled(false);
		tbAlunos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "CPF", "Data de nascimento", "Endere\u00E7o", "Telefone", "Respons\u00E1vel", "Telefone do respons\u00E1vel"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tbAlunos.setBounds(51, 133, 499, 160);
		contentPane.add(tbAlunos);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(51, 107, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CPF");
		lblNewLabel_1.setBounds(138, 107, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Data de nascimento");
		lblNewLabel_2.setBounds(196, 107, 71, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Endereço");
		lblNewLabel_3.setBounds(279, 107, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Telefone");
		lblNewLabel_4.setBounds(337, 107, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblResponsavel = new JLabel("Responsável");
		lblResponsavel.setBounds(413, 104, 58, 17);
		contentPane.add(lblResponsavel);
		
		JLabel tbTelefoneResponsavel = new JLabel("Telefone do responsável");
		tbTelefoneResponsavel.setBounds(492, 106, 107, 17);
		contentPane.add(tbTelefoneResponsavel);
		
		AdministradorDAO admDao = new AdministradorDAO();
		
		DefaultTableModel modelo = (DefaultTableModel) tbAlunos.getModel();
		
		ArrayList<Aluno> listaAlunos = admDao.selecionarAlunos();
		
		for(int i = 0; i<admDao.quantidadeAlunos(); i++) {
			modelo.addRow(new Object[] {listaAlunos.get(i).getNome(), listaAlunos.get(i).getCpf(), 
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
		btnVoltar.setBounds(257, 349, 89, 23);
		contentPane.add(btnVoltar);
		
		
	}
}
