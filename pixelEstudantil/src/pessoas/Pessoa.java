package pessoas;

import endereco.Endereco;
import exceptions.PasswordException;

/**
 *
 * @author Raimundo
 */
public abstract class Pessoa implements Comparable<Pessoa> {
    
    private String nome;
    private String sobreNome;
    private String email;
    private String password;
    private int idade;
    Endereco endereco;
    
    public Pessoa(String nome, String email, String senha){
        this.nome = nome;
        this.email = email;
        this.setPassWord(senha);
    }
    public Pessoa(String nome, String email){
        this.nome = nome;
        this.email = email;
    }
   
    //Metódo para autenticar a senha criada
    private static boolean autenticaSenha(String senha){
        if (senha.length() < 6){
            return false;
        }
        boolean achouNumero = false;
        boolean achouMaiuscula = false;
        boolean achouMinuscula = false;
        boolean achouSimbolo = false;
        for (char c : senha.toCharArray()){
            if (c >= '0' && c <= '9'){
                achouNumero = true;
            } else if (c >= 'A' && c <= 'Z'){
                achouMaiuscula = true;
            } else if (c >= 'a' && c <= 'z'){
                achouMinuscula = true;
            } else {
                achouSimbolo = true;
            }
        }
        return achouNumero && achouMaiuscula && achouMinuscula && achouSimbolo;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getSobreNome() {
        return sobreNome;
    }
    
    public void setSobreNome(String sobreNome){
        this.sobreNome = sobreNome;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public int getIdade() {
    	return this.idade;
    }
    
    public void setIdade(int idade) {
    	this.idade = idade;
    }
    
    public String getEndereco(){
       return endereco.toString();
    }

    public void setEndereco(Endereco endereco){
        this.endereco = endereco;
    }
    
    public void setPassWord(String senha){
        if (autenticaSenha(senha) == true){
            System.out.println("Senha criada com sucesso");
            this.password = senha;
        } else {
            System.out.println("Criação da senha inválida");
        }
    }
    //Teste de outro metodo setPassword
    public void setAuxPassword(String senha) throws PasswordException {
    	if(autenticaSenha(senha) == false)
    		throw new PasswordException();
    	this.password = senha;
    }
    
    public String getPassword(){
        return this.password;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	public String imprimirPessoa() {
        StringBuilder sb = new StringBuilder();
        sb.append(", nome = ").append(nome);
        sb.append(", email = ").append(email);
        sb.append(", idade = ").append(idade);
        return sb.toString();
    }
    
    @Override
    public int compareTo(Pessoa p) {
    	if (idade > p.getIdade()) {
    		return 1;
    	} else {
    		return -1;
    	}
    }

}
