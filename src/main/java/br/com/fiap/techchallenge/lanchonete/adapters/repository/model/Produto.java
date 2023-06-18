package br.com.fiap.techchallenge.lanchonete.adapters.repository.model;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.Categoria;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    private BigDecimal preco;

    private String descricao;

    @Lob
    private byte[] imagem;

    public Produto() {
    }

    public Produto(String nome, Categoria categoria, BigDecimal preco, String descricao) {
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }
}