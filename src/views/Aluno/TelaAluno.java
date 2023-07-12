package views.Aluno;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dados.ProdutoDados;
import data.AdministradorDAO;
import data.AlunoDAO;
import model.Produto;
import models.Aluno;

import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TelaAluno extends JFrame {

	private JPanel contentPane;
	private JTable tbAlunos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAluno frame = new TelaAluno();
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
	public TelaAluno() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 959, 436);
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
		scrollPane.setBounds(10, 133, 923, 160);
		contentPane.add(scrollPane);
		
		AlunoDAO alunoDAO = new AlunoDAO();
		Aluno aa = new Aluno();
		aa.setNome("Joaquim");
		alunoDAO.listarAlunos(aa);
		
		
		//Puxar a conexao
		//Connection id_conexao = conexao.conectar();
		AlunoDAO conectarDados = new AlunoDAO();
		conectarDados.listarAlunos(aa);		
		
		DefaultTableModel modelo = (DefaultTableModel) tbAlunos.getModel();
		
		modelo.addRow(new Object[] {aa.getNome(),aa.getCpf(),aa.getDataNascimento(),aa.getEndereco(),aa.getTelefone(),aa.getResponsavel(),aa.getTelefone_responsavel()});
		tbAlunos.setModel(modelo);
		
		
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAluno telaAluno = new TelaAluno();
				telaAluno.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(404, 347, 89, 23);
		contentPane.add(btnVoltar);
		
		
	}
}
