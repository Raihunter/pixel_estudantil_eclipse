package disciplinas;

import java.util.Locale;

/**
 *
 * @author raimundo
 */
public class Disciplina {
    
    private String nome;
    private String codigo;
    private String iniciaisNome;

    public Disciplina(String nome, int codigo) {
        this.nome = nome;
        this.iniciaisNome = nome.substring(0, 3);
        this.codigo = this.iniciaisNome+"-"+codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo.toUpperCase();
    }

    @Override
    public String toString() {
        return "Disciplina - " + "nome = " + nome + ", codigo = " + codigo.toUpperCase();
    }
    
}
