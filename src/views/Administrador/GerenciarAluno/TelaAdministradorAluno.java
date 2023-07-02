package views.Administrador.GerenciarAluno;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import views.Administrador.TelaAdministrador;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaAdministradorAluno extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAdministradorAluno frame = new TelaAdministradorAluno();
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
	public TelaAdministradorAluno() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Como deseja gerenciar os alunos?");
		lblNewLabel.setBounds(118, 11, 211, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAdmRegistrarAluno telaRegistrar = new TelaAdmRegistrarAluno();
				telaRegistrar.setVisible(true);
				dispose();
			}
		});
		btnRegistrar.setBounds(175, 67, 89, 23);
		contentPane.add(btnRegistrar);
		
		JButton btnVisualizar = new JButton("Visualizar");
		btnVisualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				TelaAdmVisualizarProf telaAdmVisuProf = new TelaAdmVisualizarProf();
//				telaAdmVisuProf.setVisible(true);
//				dispose();
//				
			}
		});
		btnVisualizar.setBounds(175, 103, 89, 23);
		contentPane.add(btnVisualizar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				TelaAdmAtualizarProf telaAdmAtualizarProf = new TelaAdmAtualizarProf();
//				telaAdmAtualizarProf.setVisible(true);
//				dispose();
			}
		});
		btnAtualizar.setBounds(175, 137, 89, 23);
		contentPane.add(btnAtualizar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(175, 171, 89, 23);
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				TelaAdmApagarProf telaAdmApagarProf = new TelaAdmApagarProf();
//				telaAdmApagarProf.setVisible(true);
//				dispose();
				
			}
		});
		contentPane.add(btnDeletar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAdministrador telaAdm = new TelaAdministrador();
				telaAdm.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(175, 227, 89, 23);
		contentPane.add(btnVoltar);
	}

}