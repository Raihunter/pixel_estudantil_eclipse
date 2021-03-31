package model;

public class Sistema {
	
	private static String nome = "admin";
	private static String email = "pixelEstudantil@email.com";
	private static String senha = "Admin.123";

	Pessoa admin = new Secretaria(Sistema.nome, Sistema.email, Sistema.senha);
	
	public Pessoa administrador() {
		return admin;
	}
	
	public String getNome() {
		return Sistema.nome;
	}

	public String getEmail() {
		return Sistema.email;
	}
	
}
