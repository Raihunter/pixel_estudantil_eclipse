package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.AlunoController;
import controller.DisciplinaController;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class TelaTurma extends JFrame {

	private JPanel contentPane;
	private JButton btnListar;
	private JButton btnBuscar;
	private javax.swing.JComboBox<Object> jComboBoxDisciplinas;
	private JTextArea lista;
	private javax.swing.JScrollPane scrollPane;
	private AlunoController alunoController = new AlunoController();
	private DisciplinaController disciplinaController = new DisciplinaController();

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
		String item1 = "Todas as Disciplinas";
		String item2 = "Ordem Por Idade";
		jComboBoxDisciplinas.setModel(new DefaultComboBoxModel<>(new String[] {item1, item2}));
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
				lista.setText("");
				lista.append(alunoController.buscarAlunoMap(tfIDaluno.getText()));
			}
		});
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setBackground(Color.BLUE);
		btnBuscar.setBounds(200, 100, 100, 25);
		panel.add(btnBuscar);
		
		disciplinaController.popularComboBox(jComboBoxDisciplinas);
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(jComboBoxDisciplinas.getSelectedItem().equals(item1)) {
					lista.setText("");
					alunoController.listarMapDetalhe(lista);
				}
				else {
					if(jComboBoxDisciplinas.getSelectedItem().equals(item2)) {
						lista.setText("");
						alunoController.ordenarPorIdade(lista);
					} else {
						alunoController.listarMap(jComboBoxDisciplinas, lista);
					}
				}
			}
		});
		btnListar.setForeground(Color.WHITE);
		btnListar.setBackground(Color.BLUE);
		btnListar.setBounds(200, 50, 100, 25);
		panel.add(btnListar);
		
		scrollPane = new javax.swing.JScrollPane();
		scrollPane.setBounds(40, 205, 450, 140);
		contentPane.add(scrollPane);
		
		lista = new JTextArea();
		lista.setColumns(20);
		lista.setRows(5);
		scrollPane.setViewportView(lista);
		
		alunoController.listarMapDetalhe(lista);
	}

}

