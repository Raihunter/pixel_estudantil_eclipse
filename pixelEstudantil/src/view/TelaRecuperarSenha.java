package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class TelaRecuperarSenha extends JFrame {

	private JPanel contentPane;
	private JTextField tfEmailRecuperar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRecuperarSenha frame = new TelaRecuperarSenha();
					frame.setVisible(true);
					frame.setSize(900, 600);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaRecuperarSenha() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setLocation(300, 80);
		panel.setSize(300, 400);
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblCrieSuaConta = new JLabel("Recupere sua senha");
		lblCrieSuaConta.setBounds(80, 20, 150, 15);
		panel.add(lblCrieSuaConta);
	
		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setBounds(45, 130, 70, 15);
		panel.add(lblEmail);
		
		tfEmailRecuperar = new JTextField("");
		tfEmailRecuperar.setBounds(45, 150, 210, 25);
		panel.add(tfEmailRecuperar);
		tfEmailRecuperar.setColumns(10);
		
		JButton btnEnviar = new JButton("ENVIAR");
		btnEnviar.setForeground(Color.WHITE);
		btnEnviar.setBackground(Color.BLUE);
		btnEnviar.setBounds(45, 190, 210, 25);
		panel.add(btnEnviar);
		
		JLabel lblNewLabel = new JLabel("Por favor entre com seu endereço de");
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblNewLabel.setBounds(45, 47, 215, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("email para recuperar sua senha");
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(60, 63, 200, 15);
		panel.add(lblNewLabel_1);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setBackground(Color.BLUE);
		btnVoltar.setBounds(45, 230, 210, 25);
		panel.add(btnVoltar);
	}
}
