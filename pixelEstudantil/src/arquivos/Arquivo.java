package arquivos;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Arquivo {
	
	//método para escrever no arquivo
	public void gravarArquivo(String cadastro) {
		try {
			FileOutputStream arquivo = new FileOutputStream("/home/raimundo/workspace/pixelEstudantil/src/arquivos/Logs.txt",true);
			PrintWriter pr = new PrintWriter(arquivo);
			
			pr.println(cadastro);
			pr.flush();
			pr.close();
			arquivo.close();
			
		}catch(Exception e) {
			System.out.println("Erro ao escrever o arquivo.");
		}
	}
	
	//método para ler o arquivo
	public void lerArquivo() {
		try {
			
			FileInputStream arquivo = new FileInputStream("/home/raimundo/workspace/pixelEstudantil/src/arquivos/Logs.txt");
			InputStreamReader input = new InputStreamReader(arquivo);
			BufferedReader br = new BufferedReader(input);
			
			String linha;
			
			do {
				linha = br.readLine();
				if(linha != null) {
					System.out.println("Lindo = "+linha);
					
					//Lendo as linha com palavras separadas pelo delimitador
					String[] palavras = linha.split(";");
					System.out.println("############--NOVA--LINHA--##############");
					for(int i=0; i<palavras.length; i++ ) {
						System.out.println("ID - "+i+", Palavra - "+palavras[i]);
					}
				}
			} while (linha != null);
			br.close();
		}catch(Exception e) {
			System.out.println("Erro ao ler o arquivo");
		}
	}
	
	//método para validar o acesso
	public boolean validarLogin(String usuario, String senha) {
		boolean login = false;
		try {
			FileInputStream arquivo = new FileInputStream("/home/raimundo/workspace/pixelEstudantil/src/arquivos/Logs.txt");
			InputStreamReader input = new InputStreamReader(arquivo);
			BufferedReader br = new BufferedReader(input);
			
			String linha;
			do {
				linha = br.readLine();
				if(linha != null) {
					String[] palavrasNaLinha = linha.split(";");
					for(int i=0; i<palavrasNaLinha.length; i++) {
						if(palavrasNaLinha[0].equals(usuario) && palavrasNaLinha[2].equals(senha)) {
							login = true;
						}
					}
				}
			} while (linha != null);
			//br.close();
		}catch(Exception e) {
			System.out.println("Usuário ou senha inválida");
		}
		return login;
	}
		
}
