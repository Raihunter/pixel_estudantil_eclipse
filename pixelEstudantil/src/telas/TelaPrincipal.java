package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import java.awt.Color;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.Rectangle;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 900, 200);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.WHITE);
		menuBar.setBackground(Color.BLACK);
		menuBar.setBounds(0, 5, 900, 21);
		panel.add(menuBar);
		
		JMenu mnEstudante = new JMenu("Estudante");
		mnEstudante.setForeground(Color.WHITE);
		menuBar.add(mnEstudante);
		
		JMenuItem mntmAgenda = new JMenuItem("Agenda");
		mntmAgenda.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/icons/clipboard-icon.png")));
		mntmAgenda.setForeground(Color.WHITE);
		mntmAgenda.setBackground(Color.BLACK);
		mnEstudante.add(mntmAgenda);
		
		JMenuItem mntmDisciplinas = new JMenuItem("Disciplinas");
		mntmDisciplinas.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/icons/Books-icon.png")));
		mntmDisciplinas.setBackground(Color.BLACK);
		mntmDisciplinas.setForeground(Color.WHITE);
		mnEstudante.add(mntmDisciplinas);
		
		JMenuItem mntmAtividades = new JMenuItem("Atividades");
		mntmAtividades.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/icons/Test-paper-icon.png")));
		mntmAtividades.setForeground(Color.WHITE);
		mntmAtividades.setBackground(Color.BLACK);
		mnEstudante.add(mntmAtividades);
		
		JMenu mnProfessor = new JMenu("Professor");
		mnProfessor.setForeground(Color.WHITE);
		menuBar.add(mnProfessor);
		
		JMenuItem mntmCriarAgendoDo = new JMenuItem("Criar agenda do aluno");
		mntmCriarAgendoDo.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/icons/clipboard-icon.png")));
		mntmCriarAgendoDo.setBackground(Color.BLACK);
		mntmCriarAgendoDo.setForeground(Color.WHITE);
		mnProfessor.add(mntmCriarAgendoDo);
		
		JMenuItem mntmAdicionarAtividades = new JMenuItem("Adicionar atividades");
		mntmAdicionarAtividades.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/icons/Test-paper-icon.png")));
		mntmAdicionarAtividades.setForeground(Color.WHITE);
		mntmAdicionarAtividades.setBackground(Color.BLACK);
		mnProfessor.add(mntmAdicionarAtividades);
		
		JMenu mnColaborador = new JMenu("Colaborador");
		mnColaborador.setForeground(Color.WHITE);
		menuBar.add(mnColaborador);
		
		JMenuItem mntmCadastrarProfessor = new JMenuItem("Cadastrar professor");
		mntmCadastrarProfessor.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/icons/client-account-template-icon.png")));
		mntmCadastrarProfessor.setBackground(Color.BLACK);
		mntmCadastrarProfessor.setForeground(Color.WHITE);
		mnColaborador.add(mntmCadastrarProfessor);
		
		JMenuItem mntmGerenciarContas = new JMenuItem("Gerenciar contas");
		mntmGerenciarContas.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/icons/Documents-icon.png")));
		mntmGerenciarContas.setForeground(Color.WHITE);
		mntmGerenciarContas.setBackground(Color.BLACK);
		mnColaborador.add(mntmGerenciarContas);
		
		JMenu mnCompletarCadastro = new JMenu("Completar Cadastro");
		mnCompletarCadastro.setForeground(Color.WHITE);
		menuBar.add(mnCompletarCadastro);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.setLocationRelativeTo(null);
				login.setVisible(true);
				dispose();
			}
		});
		btnSair.setBorder(null);
		btnSair.setForeground(Color.WHITE);
		btnSair.setBackground(Color.BLACK);
		menuBar.add(btnSair);
		
		JLabel jlImagePanel = new JLabel("");
		jlImagePanel.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/menu.jpg")));
		jlImagePanel.setBounds(0, 0, 900, 200);
		panel.add(jlImagePanel);
	}
}
