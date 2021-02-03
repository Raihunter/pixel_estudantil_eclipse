package pessoas;

import endereco.Endereco;

import java.util.List;

/**
 *
 * @author Raimundo
 */
public abstract class Pessoa {
    
    private String nome;
    private String sobreNome;
    private String email;
    private String password;
    Endereco endereco;
    
    public Pessoa(String nome, String email, String senha){
        this.nome = nome;
        this.email = email;
        this.setPassWord(senha);
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
    
    public String getPassword(){
        return this.password;
    }

    public String imprimirPessoa() {
        StringBuilder sb = new StringBuilder();
        sb.append(", nome = ").append(nome);
        sb.append(", email = ").append(email);
        return sb.toString();
    }

}
