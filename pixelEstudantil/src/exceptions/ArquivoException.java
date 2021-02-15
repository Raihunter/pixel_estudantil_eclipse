package exceptions;

public class ArquivoException extends Exception {
	
	public ArquivoException () {
		super("Arquivo não encontrado!");
	}
	
	public ArquivoException(String msg) {
		super(msg);
	}

}
