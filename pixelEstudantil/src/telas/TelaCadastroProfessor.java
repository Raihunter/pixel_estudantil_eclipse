package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import arquivos.Arquivo;
import dao.PessoaDAO;
import exceptions.PasswordException;
import interfaces.PessoaRepositorio;
import pessoas.Aluno;
import pessoas.Pessoa;
import pessoas.Professor;
import pessoas.Secretaria;
import sistema.Sistema;

public class TelaCadastroProfessor extends JFrame {

	private JPanel contentPane;
	private JTextField tfNomeCadastro;
	private JTextField tfEmailCadastro;
	private JPasswordField tfSenhaCadastro;
	private JPasswordField tfConfirmarSenhaCadastro;
	Sistema sis = new Sistema();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroProfessor frame = new TelaCadastroProfessor();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					frame.setSize(900, 600);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCadastroProfessor() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setLocation(300, 60);
		panel.setSize(300, 420);
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNovoProfessor = new JLabel("Novo Professor");
		lblNovoProfessor.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNovoProfessor.setBounds(85, 20, 237, 15);
		panel.add(lblNovoProfessor);
		
		JLabel lblNomeProfessor = new JLabel("NOME DO PROFESSOR");
		lblNomeProfessor.setBounds(45, 80, 160, 15);
		panel.add(lblNomeProfessor);
		
		tfNomeCadastro = new JTextField("");
		tfNomeCadastro.setBounds(45, 100, 210, 25);
		panel.add(tfNomeCadastro);
		tfNomeCadastro.setColumns(10);
		
		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setBounds(45, 140, 70, 15);
		panel.add(lblEmail);
		
		tfEmailCadastro = new JTextField("");
		tfEmailCadastro.setBounds(45, 160, 210, 25);
		panel.add(tfEmailCadastro);
		tfEmailCadastro.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("SENHA");
		lblNewLabel.setBounds(45, 200, 70, 15);
		panel.add(lblNewLabel);
		
		tfSenhaCadastro = new JPasswordField("");
		tfSenhaCadastro.setBounds(45, 220, 210, 25);
		panel.add(tfSenhaCadastro);
		
		JLabel lblNewLabel_1 = new JLabel("CONFIRMAR SENHA");
		lblNewLabel_1.setBounds(45, 260, 140, 15);
		panel.add(lblNewLabel_1);
		
		tfConfirmarSenhaCadastro = new JPasswordField("");
		tfConfirmarSenhaCadastro.setBounds(45, 280, 210, 25);
		panel.add(tfConfirmarSenhaCadastro);
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				if(!tfSenhaCadastro.getText().equals(tfConfirmarSenhaCadastro.getText())) {
					JOptionPane.showMessageDialog(null, "Confirmação de senha incorreta");
					tfConfirmarSenhaCadastro.setText("");
				} else {
					PessoaDAO PessoaDAO = new PessoaDAO();
					Pessoa sec = PessoaDAO.getPessoaLogada();
					try {
						if(sec instanceof Secretaria) {
							Professor professor = new Professor(tfNomeCadastro.getText(), tfEmailCadastro.getText());
							professor.setAuxPassword(tfSenhaCadastro.getText());
							((Secretaria) sec).gravarProfessor(professor);
							JOptionPane.showMessageDialog(null, tfNomeCadastro.getText()+" cadastrado(a) com sucesso");
						} else {
							JOptionPane.showMessageDialog(null, "Autorização negada");
						}
					} catch (PasswordException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				
					tfNomeCadastro.setText("");
					tfEmailCadastro.setText("");
					tfSenhaCadastro.setText("");
					tfConfirmarSenhaCadastro.setText("");
				}
			}
		});
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setBackground(Color.BLUE);
		btnCadastrar.setBounds(45, 320, 210, 25);
		panel.add(btnCadastrar);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setBackground(Color.BLUE);
		btnVoltar.setBounds(45, 360, 210, 25);
		panel.add(btnVoltar);
	}
}
