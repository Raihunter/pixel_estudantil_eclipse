package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author raimundo
 */
public class Disciplina {
    
    private String nome;
    private String codigo;
    private String iniciaisNome;
    private List<Aluno> alunos;

    public Disciplina(String nome, int codigo) {
        this.nome = nome;
        this.iniciaisNome = nome.substring(0, 3);
        this.codigo = this.iniciaisNome+"-"+codigo;
        this.alunos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo.toUpperCase();
    }
    
    public List<Aluno> getListaDeAlunos(){
    	return this.alunos;
    }
    
    public void setAluno(Aluno a) {
    	this.alunos.add(a);
    	a.setDisciplina(this);
    }
    
    public String imprimirDisciplina() {
    	return "Disciplina - " + "nome = " + nome + ", codigo = " + codigo.toUpperCase();
    }
    
    @Override
    public String toString() {
        return getNome();
    }
    
}
