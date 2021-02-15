package pessoas;

/**
 *
 * @author Raimundo
 */
public class Aluno extends Pessoa{
    
    private static int gerarCodigo;
    private int codigo;
    private String id = "AL";
    private float pontuacao;
    
    public Aluno(String nome, String email, String senha){
        super(nome, email, senha);
        this.codigo = gerarCodigo++;//com isso o id aluno sera automatizado para todo aluno criado.
        this.id += this.codigo;
    }
    public Aluno(String nome, String email){
        super(nome, email);
        this.codigo = gerarCodigo++;//com isso o id aluno sera automatizado para todo aluno criado.
        this.id += this.codigo;
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
    
    @Override
    public String toString(){
        return  "Matricula = "+this.id+
                super.imprimirPessoa()+
                ", Pontuação: "+this.pontuacao;
    }

}
