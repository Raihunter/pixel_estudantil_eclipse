package interfaces;

import disciplinas.Disciplina;

/**
 *
 * @author raimundo
 */
public interface Autenticavel {
    
    public abstract boolean autentica(String senha);
    
    public abstract Disciplina criarDisciplina(String nome, int codigo);
}
