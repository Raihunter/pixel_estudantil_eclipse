package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.DisciplinaController;
import dao.PessoaDAO;
//import model.Aluno;
//import model.Disciplina;
import tablelModel.AlunosMatriculadosTableModel;

/**
 *
 * @author raimundo
 */
@SuppressWarnings("serial")
public class TelaListarAlunoMatriculado extends javax.swing.JFrame {
//	public void popularTabela() {
//		PessoaDAO pessoaDAO = new PessoaDAO();
//		Disciplina matematica = new Disciplina("Matemática", 1);
//		Disciplina portugues = new Disciplina("Portugues", 1);
//		pessoaDAO.gravarDiciplina(matematica);
//		pessoaDAO.gravarDiciplina(portugues);
//		
//		Aluno a1 = new Aluno("Raimundo", "rai@gmail.com");
//		Aluno a2 = new Aluno("Antonio", "ant@gmail.com");
//		Aluno a3 = new Aluno("Raimundo", "rai@gmail.com");
//		Aluno a4 = new Aluno("Antonio", "ant@gmail.com");
//		matematica.setAluno(a1);
//		//portugues.setAluno(a2);
//		matematica.setAluno(a3);
//		matematica.setAluno(a4);
//		matematica.setAluno(a2);
//		pessoaDAO.gravarPessoa(a1);
//		pessoaDAO.gravarPessoa(a2);
//		pessoaDAO.gravarPessoa(a3);
//		pessoaDAO.gravarPessoa(a4);
//	}
	
	public void popularComboBox() {
		//DisciplinaController disController = new DisciplinaController();
		disController.popularComboBox(jComboBoxDisciplinas);
//		PessoaDAO pessoaDAO = new PessoaDAO();
//        for(Disciplina disc : pessoaDAO.buscarTodasDisciplinas()) {
//            jComboBoxDisciplinas.addItem(disc);
//        }
	}

    public TelaListarAlunoMatriculado() {
        initComponents();
//        popularTabela();
        popularComboBox();
        PessoaDAO pessoaDAO = new PessoaDAO();
        jtableAlunosNaDisciplina.setModel(new AlunosMatriculadosTableModel(pessoaDAO.getAlunos()));
    }

    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtableAlunosNaDisciplina = new javax.swing.JTable();
        jComboBoxDisciplinas = new javax.swing.JComboBox<>();
        btnListar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lista de Alunos Matriculados");

        jtableAlunosNaDisciplina.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtableAlunosNaDisciplina);

        btnListar.setText("Listar");
        
        btnListar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Disciplina disciplina = (Disciplina) jComboBoxDisciplinas.getSelectedItem();
				PessoaDAO.setDisciplinaSet(disController.getDisciplinaSelecionada(jComboBoxDisciplinas));
				TelaListarAlunosSet listaAlunosSet = new TelaListarAlunosSet();
				listaAlunosSet.setLocationRelativeTo(null);
				listaAlunosSet.setVisible(true);
			}
		});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBoxDisciplinas, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxDisciplinas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnListar))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListarAlunoMatriculado frame = new TelaListarAlunoMatriculado();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					frame.setSize(527, 335);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnListar;
    private javax.swing.JComboBox<Object> jComboBoxDisciplinas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtableAlunosNaDisciplina;
    private DisciplinaController disController = new DisciplinaController();
    // End of variables declaration                   
}
