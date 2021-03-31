package controller;

import javax.swing.JOptionPane;

import dao.PessoaDAO;
import exceptions.PasswordException;
import model.Pessoa;
import model.Professor;
import model.Secretaria;

public class ProfessorController {
	
	PessoaDAO pessoaDAO = new PessoaDAO();

	public boolean cadastrarProfessor(String nome, String email, String senha) {
		Pessoa secretaria = pessoaDAO.getPessoaLogada();
		boolean sucesso = false;
		if(secretaria instanceof Secretaria) {
			if(nome != null && nome.length() > 0 && email != null && email.length() > 0 && senha != null && senha.length() > 0) {
				Pessoa professor = new Professor(nome, email);
				try {
					professor.setAuxPassword(senha);
					pessoaDAO.gravarPessoa(professor);
					sucesso = true;
				} catch (PasswordException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			} else {
				JOptionPane.showMessageDialog(null, "Os dados não foram preenchidos corretamente!");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Autorização negada");
		}
		
		return sucesso;
	}
	
}
