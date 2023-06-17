package br.com.fiap.techchallenge.lanchonete.adapters.repository.mapper;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.model.Produto;
import br.com.fiap.techchallenge.lanchonete.adapters.web.ProdutoResponse;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.ProdutoIn;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.ProdutoOut;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {

    public Produto toProduto(ProdutoIn produtoIn) {
        return new Produto(produtoIn.getNome(), produtoIn.getCategoria(), produtoIn.getPreco(),
                produtoIn.getDescricao(), produtoIn.getImagem());
    }

    public ProdutoOut toProdutoResponse(Produto produto) {
        return new ProdutoResponse(produto.getId(), produto.getNome(), produto.getCategoria(), produto.getPreco(),
                produto.getDescricao(), produto.getImagem()) {
        };
    }

}
