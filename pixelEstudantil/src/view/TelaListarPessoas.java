package view;

import java.awt.EventQueue;

import dao.PessoaDAO;
//import model.Aluno;
//import model.Pessoa;
//import model.Professor;
//import model.Secretaria;
import tablelModel.PessoasTableModel;

@SuppressWarnings("serial")
public class TelaListarPessoas extends javax.swing.JFrame {

//    public void popularTabela(){
//
//    	PessoaDAO pessoaDAO = new PessoaDAO();
//    	Pessoa pessoa1 = new Aluno("Raimundo", "hilaryoncx@gmail.com");
//        Pessoa pessoa2 = new Aluno("nesuku", "nesuku@gmail.com");
//        Pessoa pessoa3 = new Professor("Matheus", "matheus@gmail.com");
//        Pessoa pessoa4 = new Secretaria("Marilia", "marilia@gmail.com");
//        Secretaria sec = (Secretaria)pessoa4;
//        sec.gravarProfessor((Professor)pessoa3);
//    	pessoaDAO.gravarPessoa(pessoa1);
//    	pessoaDAO.gravarPessoa(pessoa2);
//    	pessoaDAO.gravarPessoa(pessoa4);
//    	
//    }
    public TelaListarPessoas() {
        initComponents();
        //popularTabela();
        PessoaDAO pessoaDAO = new PessoaDAO();
        tablePessoas.setModel(new PessoasTableModel(pessoaDAO.buscarTodasPessoas()));
    }
    
    private void initComponents() {
    	
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePessoas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tablePessoas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablePessoas);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(5, Short.MAX_VALUE))
        );

        pack();
    }
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListarPessoas frame = new TelaListarPessoas();
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
    private javax.swing.JTable tablePessoas;
    // End of variables declaration//GEN-END:variables
}
