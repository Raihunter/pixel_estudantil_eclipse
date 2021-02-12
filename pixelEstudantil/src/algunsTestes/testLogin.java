package algunsTestes;

import arquivos.Arquivo;

public class testLogin {

	public static void main(String[] args) {

		String usr = "maria";
		String pw = "456";
		
		Arquivo arq = new Arquivo();
		
		System.out.println(arq.validarLogin(usr, pw));
		
	}
	
}
