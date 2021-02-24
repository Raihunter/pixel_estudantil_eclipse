package dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import disciplinas.Disciplina;
import exceptions.MatriculaException;
import interfaces.PessoaRepositorio;
import pessoas.Aluno;
import pessoas.Pessoa;
import pessoas.Secretaria;
import pessoas.Diretoria;
import pessoas.Funcionario;

public class PessoaDAO implements PessoaRepositorio {
	
	private static List<Pessoa> pessoas;
	private static List<Aluno> alunos;
	private static Set<Pessoa> alunosSet;
	private static List<Disciplina> disciplinas;
	private static Pessoa pessoaLogada;
	private static Disciplina disciplinaSet;
	
	public PessoaDAO() {
		if(pessoas == null) {
			this.pessoas = new ArrayList<>();
			this.alunos = new ArrayList<>();
			this.disciplinas = new ArrayList<>();
		}
	}
	
	//Interando lista de alunos com comparator    
    public List<Aluno> imprimirAlunosClassificadosPorPontuacao() {
    	Collections.sort(this.alunos, new Comparator<Aluno>() {
    		@Override
    		public int compare(Aluno a, Aluno b) {
    			if (a.getPontuacao() > b.getPontuacao())
    				return -1;
    			else
    				return 1;
    		}
    	});
    	return alunos;
    }
    
    public void setPessoaLogada(Pessoa p) {
    	this.pessoaLogada = p;
    }
    
    public Pessoa getPessoaLogada() {
    	return this.pessoaLogada;
    }
    
    public static Set<Pessoa> getAlunosSet(){
    	return alunosSet;
    }
    
    public static Disciplina getDisciplinaSet() {
		return disciplinaSet;
	}

	public static void setDisciplinaSet(Disciplina disciplinaSet) {
		alunosSet = new HashSet<>();
		alunosSet.addAll(disciplinaSet.getListaDeAlunos());
		PessoaDAO.disciplinaSet = disciplinaSet;
	}

	//Posso tratar uma excesao aqui
    public String getNomeLogado() {
    	if(pessoaLogada == null) {
    		return "";
    	}
    	return pessoaLogada.getNome();
    }
    
    public boolean validarLogin(String usuario, String senha) {
    	boolean logado = false;
    	for(Pessoa p : pessoas) {
    		if(p.getNome().equals(usuario) && p.getPassword().equals(senha)) {
    			pessoaLogada = p;
    			logado = true;
    		}
    	}
    	return logado;
    }
    
    public void matricularAluno(String codigoTabela, String idALuno) throws MatriculaException {
		Disciplina disciplina = null;
		for(Disciplina d : this.disciplinas) {
			if(d.getCodigo().equals(codigoTabela)) {
				disciplina = d;
			}
		}
		for(Aluno a : this.alunos) {
			if(a.getID().equals(idALuno)) {
				disciplina.setAluno(a);
				a.setDisciplinas(disciplinas);
			}
		}
		if(disciplina == null) {
			throw new MatriculaException();
		}
	}
    
    public List<Aluno> getAlunos(){
    	return this.alunos;
    }

    @Override
	public void gravarPessoa(Pessoa p) {
		this.pessoas.add(p);
		if(p instanceof Aluno) {
			Aluno a = (Aluno)p;
			this.alunos.add(a);
		}
	}

	@Override
	public Pessoa buscar(String ID) {
		for(Pessoa p : pessoas) {
			if(p.getID().equals(ID)) {
				return p;
			}
		}
		return null;
	}

	@Override
	public List<Pessoa> buscarTodasPessoas() {
		return pessoas;
	}

	@Override
	public void gravarDiciplina(Disciplina d) {
		this.disciplinas.add(d);
	}

	@Override
	public List<Disciplina> buscarTodasDisciplinas() {
		return disciplinas;
	}
	
}
