package controller;

import javax.swing.JComboBox;

import dao.PessoaDAO;
import model.Disciplina;

public class DisciplinaController {
	
	PessoaDAO pessoaDAO = new PessoaDAO();
	
	public JComboBox<Object> popularComboBox(JComboBox<Object> cbDisciplina) {
        for(Disciplina disc : pessoaDAO.buscarTodasDisciplinas()) {
            cbDisciplina.addItem(disc);
        }
        return cbDisciplina;
	}
	
	public Disciplina getDisciplinaSelecionada(JComboBox<Object> cbDisciplina) {
		Disciplina disciplinaSelecionada = (Disciplina)cbDisciplina.getSelectedItem();
		return disciplinaSelecionada;
	}
	
	public boolean criarDisciplina(String nome, String codigo) {
		if(nome != null && nome.length() > 0 && codigo != null && codigo.length() > 0) {
			Integer cod = Integer.parseInt(codigo);
			Disciplina dis = new Disciplina(nome, cod);
			pessoaDAO.gravarDiciplina(dis);
			return true;
		}
		return false;
	}
}
