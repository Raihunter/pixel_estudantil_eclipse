package view;

import java.awt.EventQueue;

import dao.PessoaDAO;
//import model.Aluno;
import tablelModel.AlunosTableModel;

@SuppressWarnings("serial")
public class TelaListarAlunosPontuacao extends javax.swing.JFrame {

//    public void popularTabela(){
//
//    	PessoaDAO pessoaDAO = new PessoaDAO();
//    	Aluno aluno1 = new Aluno("Raimundo", "hilaryoncx@gmail.com");
//    	//Aluno a1 = (Aluno)pessoa1;
//    	aluno1.setPontuacao(25);
//        Aluno aluno2 = new Aluno("nesuku", "nesuku@gmail.com");
//    	//Aluno a2 = (Aluno)pessoa2;
//    	aluno2.setPontuacao(50);
//    	pessoaDAO.gravarPessoa(aluno1);
//    	pessoaDAO.gravarPessoa(aluno2);
//    	
//    }
    public TelaListarAlunosPontuacao() {
        initComponents();
        //popularTabela();
        PessoaDAO pessoaDAO = new PessoaDAO();
        tableAlunosPontuacao.setModel(new AlunosTableModel(pessoaDAO.imprimirAlunosClassificadosPorPontuacao()));
    }
    
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableAlunosPontuacao = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tableAlunosPontuacao.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableAlunosPontuacao);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(5, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(5, Short.MAX_VALUE))
        );

        pack();
    }
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListarAlunosPontuacao frame = new TelaListarAlunosPontuacao();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					frame.setSize(527, 335);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableAlunosPontuacao;
    // End of variables declaration//GEN-END:variables
}
