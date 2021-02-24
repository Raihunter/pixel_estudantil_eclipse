package pessoas;

/**
 *
 * @author Raimundo
 */
public abstract class Funcionario extends Pessoa {

    public Funcionario(String nome, String email, String senha) {
        super(nome, email, senha);
    }
    
    public Funcionario(String nome, String email) {
    	super(nome, email);
    }
    
    public abstract void gravarProfessor(Professor professor);

}
