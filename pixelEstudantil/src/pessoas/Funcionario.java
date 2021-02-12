package pessoas;

/**
 *
 * @author Raimundo
 */
public abstract class Funcionario extends Pessoa {

    public Funcionario(String nome, String email, String senha) {
        super(nome, email, senha);
    }
    
    public abstract void criarProfessor(Professor p, String senha);

}
