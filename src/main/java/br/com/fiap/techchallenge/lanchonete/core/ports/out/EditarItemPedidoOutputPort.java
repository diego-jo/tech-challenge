package br.com.fiap.techchallenge.lanchonete.core.ports.out;

import br.com.fiap.techchallenge.lanchonete.core.entities.CriaItemPedido;
import br.com.fiap.techchallenge.lanchonete.core.entities.ItemPedidoOut;

public interface EditarItemPedidoOutputPort {
    ItemPedidoOut editarItem(CriaItemPedido itemPedidoIn);
}