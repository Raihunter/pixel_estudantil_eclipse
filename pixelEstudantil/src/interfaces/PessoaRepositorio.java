package interfaces;

import java.util.List;

import model.Disciplina;
import model.Pessoa;

public interface PessoaRepositorio {
	
	public void gravarPessoa(Pessoa p);
    public Pessoa buscar(String ID);
    public void gravarDiciplina(Disciplina d);
    public List<Pessoa> buscarTodasPessoas();
    public List<Disciplina> buscarTodasDisciplinas();
    
}
