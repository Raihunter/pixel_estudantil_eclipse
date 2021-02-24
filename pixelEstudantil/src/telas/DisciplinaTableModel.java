package telas;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import disciplinas.Disciplina;
import pessoas.Aluno;
import pessoas.Pessoa;
import dao.PessoaDAO;

public class DisciplinaTableModel extends AbstractTableModel {
	
	private List<Disciplina> disciplinas;
	
	private String[] nomeColunas = {"CÓDIGO","NOME"};
	
	private final int COLUNA_CODIGO = 0;
    private final int COLUNA_NOME = 1;
	
	public DisciplinaTableModel(List<Disciplina> disciplina) {
		this.disciplinas = disciplina;
	}

	@Override
	public int getRowCount() {
		return disciplinas.size();
	}

	@Override
	public int getColumnCount() {
		return nomeColunas.length;
	}
	
	@Override
	public String getColumnName(int index) {
		return nomeColunas[index];
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		switch (coluna) {
		case COLUNA_CODIGO:
			return disciplinas.get(linha).getCodigo();
		case COLUNA_NOME:
			return disciplinas.get(linha).getNome();
		}
		return null;
	}

}
