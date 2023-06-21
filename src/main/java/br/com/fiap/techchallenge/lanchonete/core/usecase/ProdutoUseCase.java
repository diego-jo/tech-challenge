package br.com.fiap.techchallenge.lanchonete.core.usecase;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.ProdutoIn;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.ProdutoOut;
import br.com.fiap.techchallenge.lanchonete.core.port.in.CriaProdutoInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.SalvaProdutoOutputPort;

public class ProdutoUseCase implements CriaProdutoInputPort {

    SalvaProdutoOutputPort salvaProdutoOutputPort;

    public ProdutoUseCase(SalvaProdutoOutputPort salvaProdutoOutputPort) {
        this.salvaProdutoOutputPort = salvaProdutoOutputPort;
    }

    @Override
    public ProdutoOut criar(ProdutoIn produtoIn) {
        return salvaProdutoOutputPort.salvar(produtoIn);
    }
}