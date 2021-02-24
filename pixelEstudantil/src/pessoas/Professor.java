package pessoas;
/**
 *
 * @author Raimundo
 */
public class Professor extends Pessoa {
    
    private static int gerarCodigo;
    private int codigo;
    private String id = "PF";
    
    public Professor(String nome, String email, String senha){
        super(nome, email, senha);
        this.codigo = gerarCodigo++;//com isso o id professor sera automatizado para todo professor criado.
        this.id += this.codigo;
        super.setID(id);
    }
    
    public Professor(String nome, String email){
        super(nome, email);
        this.codigo = gerarCodigo++;//com isso o id aluno sera automatizado para todo aluno criado.
        this.id += this.codigo;
        super.setID(id);
    }
    
    public String getIdProfessor(){
        return this.id;
    }

    @Override
    public String toString(){
        return  "Matricula = "+this.id+
                super.imprimirPessoa();
    }

}
