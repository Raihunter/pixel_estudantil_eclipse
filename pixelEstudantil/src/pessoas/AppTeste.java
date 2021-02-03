package pessoas;
import disciplinas.Disciplina;
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
        sistema.setNomeDoSistema("Pixel Estudantil");
        sistema.setCnpj("123456");

        Pessoa aluno1 = new Aluno("João", "joao@email.com", "Joao01:");
        Pessoa aluno2 = new Aluno("Maria", "maria@email.com", "Mari01@");

        //Instânciando objeto endereço para os alunos
        Endereco endAluno1 = new Endereco();
        endAluno1.setRua("Rua dois");
        endAluno1.setNumero(800);
        
        Endereco endAluno2 = new Endereco();
        endAluno2.setRua("Rua três");
        endAluno2.setNumero(100);
        
        aluno1.setEndereco(endAluno1);
        aluno2.setEndereco(endAluno2);

        sistema.setPessoas(aluno1);
        sistema.setPessoas(aluno2);

        Pessoa secretaria = new Secretaria("Carla", "carla@email.com", "12Ca.@");

        sistema.setPessoas(secretaria);

        sistema.imprimirPessoas();

        //- Obs: Para utilizar o método da classe secretaria precisamos fazer um casting
        Secretaria sec = (Secretaria)secretaria;
        sistema.setDisciplina(sec.criarDisciplina("Matematica", 01));
        sistema.setDisciplina(sec.criarDisciplina("Portugues", 01));

        sistema.imprimirDisciplinas();

//Testando a interface Autenticavel

        Autenticavel valida = (Autenticavel)secretaria;
        System.out.println(valida.autentica("12Ca.@"));
    }
}
