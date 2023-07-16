package views.Administrador.GerenciarAluno;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
	//Feito por Tomas
	/**
	 * Criacao da tela para visualizar alunos do administrador;<br>
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
		/**
		 * Configuracoes da tela;<br>
		 * */
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 500);
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
		
		JScrollPane scrollPane = new JScrollPane(tbAlunos);
		scrollPane.setBounds(10, 133, 964, 160);
		contentPane.add(scrollPane);
		
		/**
		 * Inicio da logica para pegar os dados do banco de dados;<br>
		 * */
		
		AdministradorDAO admDao = new AdministradorDAO();
		
		DefaultTableModel modelo = (DefaultTableModel) tbAlunos.getModel();
		
		ArrayList<Aluno> listaAlunos = admDao.selecionarAlunos();
		
		for(int i = 0; i<listaAlunos.size(); i++) {
			modelo.addRow(new Object[] {listaAlunos.get(i).getNome(), listaAlunos.get(i).getCpf(), 
					listaAlunos.get(i).getDataNascimento(), listaAlunos.get(i).getEndereco(), 
					listaAlunos.get(i).getTelefone(), listaAlunos.get(i).getResponsavel(), listaAlunos.get(i).getTelefone_responsavel()});
		}
		
		/**
		 * Inicio dos botoes para as funcionalidades da pagina;<br>
		 * */
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAdministradorAluno telaAdmAluno = new TelaAdministradorAluno();
				telaAdmAluno.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(435, 349, 89, 23);
		contentPane.add(btnVoltar);
		
		
	}
}
