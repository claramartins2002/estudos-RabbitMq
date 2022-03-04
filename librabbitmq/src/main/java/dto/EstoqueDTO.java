

package dto;

import java.io.Serializable;

public class EstoqueDTO implements Serializable {
    public String codigoproduto;
    public int quantidade;

    public EstoqueDTO() {
    }

    public EstoqueDTO(String codigoproduto, int quantidade) {
        this.codigoproduto = codigoproduto;
        this.quantidade = quantidade;
    }

}