package br.com.fiap.techchallenge.lanchonete.core.domain.models;

import java.math.BigDecimal;

public interface ProdutoIn {

    public String getNome();
    public Categoria getCategoria();
    public BigDecimal getPreco();
    public String getDescricao();
    public byte[] getImagem();

}
