package pessoas;
import java.util.Collections;
import java.util.Comparator;
import interfaces.Autenticavel;
import endereco.Endereco;
import sistema.Sistema;
/**
 *
 * @author Raimundo
 */
public class AppTeste {
//Classe teste temporaria, excluir depois
    public static void main(String[] args) {

        Sistema sistema = new Sistema();
//        sistema.setNomeDoSistema("Pixel Estudantil");
//        sistema.setCnpj("123456");
        
        System.out.println("\n############ Confirmações da criação das senhas ############\n");

        Pessoa aluno1 = new Aluno("João", "joao@email.com", "Joao01:");
        Pessoa aluno2 = new Aluno("João", "joao@email.com", "Mari01@");
        Pessoa aluno3 = new Aluno("Maria", "maria@email.com", "Mari01@");
        Pessoa professor = new Professor("Matheus", "matheus@email.com", "mat2021-M");
        Pessoa secretaria = new Secretaria("Carla", "carla@email.com", "12Ca.@");
        
        aluno1.setIdade(20);
        aluno2.setIdade(18);
        aluno3.setIdade(28);
        professor.setIdade(30);
        secretaria.setIdade(25);
        
//Instânciando objeto endereço para os alunos
        Endereco endAluno1 = new Endereco();
        endAluno1.setRua("Rua dois");
        endAluno1.setNumero(800);
//Criando endereço e setando no aluno
        Endereco endAluno2 = new Endereco();
        endAluno2.setRua("Rua três");
        endAluno2.setNumero(100);
        
        aluno1.setEndereco(endAluno1);
        aluno2.setEndereco(endAluno2);
        
        Aluno a = (Aluno)aluno1;
        a.setPontuacao(50);
        Aluno b = (Aluno)aluno2;
        b.setPontuacao(80);
        Aluno c = (Aluno)aluno3;
        c.setPontuacao(100);
        
//Adicionando o pessoas na lista do sistema
        sistema.setPessoas(aluno2);
        sistema.setPessoas(professor);
        sistema.setPessoas(secretaria);
        sistema.setPessoas(aluno1);
        sistema.setPessoas(aluno3);

//Imprimindo a lista        
        
        System.out.println("\n#################### Impressão da lista de pessoas ###################\n");
        
        sistema.imprimirPessoas();
        
//Lista de forma ordenada com o compareTo utilizando a idade na classe que implementa a interface Comparable
        
        Collections.sort(sistema.getListaPessoa());

        System.out.println("\n######## Ordenação da lista de pessoas por idade após utilizar o compareTo ########\n");
        
        sistema.imprimirPessoas();
        
//Ordenação utilizando  o Comparator        
        
        Collections.sort(sistema.getListaPessoa(), new Comparator<Pessoa>() {
        	@Override
        	public int compare(Pessoa a, Pessoa b) {
        		if(a instanceof Aluno) {
        			return -1;
        		} else {
        			return 1;
        		}
        	}
        });

        System.out.println("\n######## Ordenação da lista de pessoas após utilizar o Comparator(Alunos primeiro) ########\n");
        
        sistema.imprimirPessoas();

//Testando a interface Autenticavel
        
        System.out.println("\n#################### Teste da interface Autenticavel ###################\n");

        Autenticavel valida = (Autenticavel)secretaria;
        System.out.println(valida.autentica("12Ca.@"));
        
//Listando somente alunos
        System.out.println("\n####################### Imprimindo todos os alunos ####################\n");
        sistema.imprimirAlunos();
        
        System.out.println("\n#### Imprimindo os alunos classificados por pontuação com comparator - maior para o menor #####\n");
        sistema.imprimirAlunosClassificadosPorPontuacao();

    }
}
