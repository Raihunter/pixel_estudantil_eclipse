package telas;

import java.util.List;

import pessoas.Aluno;
import pessoas.Pessoa;
import sistema.Sistema;

import javax.swing.table.AbstractTableModel;

public class PessoasTableModel extends AbstractTableModel{
    
    private List<Pessoa> pessoas;
    
    private String[] nomeColunas = {"ID","NOME", "EMAIL"};
	
    private final int COLUNA_ID = 0;
    private final int COLUNA_NOME = 1;
    private final int COLUNA_EMAIL = 2;
    
    public PessoasTableModel(List<Pessoa> pessoas){
        this.pessoas = pessoas;
    }

    @Override
    public int getRowCount() {
        return pessoas.size();
        
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
        Pessoa pessoa = this.pessoas.get(rowIndex);
	switch (columnIndex) {
			case COLUNA_ID:
				return pessoa.getID();
            case COLUNA_NOME:
                return pessoa.getNome();
            case COLUNA_EMAIL:
                return pessoa.getEmail();
            }
	return null;
    }
    
}
