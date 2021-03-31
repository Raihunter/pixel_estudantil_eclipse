package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.DisciplinaController;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class TelaNovaDisciplina extends JFrame {

	private JPanel contentPane;
	private JTextField tfNomeDisciplina;
	private JTextField tfCodigo;
	private JButton btnConfirmar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaNovaDisciplina frame = new TelaNovaDisciplina();
					frame.setVisible(true);
					frame.setSize(527, 335);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaNovaDisciplina() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 527, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setLocation(114, 40);
		panel.setSize(300, 220);
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel labelNovaDisciplina = new JLabel("Nova Disciplinar");
		labelNovaDisciplina.setFont(new Font("Dialog", Font.BOLD, 16));
		labelNovaDisciplina.setBounds(80, 10, 140, 15);
		panel.add(labelNovaDisciplina);
		
		JLabel labelNomeDisciplina = new JLabel("NOME");
		labelNomeDisciplina.setBounds(45, 50, 160, 15);
		panel.add(labelNomeDisciplina);
		
		tfNomeDisciplina = new JTextField("");
		tfNomeDisciplina.setBounds(45, 70, 210, 25);
		panel.add(tfNomeDisciplina);
		tfNomeDisciplina.setColumns(10);
		
		JLabel labelCodigo = new JLabel("CÓDIGO");
		labelCodigo.setBounds(45, 110, 70, 15);
		panel.add(labelCodigo);
		
		tfCodigo = new JTextField("");
		tfCodigo.setBounds(45, 130, 210, 25);
		panel.add(tfCodigo);
		tfCodigo.setColumns(10);

		btnConfirmar = new JButton("CONFIRMAR");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = tfNomeDisciplina.getText();
				String codigo = tfCodigo.getText();
				boolean sucesso;
				try{
					DisciplinaController disController = new DisciplinaController();
					sucesso = disController.criarDisciplina(nome, codigo);
					if(sucesso == true) {
						JOptionPane.showMessageDialog(null, "Disciplina criada com sucesso.");
					} else {
						JOptionPane.showMessageDialog(null, "Dados incorretos.");
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Erro: "+ex);
				}
			}
		});
		btnConfirmar.setForeground(Color.WHITE);
		btnConfirmar.setBackground(Color.BLUE);
		btnConfirmar.setBounds(45, 180, 210, 25);
		panel.add(btnConfirmar);
		
	}
}

