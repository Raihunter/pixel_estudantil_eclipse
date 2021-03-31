
package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dao.PessoaDAO;
//import model.Aluno;
//import model.Pessoa;

@SuppressWarnings("serial")
public class TelaAtualizarDados extends javax.swing.JFrame {
	
	//Teste de funcionamento
//	public void testeFuncionamento() {
//		PessoaDAO pessoaDAO = new PessoaDAO();
//		Pessoa pessoa1 = new Aluno("Raimundo", "rai@email.com");
//		pessoaDAO.setPessoaLogada(pessoa1);
//		pessoa1.setIdade(Integer.parseInt(tfIdade.getText()));
//		//printIdadeLogado();
//	}
	public void printIdadeLogado() {
		PessoaDAO pessoaDAO = new PessoaDAO();
		JOptionPane.showMessageDialog(null, pessoaDAO.getPessoaLogada().getNome()+" tem "+pessoaDAO.getPessoaLogada().getIdade()+" anos.");
	}

    public TelaAtualizarDados() {
        initComponents();
        //testeFuncionamento();
        //printIdadeLogado();
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        tfSobrenome = new javax.swing.JTextField();
        tfDadaNascimento = new javax.swing.JTextField();
        tfSexo = new javax.swing.JTextField();
        tfIdade = new javax.swing.JTextField();
        tfTelefone = new javax.swing.JTextField();
        tfEscolaridade = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        tfCEP = new javax.swing.JTextField();
        tfRua = new javax.swing.JTextField();
        tfNumero = new javax.swing.JTextField();
        tfComplemento = new javax.swing.JTextField();
        tfBairro = new javax.swing.JTextField();
        tfCidade = new javax.swing.JTextField();
        tfEstado = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Atualizar dados do usuário");
        setPreferredSize(new java.awt.Dimension(900, 600));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Seus Dados");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(17, 30, 118, 22);

        jPanel1.setPreferredSize(new java.awt.Dimension(425, 450));
        jPanel1.setLayout(null);

        jLabel2.setText("NOME:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(12, 20, 97, 16);

        jLabel3.setText("SOBRENOME:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(12, 80, 97, 16);

        jLabel4.setText("SEXO:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(12, 145, 97, 16);

        jLabel5.setText("DATA DE NASC.:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(12, 209, 110, 16);

        jLabel6.setText("IDADE:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(12, 274, 97, 16);

        jLabel7.setText("TELEFONE:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(12, 340, 97, 16);

        jLabel8.setText("ESCOLARIDADE:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(12, 400, 110, 16);
        jPanel1.add(tfNome);
        tfNome.setBounds(121, 12, 250, 32);
        jPanel1.add(tfSobrenome);
        tfSobrenome.setBounds(121, 72, 250, 32);
        jPanel1.add(tfDadaNascimento);
        tfDadaNascimento.setBounds(121, 201, 250, 32);
        jPanel1.add(tfSexo);
        tfSexo.setBounds(121, 137, 250, 32);
        
        jPanel1.add(tfIdade);
        tfIdade.setBounds(121, 266, 250, 32);
        
        
        jPanel1.add(tfTelefone);
        tfTelefone.setBounds(121, 332, 250, 32);
        jPanel1.add(tfEscolaridade);
        tfEscolaridade.setBounds(121, 392, 250, 32);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(20, 70, 425, 450);

        jPanel2.setPreferredSize(new java.awt.Dimension(425, 450));
        jPanel2.setLayout(null);

        jLabel9.setText("CEP:");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(12, 19, 99, 16);

        jLabel10.setText("RUA:");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(12, 82, 99, 16);

        jLabel11.setText("NÚMERO:");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(12, 143, 99, 16);

        jLabel12.setText("COMPLEMENTO:");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(12, 207, 120, 16);

        jLabel13.setText("BAIRRO:");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(12, 271, 99, 16);

        jLabel14.setText("CIDADE:");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(12, 336, 99, 16);

        jLabel15.setText("ESTADO:");
        jPanel2.add(jLabel15);
        jLabel15.setBounds(12, 400, 99, 16);
        jPanel2.add(tfCEP);
        tfCEP.setBounds(123, 11, 250, 32);
        jPanel2.add(tfRua);
        tfRua.setBounds(123, 74, 250, 32);
        jPanel2.add(tfNumero);
        tfNumero.setBounds(123, 135, 250, 32);
        jPanel2.add(tfComplemento);
        tfComplemento.setBounds(123, 199, 250, 32);
        jPanel2.add(tfBairro);
        tfBairro.setBounds(123, 263, 250, 32);
        jPanel2.add(tfCidade);
        tfCidade.setBounds(123, 328, 250, 32);
        jPanel2.add(tfEstado);
        tfEstado.setBounds(123, 392, 250, 32);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(460, 70, 425, 450);

        btnSalvar.setText("Salvar");
        getContentPane().add(btnSalvar);
        btnSalvar.setBounds(20, 520, 100, 36);
        
        btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PessoaDAO pessoaDAO = new PessoaDAO();
				pessoaDAO.getPessoaLogada().setIdade(Integer.parseInt(tfIdade.getText()));
				printIdadeLogado();
			}
		});

        btnSair.setText("Sair");
        getContentPane().add(btnSair);
        btnSair.setBounds(140, 520, 100, 36);

        pack();
    }// </editor-fold>                        

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAtualizarDados frame = new TelaAtualizarDados();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					frame.setSize(900, 600);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField tfBairro;
    private javax.swing.JTextField tfCEP;
    private javax.swing.JTextField tfCidade;
    private javax.swing.JTextField tfComplemento;
    private javax.swing.JTextField tfDadaNascimento;
    private javax.swing.JTextField tfIdade;
    private javax.swing.JTextField tfEscolaridade;
    private javax.swing.JTextField tfEstado;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfNumero;
    private javax.swing.JTextField tfRua;
    private javax.swing.JTextField tfSexo;
    private javax.swing.JTextField tfSobrenome;
    private javax.swing.JTextField tfTelefone;
    // End of variables declaration                   

}
