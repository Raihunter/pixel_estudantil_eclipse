package interfaces;

import java.util.List;

import disciplinas.Disciplina;
import pessoas.Pessoa;

public interface PessoaRepositorio {
	public void gravarPessoa(Pessoa p);
    public Pessoa buscar(String ID);
    public List<Pessoa> buscarTodasPessoas();
    
    public void gravarDiciplina(Disciplina d);
    public List<Disciplina> buscarTodasDisciplinas();
}
