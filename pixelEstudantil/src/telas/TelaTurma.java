package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import dao.PessoaDAO;
import disciplinas.Disciplina;
import pessoas.Aluno;
import pessoas.Pessoa;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.management.ObjectName;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;

public class TelaTurma extends JFrame {

	private JPanel contentPane;
	private JTextField tfNomeDisciplina;
	private JTextField tfCodigo;
	private JButton btnConfirmar;
	private JButton btnBuscar;
	private javax.swing.JComboBox<Object> jComboBoxDisciplinas;
	private JTextArea lista;
	private javax.swing.JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaTurma frame = new TelaTurma();
					frame.setVisible(true);
					frame.setSize(527, 400);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaTurma() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Turmas de Alunos");
		setBounds(0, 0, 527, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setLocation(40, 20);
		panel.setSize(450, 150);
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel labelNovaDisciplina = new JLabel("Buscar Alunos");
		labelNovaDisciplina.setFont(new Font("Dialog", Font.BOLD, 16));
		labelNovaDisciplina.setBounds(10, 10, 200, 15);
		panel.add(labelNovaDisciplina);
		
		jComboBoxDisciplinas = new javax.swing.JComboBox<>();
		String name = "Todas as Disciplinas";
		jComboBoxDisciplinas.setModel(new DefaultComboBoxModel<>(new String[] {name}));
		jComboBoxDisciplinas.setBounds(10, 50, 180, 25);
		panel.add(jComboBoxDisciplinas);
		
		JLabel labelIDaluno = new JLabel("Por ID:");
		labelIDaluno.setFont(new Font("Dialog", Font.BOLD, 14));
		labelIDaluno.setBounds(10, 100, 60, 25);
		panel.add(labelIDaluno);
		
		JTextField tfIDaluno = new JTextField("");
		tfIDaluno.setBounds(70, 100, 100, 25);
		panel.add(tfIDaluno);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarAlunoMap(tfIDaluno.getText());
			}
		});
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setBackground(Color.BLUE);
		btnBuscar.setBounds(200, 100, 100, 25);
		panel.add(btnBuscar);
		
		//popularArea();
		popularComboBox();
		
		btnConfirmar = new JButton("Listar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(jComboBoxDisciplinas.getSelectedItem().equals(name)) {
					listarMapTest();
				} else {
					Disciplina disciplina = (Disciplina)jComboBoxDisciplinas.getSelectedItem();
					listarMap(disciplina);
				}
			}
		});
		btnConfirmar.setForeground(Color.WHITE);
		btnConfirmar.setBackground(Color.BLUE);
		btnConfirmar.setBounds(200, 50, 100, 25);
		panel.add(btnConfirmar);
		
		scrollPane = new javax.swing.JScrollPane();
		scrollPane.setBounds(40, 205, 450, 140);
		contentPane.add(scrollPane);
		
		lista = new JTextArea();
		lista.setColumns(20);
		lista.setRows(5);
		scrollPane.setViewportView(lista);
		
		listarMapTest();
	}
	
	public void popularArea() {
		PessoaDAO pessoaDAO = new PessoaDAO();
		Disciplina matematica = new Disciplina("Matemática", 1);
		Disciplina portugues = new Disciplina("Portugues", 1);
		pessoaDAO.gravarDiciplina(matematica);
		pessoaDAO.gravarDiciplina(portugues);
		
		Aluno a1 = new Aluno("Raimundo", "rai@gmail.com");
		Aluno a2 = new Aluno("Antonio", "ant@gmail.com");
		Aluno a3 = new Aluno("Maria", "rai@gmail.com");
		Aluno a4 = new Aluno("Joao", "ant@gmail.com");
		matematica.setAluno(a1);
		portugues.setAluno(a2);
		matematica.setAluno(a3);
		portugues.setAluno(a4);
		pessoaDAO.gravarPessoa(a1);
		pessoaDAO.gravarPessoa(a2);
		pessoaDAO.gravarPessoa(a3);
		pessoaDAO.gravarPessoa(a4);
	}
	
	public void popularComboBox() {
		PessoaDAO pessoaDAO = new PessoaDAO();
        for(Disciplina disc : pessoaDAO.buscarTodasDisciplinas()) {
            jComboBoxDisciplinas.addItem(disc);
        }
	}
	
	public void listarMap(Disciplina disciplina) {
		PessoaDAO pessoaDAO = new PessoaDAO();
		
		Map<Disciplina, List<Aluno>> map = new HashMap<>();
		
		map.put(disciplina, disciplina.getListaDeAlunos());
		lista.setText("");
		for(Map.Entry<Disciplina, List<Aluno>> entry : map.entrySet()) {
			lista.append(entry.getKey().getNome()+"\n\n");
			for(Aluno p : entry.getValue()) {
				lista.append("Matricula: "+p.getID()+" - "+p.getNome()+"\n");
			}
		}
	}
	public void listarMapTest() {
		PessoaDAO pessoaDAO = new PessoaDAO();	
		
		Map<Disciplina, List<Aluno>> map = new HashMap<>();

		for(Disciplina disciplina: pessoaDAO.buscarTodasDisciplinas()) {
			map.put(disciplina, disciplina.getListaDeAlunos());
			lista.setText("");
			for(Map.Entry<Disciplina, List<Aluno>> entry : map.entrySet()) {
				lista.append(entry.getKey().getNome()+"\n\n");
				for(Aluno p : entry.getValue()) {
					lista.append("Matricula: "+p.getID()+" - "+p.getNome()+"\n");
				}
				lista.append("\n");
			}
		}
	}
	public void buscarAlunoMap(String ID) {
		PessoaDAO pessoaDAO = new PessoaDAO();
		
		Map<String, List<Aluno>> map = new HashMap<>();
		map.put(ID, pessoaDAO.getAlunos());
		
		lista.setText("");
		for(Map.Entry<String, List<Aluno>> entry : map.entrySet()) {
			for(Aluno p : entry.getValue()) {
				if(ID.equals(p.getID()))
					lista.append(p.toString());
			}
		}
	}
}

