package br.com.fiap.techchallenge.lanchonete.core.port.in;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.pedido.PedidoOut;

import java.util.List;

public interface BuscaTodosPedidosInputPort {
    List<PedidoOut> buscarTodos();
}