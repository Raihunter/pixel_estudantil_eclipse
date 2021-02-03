package sistema;

import java.util.ArrayList;
import java.util.List;
import pessoas.Pessoa;
import disciplinas.Disciplina;

/**
 *
 * @author Raimundo
 */
public class Sistema {
    
    private String nomeDoSistema;
    private String cnpj;
    private List<Pessoa> pessoas;
    private List<Disciplina> disciplinas;
    
    public Sistema(){
        this.pessoas = new ArrayList<>();
        this.disciplinas = new ArrayList<>();
    }

    public String getNomeDoSistema() {
        return nomeDoSistema;
    }

    public void setNomeDoSistema(String nomeDoSistema) {
        this.nomeDoSistema = nomeDoSistema;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    public void setPessoas(Pessoa umaPessoa) {
        this.pessoas.add(umaPessoa);
    }
    
    public void setDisciplina(Disciplina umaDisciplina){
        this.disciplinas.add(umaDisciplina);
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }
    
    public void imprimirPessoas(){
        for (Pessoa p : this.pessoas){
            System.out.println(p);
        }
    }
    
    public void imprimirDisciplinas(){
        for (Disciplina d : this.disciplinas){
            System.out.println(d);
        }
    }
    
}
