package exceptions;

@SuppressWarnings("serial")
public class PasswordException extends Exception {
	public PasswordException() {
		super("Estrutura da senha incorreta!");
	}
}
