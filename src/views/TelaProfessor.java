package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.Professor;

import javax.swing.JLabel;

public class TelaProfessor extends JFrame {//Feito por Tomás

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaProfessor frame = new TelaProfessor();
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
	public TelaProfessor() {
		
		/**<br>Definindo as labels junto com seus dados*/
		Professor professor = new Professor();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbNome = new JLabel("Nome: " + professor.getNome());
		lbNome.setBounds(88, 23, 284, 26);
		contentPane.add(lbNome);
		
		JLabel lbCpf = new JLabel("CPF: " + professor.getCpf());
		lbCpf.setBounds(88, 60, 284, 26);
		contentPane.add(lbCpf);
		
		JLabel lbDataNascimento = new JLabel("Data de nascimento: " + "24/05/2005");
		lbDataNascimento.setBounds(88, 97, 284, 26);
		contentPane.add(lbDataNascimento);
		
		JLabel lbEndereco = new JLabel("Endereço: " + professor.getEndereco());
		lbEndereco.setBounds(88, 134, 284, 26);
		contentPane.add(lbEndereco);
		
		JLabel lbTelefone = new JLabel("Telefone: " + professor.getTelefone());
		lbTelefone.setBounds(88, 171, 284, 26);
		contentPane.add(lbTelefone);
		
		JLabel lbSalario = new JLabel("Salário: R$" + professor.getSalario());
		lbSalario.setBounds(88, 208, 284, 26);
		contentPane.add(lbSalario);
	}

}
