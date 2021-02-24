package algunsTestes;

import java.util.HashSet;
import java.util.Set;

import disciplinas.Disciplina;
import pessoas.Aluno;
import pessoas.Pessoa;
import sistema.Sistema;

public class conjunto {
	
	public static void main(String[] args) {
		
		Pessoa aluno1 = new Aluno("João", "joao123@email.com", "Jo12.@");
		Pessoa aluno2 = new Aluno("Maria", "maria123@email.com", "Ma12.@");
		Pessoa aluno3 = new Aluno("João", "joao123@email.com", "Jo212.@");
		
		Disciplina matematica = new Disciplina("Matemática", 1);
		Disciplina portugues = new Disciplina("Português", 1);
		
		matematica.setAluno((Aluno)aluno1);
		portugues.setAluno((Aluno)aluno2);
		matematica.setAluno((Aluno)aluno3);
		
		Sistema sis = new Sistema();
		sis.setPessoas(aluno1);
		sis.setPessoas(aluno2);
		sis.setPessoas(aluno3);
		
		System.out.println("\n---------Todos os alunos criados------------\n");
		
		sis.imprimirAlunos();
		
		System.out.println("\n---------Todos os alunos matriculados em matemática------------\n");

		for(Aluno a : matematica.getListaDeAlunos()) {
			System.out.println(a);
		}
		
		System.out.println("\n---------Todos os alunos matriculados em matemática após uso do Set------------\n");
		
		Set<Pessoa> aluno = new HashSet<>();
        aluno.addAll(matematica.getListaDeAlunos());
        for(Pessoa al : aluno) {
        	System.out.println(al);
        }
        System.out.println("\n");
        System.out.println(matematica.toString());
        System.out.println(portugues.toString());
	}

}
