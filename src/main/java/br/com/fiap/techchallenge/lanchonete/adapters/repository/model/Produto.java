package br.com.fiap.techchallenge.lanchonete.adapters.repository.model;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.Categoria;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    private Double preco;

    private String descricao;

    private byte[] imagem;

    public Produto(String nome, Categoria categoria, Double preco, String descricao, byte[] imagem) {
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.descricao = descricao;
        this.imagem = imagem;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Double getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public byte[] getImagem() {
        return imagem;
    }
}
