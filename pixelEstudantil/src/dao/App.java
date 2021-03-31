package dao;

import interfaces.PessoaRepositorio;
import model.Aluno;
import model.Pessoa;

public class App {

	public static void main(String[] args) {
		PessoaRepositorio pessoaRepositorio = new PessoaDAO();
        
        Pessoa pessoa1 = new Aluno("Raimundo", "hilaryoncx@gmail.com");
        Pessoa pessoa2 = new Aluno("nesuku", "nesuku@gmail.com");
        pessoaRepositorio.gravarPessoa(pessoa1);
        pessoaRepositorio.gravarPessoa(pessoa2);
        
        Pessoa pessoaRecuperada = pessoaRepositorio.buscar("AL0");
        
        if(pessoaRecuperada != null)
            System.out.println(pessoaRecuperada);
        else
            System.out.println("Pesssoa não encontrada");
	}
}
