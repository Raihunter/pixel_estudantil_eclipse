package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;

import controller.SistemaController;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import dao.PessoaDAO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField tfUsuarioLogin;
	private JPasswordField tfSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SistemaController sis = new SistemaController();
					sis.acessoRoot();
					TelaLogin frame = new TelaLogin();
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
	public TelaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelImageLogin = new JPanel();
		panelImageLogin.setBounds(350, 0, 550, 600);
		contentPane.add(panelImageLogin);
		panelImageLogin.setLayout(null);
		
		JLabel jlFraseLogin1 = new JLabel("Bem vindo à");
		jlFraseLogin1.setForeground(Color.WHITE);
		jlFraseLogin1.setBounds(208, 170, 150, 31);
		panelImageLogin.add(jlFraseLogin1);
		jlFraseLogin1.setFont(new Font("Dialog", Font.BOLD, 20));
		jlFraseLogin1.setLayout(null);
		
		JLabel jlFraseLogin2 = new JLabel("P");
		jlFraseLogin2.setForeground(SystemColor.activeCaption);
		jlFraseLogin2.setBounds(235, 210, 40, 45);
		panelImageLogin.add(jlFraseLogin2);
		jlFraseLogin2.setFont(new Font("Purisa", Font.BOLD | Font.ITALIC, 40));
		
		JLabel jlFraseLogin3 = new JLabel("íxel");
		jlFraseLogin3.setForeground(Color.WHITE);
		jlFraseLogin3.setBounds(270, 210, 100, 31);
		panelImageLogin.add(jlFraseLogin3);
		jlFraseLogin3.setFont(new Font("Dialog", Font.BOLD, 20));
		
		JLabel jlFraseLogin4 = new JLabel("estudantil");
		jlFraseLogin4.setForeground(Color.WHITE);
		jlFraseLogin4.setFont(new Font("Dialog", Font.BOLD, 20));
		jlFraseLogin4.setBounds(220, 250, 130, 31);
		panelImageLogin.add(jlFraseLogin4);
		
		JLabel jlFraseLogin5 = new JLabel("Aqui você encontra");
		jlFraseLogin5.setForeground(Color.WHITE);
		jlFraseLogin5.setBounds(210, 333, 145, 15);
		panelImageLogin.add(jlFraseLogin5);
		
		JLabel jlFraseLogin6 = new JLabel("o presente, o passado e");
		jlFraseLogin6.setForeground(Color.WHITE);
		jlFraseLogin6.setBounds(190, 360, 180, 15);
		panelImageLogin.add(jlFraseLogin6);
		
		JLabel jlFraseLogin7 = new JLabel("define o futuro!");
		jlFraseLogin7.setForeground(Color.WHITE);
		jlFraseLogin7.setBounds(224, 387, 120, 15);
		panelImageLogin.add(jlFraseLogin7);
		
		JLabel jlBemVindo = new JLabel("");
		jlBemVindo.setBounds(160, 150, 230, 280);
		panelImageLogin.add(jlBemVindo);
		jlBemVindo.setIcon(new ImageIcon(TelaLogin.class.getResource("/imagens/painelmine(1).png")));
		
		JLabel jlImagenLogin = new JLabel("");
		jlImagenLogin.setBounds(0, 0, 550, 600);
		panelImageLogin.add(jlImagenLogin);
		jlImagenLogin.setIcon(new ImageIcon(TelaLogin.class.getResource("/imagens/telalogin.jpg")));
		jlImagenLogin.setLayout(null);
		
		JPanel panelInputLogin = new JPanel();
		panelInputLogin.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panelInputLogin.setBounds(61, 107, 240, 360);
		contentPane.add(panelInputLogin);
		panelInputLogin.setLayout(null);
		
		JLabel jlFraseInputLogin1 = new JLabel("Entre para acessar sua conta");
		jlFraseInputLogin1.setBounds(15, 6, 209, 15);
		panelInputLogin.add(jlFraseInputLogin1);
		
		JLabel jlFraseInputLogin2 = new JLabel("É bom ver você de volta!");
		jlFraseInputLogin2.setBounds(64, 30, 123, 13);
		jlFraseInputLogin2.setFont(new Font("Dialog", Font.PLAIN, 10));
		panelInputLogin.add(jlFraseInputLogin2);
		
		JLabel jlUsuarioLogin = new JLabel("USUARIO");
		jlUsuarioLogin.setBounds(15, 90, 70, 15);
		panelInputLogin.add(jlUsuarioLogin);
		
		JLabel jlSenhaLogin = new JLabel("SENHA");
		jlSenhaLogin.setBounds(15, 150, 60, 15);
		panelInputLogin.add(jlSenhaLogin);
		
		tfUsuarioLogin = new JTextField("");
		tfUsuarioLogin.setBounds(15, 112, 210, 25);
		panelInputLogin.add(tfUsuarioLogin);
		tfUsuarioLogin.setColumns(10);
		
		tfSenha = new JPasswordField("");
		tfSenha.setBounds(15, 170, 210, 25);
		panelInputLogin.add(tfSenha);
		
		//Adicionando um evento para o botão entrar
		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				PessoaDAO pessoaDAO = new PessoaDAO();
				if(pessoaDAO.validarLogin(tfUsuarioLogin.getText(), tfSenha.getText()) == true) {
					TelaPrincipal logado = new TelaPrincipal();
					logado.setLocationRelativeTo(null);
					logado.setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Usuário ou senha incorreta");
					tfUsuarioLogin.setText("");
					tfSenha.setText("");
				}
			}
		});
		btnEntrar.setForeground(Color.WHITE);
		btnEntrar.setBackground(Color.BLUE);
		btnEntrar.setBounds(15, 210, 210, 25);
		panelInputLogin.add(btnEntrar);
		
		//Adicionando um evento para o botão cadastrar.
		JButton btnCadastreseAqui = new JButton("Cadastre-se aqui");
		btnCadastreseAqui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastro telaCadastro = new TelaCadastro();
				telaCadastro.setLocationRelativeTo(null);
				telaCadastro.setVisible(true);
			}
		});
		btnCadastreseAqui.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnCadastreseAqui.setBounds(15, 262, 210, 25);
		panelInputLogin.add(btnCadastreseAqui);
		
		//Adicionando um evento para o botão recuperarSenha.
		JButton btnRecuperarSenha = new JButton("Recuperar senha");
		btnRecuperarSenha.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaRecuperarSenha telaRecuperarSenha = new TelaRecuperarSenha();
				telaRecuperarSenha.setLocationRelativeTo(null);
				telaRecuperarSenha.setVisible(true);
			}
		});
		btnRecuperarSenha.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnRecuperarSenha.setBounds(15, 309, 210, 25);
		panelInputLogin.add(btnRecuperarSenha);
	}
	
}
