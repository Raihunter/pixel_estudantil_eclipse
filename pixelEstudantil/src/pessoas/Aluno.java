package pessoas;

import java.util.ArrayList;
import java.util.List;

import disciplinas.Disciplina;

/**
 *
 * @author Raimundo
 */
public class Aluno extends Pessoa{
    
    private static int gerarCodigo;
    private int codigo;
    private String id = "AL";
    private float pontuacao;
    private Disciplina disciplina = null;
    private List<Disciplina> disciplinas;
    
    public Aluno(String nome, String email, String senha){
        super(nome, email, senha);
        this.codigo = gerarCodigo++;//com isso o id aluno sera automatizado para todo aluno criado.
        this.id += this.codigo;
        super.setID(id);
        this.disciplinas = new ArrayList<>();
    }
    public Aluno(String nome, String email){
        super(nome, email);
        this.codigo = gerarCodigo++;//com isso o id aluno sera automatizado para todo aluno criado.
        this.id += this.codigo;
        super.setID(id);
    }
    
    public String getIdAluno(){
        return this.id;
    }
    
    public void setPontuacao(float p) {
    	this.pontuacao = p;
    }
    
    public float getPontuacao() {
    	return this.pontuacao;
    }
    
    public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	public void setDisciplina(Disciplina d) {
		this.disciplina = d;
	}
	
	public Disciplina getDisciplina() {
		return disciplina;
	}
	
	@Override
    public String toString(){
        return  "Matricula = "+this.id+
                super.imprimirPessoa()+
                ", Pontuação: "+this.pontuacao;
    }

}
