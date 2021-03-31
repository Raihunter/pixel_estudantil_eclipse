package tablelModel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Aluno;

@SuppressWarnings("serial")
public class AlunosTableModel extends AbstractTableModel{
    
    private List<Aluno> alunos;
    
    private String[] nomeColunas = {"ID","NOME", "PONTUAÇÂO"};
	
    private final int COLUNA_ID = 0;
    private final int COLUNA_NOME = 1;
    private final int COLUNA_PONTUACAO = 2;
    
    public AlunosTableModel(List<Aluno> alunos){
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
    public Object getValueAt(int rowIndex, int columnIndex) {
        Aluno aluno = this.alunos.get(rowIndex);
	switch (columnIndex) {
			case COLUNA_ID:
				return aluno.getID();
            case COLUNA_NOME:
                return aluno.getNome();
            case COLUNA_PONTUACAO:
                return aluno.getPontuacao();
            }
	return null;
    }
    
    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
    	switch (coluna) {
        case COLUNA_PONTUACAO:
            alunos.get(linha).setPontuacao(Float.parseFloat((String)valor));
        }
    	this.fireTableRowsInserted(linha, linha);
    }
    
    
}
