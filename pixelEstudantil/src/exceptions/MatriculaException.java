package exceptions;

@SuppressWarnings("serial")
public class MatriculaException extends Exception {

	public MatriculaException() {
		super("Error ao matricular o aluno");
	}
}
