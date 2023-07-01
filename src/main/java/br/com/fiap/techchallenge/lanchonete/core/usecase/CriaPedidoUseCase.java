package br.com.fiap.techchallenge.lanchonete.core.usecase;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.CriaPedido;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.CriaItemPedido;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.enums.StatusPedidoEnum;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.interfaces.CriaPedidoIn;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.interfaces.PedidoIn;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.interfaces.PedidoOut;
import br.com.fiap.techchallenge.lanchonete.core.port.in.CriaPedidoInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.BuscaProdutoPorIdOutputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.CriaPedidoOutputPort;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CriaPedidoUseCase implements CriaPedidoInputPort {

    private final CriaPedidoOutputPort criaPedidoOutputPort;
    private final BuscaProdutoPorIdOutputPort buscaProdutoPorIdOutputPort;

    public CriaPedidoUseCase(CriaPedidoOutputPort criaPedidoOutputPort, BuscaProdutoPorIdOutputPort buscaProdutoPorIdOutputPort) {
        this.criaPedidoOutputPort = criaPedidoOutputPort;
        this.buscaProdutoPorIdOutputPort = buscaProdutoPorIdOutputPort;
    }

    @Override
    public PedidoOut criar(CriaPedidoIn pedidoIn) {
        var pedido = new CriaPedido();
        pedido.setItens(montaListaCriaItemPedido(pedidoIn));
        pedido.setStatus(StatusPedidoEnum.PENDENTE_DE_PAGAMENTO);
        pedido.setValorTotal(calculaValorTotalPedido(pedido.getItens()));
        return criaPedidoOutputPort.criar(pedido);
    }

    private List<CriaItemPedido> montaListaCriaItemPedido(PedidoIn pedidoIn){
        var listaCriaItemPedido = new ArrayList<CriaItemPedido>();
        pedidoIn.getItens().forEach(itemPedidoIn -> {
            var produtoOut = buscaProdutoPorIdOutputPort.buscarPorId(itemPedidoIn.getPedidoId());
            listaCriaItemPedido.add(
                    new CriaItemPedido(produtoOut.getId(), itemPedidoIn.getQuantidade(), produtoOut.getPreco())
            );
        });
        return listaCriaItemPedido;
    }

    private BigDecimal calculaValorTotalPedido(List<CriaItemPedido> listaCriaItemPedido){
        return listaCriaItemPedido.stream()
                .map(criaItemPedido -> BigDecimal.valueOf(criaItemPedido.getQuantidade()).multiply(criaItemPedido.getValorUnitario()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

    }
}