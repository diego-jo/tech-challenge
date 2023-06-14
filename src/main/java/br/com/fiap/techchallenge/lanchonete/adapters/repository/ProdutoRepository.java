package br.com.fiap.techchallenge.lanchonete.adapters.repository;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.jpa.ProdutoJpaRepository;
import br.com.fiap.techchallenge.lanchonete.adapters.repository.mapper.ProdutoMapper;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.ProdutoRequest;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.ProdutoResponse;
import br.com.fiap.techchallenge.lanchonete.core.port.out.SalvaProdutoOutputPort;
import org.springframework.stereotype.Repository;

@Repository
public class ProdutoRepository implements SalvaProdutoOutputPort {

    ProdutoJpaRepository produtoJpaRepository;
    ProdutoMapper produtoMapper;

    public ProdutoRepository(ProdutoJpaRepository produtoJpaRepository, ProdutoMapper produtoMapper) {
        this.produtoJpaRepository = produtoJpaRepository;
        this.produtoMapper = produtoMapper;
    }

    @Override
    public ProdutoResponse salvar(ProdutoRequest produtoRequest) {
        var produto = produtoMapper.toProduto(produtoRequest);
        var produtoSalvo = produtoJpaRepository.save(produto);

        return produtoMapper.toProdutoResponse(produtoSalvo);
    }
}
