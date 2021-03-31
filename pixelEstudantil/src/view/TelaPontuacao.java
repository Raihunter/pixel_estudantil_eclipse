package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dao.PessoaDAO;
import tablelModel.AlunosTableModel;

@SuppressWarnings("serial")
public class TelaPontuacao extends javax.swing.JFrame {
	
//	public void popularTabela(){
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

	public TelaPontuacao() {
        initComponents();
        //popularTabela();
        PessoaDAO pessoaDAO = new PessoaDAO();
        jTablePontuacao.setModel(new AlunosTableModel(pessoaDAO.imprimirAlunosClassificadosPorPontuacao()));
    }

    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePontuacao = new javax.swing.JTable();
        btnAtualizarPontuacao = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tfPontos = new javax.swing.JTextField();
        

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTablePontuacao.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTablePontuacao);

        btnAtualizarPontuacao.setText("ATUALIZAR");
        btnAtualizarPontuacao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(jTablePontuacao.getSelectedRow() != -1) {
						jTablePontuacao.setValueAt(tfPontos.getText(), jTablePontuacao.getSelectedRow(), 2);
						tfPontos.setText("");
				}
			}
		});
        
        jLabel1.setText("Pontos:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfPontos, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAtualizarPontuacao, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAtualizarPontuacao)
                    .addComponent(jLabel1)
                    .addComponent(tfPontos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        pack();
    }                      

                                                      
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPontuacao frame = new TelaPontuacao();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					frame.setSize(527, 335);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

    // Variables declaration
    private javax.swing.JButton btnAtualizarPontuacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePontuacao;
    private javax.swing.JTextField tfPontos;
    // End of variables declaration                   
}
