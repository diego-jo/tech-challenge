package br.com.fiap.techchallenge.lanchonete.core.port.in;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.pedido.PedidoOut;

public interface BuscarPedidoPorIdInputPort {
    PedidoOut buscarPorId(Long id);
}