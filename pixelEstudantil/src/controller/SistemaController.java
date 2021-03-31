package controller;

import dao.PessoaDAO;
import model.Sistema;

public class SistemaController {

	PessoaDAO pessoaDAO = new PessoaDAO();

	public void acessoRoot() {
		Sistema sis = new Sistema();
		pessoaDAO.gravarPessoa(sis.administrador());
	}
}
