package pessoas;

import dao.PessoaDAO;
import disciplinas.Disciplina;
import interfaces.Autenticavel;
import interfaces.PessoaRepositorio;

/**
 *
 * @author Raimundo
 */
public class Diretoria extends Funcionario implements Autenticavel {

    private static int gerarCodigo;
    private int codigo;
    private String id = "DI";
    
    public Diretoria(String nome, String email, String senha){
        super(nome, email, senha);
        this.codigo = gerarCodigo++;//com isso o id aluno sera automatizado para todo diretoria criada.
        this.id += this.codigo;
        super.setID(id);
    }
    
    public Diretoria(String nome, String email){
        super(nome, email);
        this.codigo = gerarCodigo++;//com isso o id aluno sera automatizado para todo aluno criado.
        this.id += this.codigo;
        super.setID(id);
    }
    
    public String getIdDiretoria(){
        return this.id;
    }
    
    @Override
    public void gravarProfessor(Professor professor) {
		PessoaRepositorio pessoa = new PessoaDAO();
		pessoa.gravarPessoa(professor);
	}
    
    @Override
    public String toString(){
        return  "Matricula = "+this.id+
                super.imprimirPessoa();
    }

    @Override
    public boolean autentica(String senha) {
        if (this.getPassword() != senha){
            return false;
        }
        return true;
    }

         
}
