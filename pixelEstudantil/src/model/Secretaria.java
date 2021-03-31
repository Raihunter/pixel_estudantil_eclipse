package model;

import interfaces.Autenticavel;
import interfaces.PessoaRepositorio;
import dao.PessoaDAO;

/**
 *
 * @author Raimundo
 */
public class Secretaria extends Funcionario implements Autenticavel{
    
    private static int gerarCodigo;
    private int codigo;
    private String id = "SE";
    
    public Secretaria(String nome, String email, String senha){
        super(nome, email, senha);
        this.codigo = gerarCodigo++;//com isso o id secretaria sera automatizado para toda secretaria criada.
        this.id += this.codigo;
        super.setID(id);
    }
    
    public Secretaria(String nome, String email){
        super(nome, email);
        this.codigo = gerarCodigo++;//com isso o id aluno sera automatizado para todo aluno criado.
        this.id += this.codigo;
        super.setID(id);
    }
    
    public String getIdSecretaria(){
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
    public boolean autenticaSenha(String senha) {
        if (this.getPassword() != senha){
            return false;
        }
        return true;
    }


}
