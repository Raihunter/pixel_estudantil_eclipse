package controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import dao.PessoaDAO;
import exceptions.PasswordException;
import model.Aluno;
import model.Disciplina;
import model.Pessoa;

public class AlunoController {
	PessoaDAO pessoaDAO = new PessoaDAO();

	public boolean cadastrarAluno(String nome, String email, String senha) {
		boolean sucesso = false;
		if(nome != null && nome.length() > 0 && email != null && email.length() > 0 && senha != null && senha.length() > 0) {
			Pessoa aluno = new Aluno(nome, email);
			try {
				aluno.setAuxPassword(senha);
				pessoaDAO.gravarPessoa(aluno);
				sucesso = true;
			} catch (PasswordException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}
		return sucesso;
	}
	
	public String buscarAlunoMap(String ID) {
		String alunoMap = null;
		Map<String, List<Aluno>> map = new HashMap<>();
		map.put(ID, pessoaDAO.getAlunos());
		
		for(Map.Entry<String, List<Aluno>> entry : map.entrySet()) {
			for(Aluno p : entry.getValue()) {
				if(ID.equals(p.getID()))
					alunoMap = p.toString();
			}
		}
		return alunoMap;
	}
	
	public JTextArea listarMapDetalhe(JTextArea lista) {
		Map<Disciplina, List<Aluno>> map = new HashMap<>();
		for(Disciplina disciplina: pessoaDAO.buscarTodasDisciplinas()) {
			map.put(disciplina, disciplina.getListaDeAlunos());
			for(Map.Entry<Disciplina, List<Aluno>> entry : map.entrySet()) {
				lista.append(entry.getKey().getNome()+"\n\n");
				for(Aluno p : entry.getValue()) {
					lista.append("Matricula: "+p.getID()+" - "+p.getNome()+"\n");
				}
				lista.append("\n");
			}
		}
		return lista;
	}
	
	public JTextArea ordenarPorIdade(JTextArea lista) {
		Collections.sort(pessoaDAO.getAlunos());
		for(Pessoa p: pessoaDAO.getAlunos()) {
			lista.append("Matricula: "+p.getID()+" - "+p.getNome()+" - idade: "+p.getIdade()+"\n");
		}
		return lista;
	}
	
	public JTextArea listarMap(JComboBox<Object> disciplinaComboBox, JTextArea lista) {
		Map<Disciplina, List<Aluno>> map = new HashMap<>();
		Disciplina disciplina = (Disciplina)disciplinaComboBox.getSelectedItem();
		map.put(disciplina, disciplina.getListaDeAlunos());
		lista.setText("");
		for(Map.Entry<Disciplina, List<Aluno>> entry : map.entrySet()) {
			lista.append(entry.getKey().getNome()+"\n\n");
			for(Aluno p : entry.getValue()) {
				lista.append("Matricula: "+p.getID()+" - "+p.getNome()+"\n");
			}
		}
		return lista;
	}
	
}
