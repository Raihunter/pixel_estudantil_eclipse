package tablelModel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Aluno;

@SuppressWarnings("serial")
public class AlunosMatriculadosTableModel extends AbstractTableModel {
	
	private List<Aluno> alunos;
	
	private String[] nomeColunas = {"DISCIPLINA", "ID ALUNO", "NOME", "EMAIL"};
	
	private final int COLUNA_DISCIPLINA = 0;
    private final int COLUNA_ID_ALUNO = 1;
    private final int COLUNA_NOME = 2;
    private final int COLUNA_EMAIL = 3;
    
    public AlunosMatriculadosTableModel(List<Aluno> alunos){
    	this.alunos = alunos;
    }

	@Override
	public int getRowCount() {
		return alunos.size();
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
		Aluno aluno = this.alunos.get(linha);
		switch (coluna) {
				case COLUNA_DISCIPLINA:
					return aluno.getDisciplina().getNome();
	            case COLUNA_ID_ALUNO:
	            	return aluno.getID();
	            case COLUNA_NOME:
	            	return aluno.getNome();
	            case COLUNA_EMAIL:
	            	return aluno.getEmail();
	            }
		return null;
	}

}
