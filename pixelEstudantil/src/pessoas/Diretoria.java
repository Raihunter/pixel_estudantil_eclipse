package pessoas;

import disciplinas.Disciplina;
import interfaces.Autenticavel;
import sistema.Sistema;

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
    }
    
    public String getIdDiretoria(){
        return this.id;
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

    @Override
    public Disciplina criarDisciplina(String nome, int codigo) {
        Disciplina umaDisciplina = new Disciplina(nome, codigo);
        return umaDisciplina;
    }

           
}
