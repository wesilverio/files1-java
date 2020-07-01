
package entidades;

public class Produto {
    private String nome;
    private Double precoUnit;
    private Integer quantidade;

    public Produto() {
    }

    public Produto(String nome, Double precoUnit, Integer quantidade) {
        this.nome = nome;
        this.precoUnit = precoUnit;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPrecoUnit() {
        return precoUnit;
    }

    public void setPrecoUnit(Double precoUnit) {
        this.precoUnit = precoUnit;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    
    public double calcularTotal(){
        return precoUnit * quantidade;
    }

}
