package dto;

import java.io.Serializable;

public class precoDTO implements Serializable {
    public String codigoproduto;
    public double preco;

    public precoDTO() {
    }

    public precoDTO(String codigoproduto, double preco) {
        this.codigoproduto = codigoproduto;
        this.preco = preco;
    }
}
