package sistema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import pessoas.Aluno;
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
    private List<Aluno> alunos;
    private List<Disciplina> disciplinas;
    
    public Sistema(){
        this.pessoas = new ArrayList<>();
        this.disciplinas = new ArrayList<>();
        this.alunos = new ArrayList<>();
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
    
    public void setPessoas(Pessoa p) {
        this.pessoas.add(p);
        if(p instanceof Aluno) {
        	Aluno a = (Aluno)p;
        	this.alunos.add(a);
        }
    }
        
    public List<Pessoa> getListaPessoa(){
    	return this.pessoas;
    }
    
    public void setDisciplina(Disciplina disc){
        this.disciplinas.add(disc);
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }
    
    //Interando lista de alunos com functional programming após utilizar o comparator    
    public void imprimirAlunosClassificadosPorPontuacao() {
    	Collections.sort(this.alunos, new Comparator<Aluno>() {
    		@Override
    		public int compare(Aluno a, Aluno b) {
    			if (a.getPontuacao() > b.getPontuacao())
    				return -1;
    			else
    				return 1;
    		}
    	});
    	alunos.forEach(a -> System.out.println(a));
    }
    
//Impressões na tela
    
    //Interação através do forEach e utilizando classe anônima.
    public void imprimirPessoas(){
        pessoas.forEach(new Consumer<Pessoa>() {
        	@Override
        	public void accept(Pessoa p) {
        		System.out.println(p);
        	}
        });
    }
    
    //Interação utilizando for para collections.
    public void imprimirDisciplinas(){
        for (Disciplina d : this.disciplinas){
            System.out.println(d);
        }
    }
    //Imprimindo somento os alunos da lista de pessoas utilizando instenceof
    public void imprimirAlunos() {
    	for (Pessoa p : this.pessoas) {
    		if (p instanceof Aluno) {
    			System.out.println(p);
    		}
    	}
    }
       
}
