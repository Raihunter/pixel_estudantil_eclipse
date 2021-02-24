package telas;

import java.awt.EventQueue;
import dao.PessoaDAO;
import disciplinas.Disciplina;
import pessoas.Aluno;

/**
 *
 * @author raimundo
 */
public class TelaListarAlunosSet extends javax.swing.JFrame {
	
	public void popularTabela() {
		PessoaDAO pessoaDAO = new PessoaDAO();
		Disciplina matematica = new Disciplina("Matemática", 1);
		//Disciplina portugues = new Disciplina("Portugues", 1);
		
		Aluno a1 = new Aluno("Raimundo", "rai@gmail.com");
		Aluno a2 = new Aluno("Antonio", "ant@gmail.com");
		Aluno a3 = new Aluno("Raimundo", "rai@gmail.com");
		Aluno a4 = new Aluno("Julia", "rai@gmail.com");
		matematica.setAluno(a1);
		matematica.setAluno(a2);
		matematica.setAluno(a3);
		matematica.setAluno(a4);
		pessoaDAO.gravarPessoa(a1);
		pessoaDAO.gravarPessoa(a2);
		pessoaDAO.gravarPessoa(a3);
		pessoaDAO.gravarPessoa(a4);

		pessoaDAO.setDisciplinaSet(matematica);
	}

    public TelaListarAlunosSet() {
        initComponents();
        //popularTabela();
        jtableAlunosNaDisciplina.setModel(new ListarAlunosSetTableModel(PessoaDAO.getAlunosSet()));
    }

    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtableAlunosNaDisciplina = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );

        pack();
    }

    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListarAlunosSet frame = new TelaListarAlunosSet();
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtableAlunosNaDisciplina;
    // End of variables declaration                   
}
