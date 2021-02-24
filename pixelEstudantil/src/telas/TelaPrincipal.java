package telas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.PessoaDAO;
import telasAuxiliares.TelaPontuacao;

import javax.swing.JLabel;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import java.awt.Color;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JPanel panelInferior;
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
		setTitle("Tela Principal");
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBounds(0, 0, 900, 200);
		contentPane.add(panelSuperior);
		panelSuperior.setLayout(null);
		
		panelInferior = new JPanel();
		panelInferior.setLayout(null);
		panelInferior.setBounds(5, 210, 890, 360);
		panelInferior.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panelInferior);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.WHITE);
		menuBar.setBackground(Color.BLACK);
		menuBar.setBounds(0, 5, 900, 21);
		panelSuperior.add(menuBar);
		
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
		
		JMenuItem mntmPontuacao = new JMenuItem("Pontuar Aluno");
		mntmPontuacao.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/icons/pontuar.png")));
		mntmPontuacao.setForeground(Color.WHITE);
		mntmPontuacao.setBackground(Color.BLACK);
		mnProfessor.add(mntmPontuacao);
		
		mntmPontuacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPontuacao telaPontuacao = new TelaPontuacao();
				telaPontuacao.setLocationRelativeTo(null);
				telaPontuacao.setVisible(true);
			}
		});
		
		JMenu mnColaborador = new JMenu("Colaborador");
		mnColaborador.setForeground(Color.WHITE);
		menuBar.add(mnColaborador);
		
		JMenuItem mntmCadastrarProfessor = new JMenuItem("Cadastrar professor");
		mntmCadastrarProfessor.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/icons/client-account-template-icon.png")));
		mntmCadastrarProfessor.setBackground(Color.BLACK);
		mntmCadastrarProfessor.setForeground(Color.WHITE);
		mnColaborador.add(mntmCadastrarProfessor);
		
		mntmCadastrarProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroProfessor cadastroProfessor = new TelaCadastroProfessor();
				cadastroProfessor.setLocationRelativeTo(null);
				cadastroProfessor.setVisible(true);
			}
		});
		
		JMenuItem mntmGerenciarContas = new JMenuItem("Gerenciar contas");
		mntmGerenciarContas.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/icons/Documents-icon.png")));
		mntmGerenciarContas.setForeground(Color.WHITE);
		mntmGerenciarContas.setBackground(Color.BLACK);
		mnColaborador.add(mntmGerenciarContas);
		
		JMenuItem mntmNovaDisciplina = new JMenuItem("Nova Disciplina");
		mntmNovaDisciplina.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/icons/Books-icon.png")));
		mntmNovaDisciplina.setForeground(Color.WHITE);
		mntmNovaDisciplina.setBackground(Color.BLACK);
		mnColaborador.add(mntmNovaDisciplina);
		
		mntmNovaDisciplina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaNovaDisciplina listarPessoas = new TelaNovaDisciplina();
				listarPessoas.setLocationRelativeTo(null);
				listarPessoas.setVisible(true);
			}
		});
		
		JMenuItem mntmListarUsuarios = new JMenuItem("Todos os usuários");
		mntmListarUsuarios.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/icons/user.png")));
		mntmListarUsuarios.setForeground(Color.WHITE);
		mntmListarUsuarios.setBackground(Color.BLACK);
		mnColaborador.add(mntmListarUsuarios);
		
		mntmListarUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListarPessoas listarPessoas = new TelaListarPessoas();
				listarPessoas.setLocationRelativeTo(null);
				listarPessoas.setVisible(true);
			}
		});
		
		JMenuItem mntmListarAlunosPontuacao = new JMenuItem("Alunos por pontuação");
		mntmListarAlunosPontuacao.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/icons/user1.png")));
		mntmListarAlunosPontuacao.setForeground(Color.WHITE);
		mntmListarAlunosPontuacao.setBackground(Color.BLACK);
		mnColaborador.add(mntmListarAlunosPontuacao);
		
		mntmListarAlunosPontuacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListarAlunosPontuacao listarAlunoPontuacao = new TelaListarAlunosPontuacao();
				listarAlunoPontuacao.setLocationRelativeTo(null);
				listarAlunoPontuacao.setVisible(true);
			}
		});
		
		JMenuItem mntmMatricularAluno = new JMenuItem("Matricular Aluno");
		mntmMatricularAluno.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/icons/user1.png")));
		mntmMatricularAluno.setForeground(Color.WHITE);
		mntmMatricularAluno.setBackground(Color.BLACK);
		mnColaborador.add(mntmMatricularAluno);
		
		mntmMatricularAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MatriculaAlunoDisciplina matricularAluno = new MatriculaAlunoDisciplina();
				matricularAluno.setLocationRelativeTo(null);
				matricularAluno.setVisible(true);
			}
		});

		JMenu mnBusca = new JMenu("Buscas");
		mnBusca.setForeground(Color.WHITE);
		menuBar.add(mnBusca);
		
		JMenuItem mntmBuscarAluno = new JMenuItem("Buscar Alunos");
		mntmBuscarAluno.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/icons/search.png")));
		mntmBuscarAluno.setForeground(Color.WHITE);
		mntmBuscarAluno.setBackground(Color.BLACK);
		mnBusca.add(mntmBuscarAluno);
		
		mntmBuscarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaTurma busca = new TelaTurma();
				busca.setLocationRelativeTo(null);
				busca.setVisible(true);
			}
		});
		
		JMenu mnCompletarCadastro = new JMenu("Editar");
		mnCompletarCadastro.setForeground(Color.WHITE);
		menuBar.add(mnCompletarCadastro);
		
		JMenuItem mntmEditar = new JMenuItem("Atualizar Dados");
		mntmEditar.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/icons/Card-file-icon.png")));
		mntmEditar.setForeground(Color.WHITE);
		mntmEditar.setBackground(Color.BLACK);
		mnCompletarCadastro.add(mntmEditar);
		
		mntmEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAtualizarDados atualizarDados = new TelaAtualizarDados();
				atualizarDados.setLocationRelativeTo(null);
				atualizarDados.setVisible(true);
			}
		});
		
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

		PessoaDAO pessoaLogada = new PessoaDAO();
		JMenu mnNomeLogado = new JMenu(pessoaLogada.getNomeLogado());
		mnNomeLogado.setForeground(Color.WHITE);
		menuBar.add(Box.createHorizontalGlue());
		menuBar.add(mnNomeLogado);
		
		JLabel jlImagePanel = new JLabel("");
		jlImagePanel.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/menu.jpg")));
		jlImagePanel.setBounds(0, 0, 900, 200);
		panelSuperior.add(jlImagePanel);
		
						
	}
}
