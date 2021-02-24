
package telas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import dao.PessoaDAO;
import disciplinas.Disciplina;
import exceptions.MatriculaException;
import pessoas.Aluno;
import pessoas.Pessoa;
import telasAuxiliares.TelaPontuacao;
import telas.TelaListarAlunoMatriculado;

public class MatriculaAlunoDisciplina extends javax.swing.JFrame {
	
	public void popularTabela() {
		PessoaDAO pessoaDAO = new PessoaDAO();
		Disciplina matematica = new Disciplina("Matemática", 1);
		Disciplina portugues = new Disciplina("Portugues", 1);
		pessoaDAO.gravarDiciplina(matematica);
		pessoaDAO.gravarDiciplina(portugues);
		
		Aluno a1 = new Aluno("Raimundo", "rai@gmail.com");
		pessoaDAO.gravarPessoa(a1);
	}

    public MatriculaAlunoDisciplina() {
        initComponents();
        //popularTabela();
        PessoaDAO pessoaDAO = new PessoaDAO();
        jtableDisciplina.setModel(new DisciplinaTableModel(pessoaDAO.buscarTodasDisciplinas()));
    }
                       
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtableDisciplina = new javax.swing.JTable();
        btnMatricular = new javax.swing.JButton();
        btnListarAlunos = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tfIdAluno = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Matricular aluno em uma disciplina");

        jLabel1.setText("Lista de disciplinas");

        jtableDisciplina.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtableDisciplina);

        btnMatricular.setText("Matricular");
        
        btnMatricular.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PessoaDAO pessoaDAO = new PessoaDAO();
				String codigoDisciplina = jtableDisciplina.getValueAt(jtableDisciplina.getSelectedRow(), 0).toString();
				String idAluno = tfIdAluno.getText();
				try {
					pessoaDAO.matricularAluno(codigoDisciplina, idAluno);
					JOptionPane.showMessageDialog(null, "Aluno matriculado");
				} catch (MatriculaException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
        
        jLabel2.setText("ID do Aluno:");

        btnListarAlunos.setText("Listar Alunos");
        
        btnListarAlunos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaListarAlunoMatriculado listaAlunoMatriculado = new TelaListarAlunoMatriculado();
				listaAlunoMatriculado.setLocationRelativeTo(null);
				listaAlunoMatriculado.setVisible(true);
			}
		});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(tfIdAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(btnMatricular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(btnListarAlunos)))
                        .addGap(0, 100, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMatricular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(tfIdAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                	.addComponent(btnListarAlunos))
                .addContainerGap())
        );

        pack();
    }

    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MatriculaAlunoDisciplina frame = new MatriculaAlunoDisciplina();
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
    private javax.swing.JButton btnMatricular;
    private javax.swing.JButton btnListarAlunos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtableDisciplina;
    private javax.swing.JTextField tfIdAluno;
    // End of variables declaration                   
}
