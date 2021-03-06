package tablelModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.table.AbstractTableModel;

import model.Pessoa;

@SuppressWarnings("serial")
public class ListarAlunosSetTableModel extends AbstractTableModel{
	
	private List<Pessoa> listaAluno;
	private String[] nomeColuna = {"NOME", "EMAIL"};
	
	private final int COLUNA_NOME = 0;
    private final int COLUNA_EMAIL = 1;
    
    public ListarAlunosSetTableModel(Set<Pessoa> alunos) {
    	listaAluno = new ArrayList<>();
    	this.alunosList(alunos);
    	
	}
    
    public void alunosList(Set<Pessoa> p) {
    	for(Pessoa pessoa : p) {
    		listaAluno.add(pessoa);
    	}
    }

	@Override
	public int getRowCount() {
		return listaAluno.size();
	}

	@Override
	public int getColumnCount() {
		return nomeColuna.length;
	}
	
	@Override
	public String getColumnName(int index) {
		return nomeColuna[index];
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		Pessoa aluno = this.listaAluno.get(linha);
		switch (coluna) {
				case COLUNA_NOME:
					return aluno.getNome();
				case COLUNA_EMAIL:
					return aluno.getEmail();
	            }
		return null;
	}

}
