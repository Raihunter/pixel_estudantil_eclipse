package model;

/**
 *
 * @author Raimundo
 */
public class Endereco {
    
    private int codigo;
    private String cep;
    private String rua;
    private int numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    
    //Preciso de construtor? Provavelmente sim, para uma FK de endereço. E a PK pode ser o CEP
    public Endereco(){
        this.codigo++;
    }
    
    public int getCodigo(){
        return this.codigo;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    //Precisso de um toString? Talvez não, porém posso fazer uma busca completa
    //dps, como algo específico.

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Endereco{codigo = ").append(codigo);
        sb.append(", cep = ").append(cep);
        sb.append(", rua = ").append(rua);
        sb.append(", numero = ").append(numero);
        sb.append(", complemento = ").append(complemento);
        sb.append(", bairro = ").append(bairro);
        sb.append(", cidade = ").append(cidade);
        sb.append(", estado = ").append(estado);
        sb.append('}');
        return sb.toString();
    }
    
}
