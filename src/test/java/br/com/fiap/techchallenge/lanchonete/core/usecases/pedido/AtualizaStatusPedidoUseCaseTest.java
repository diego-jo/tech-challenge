package br.com.fiap.techchallenge.lanchonete.core.usecases.pedido;

import br.com.fiap.techchallenge.lanchonete.core.domain.entities.enums.StatusPedidoEnum;
import br.com.fiap.techchallenge.lanchonete.core.dtos.AtualizaStatusPedidoDTO;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.pedido.AtualizaStatusPedidoInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.pedido.AtualizaStatusPedidoOutputPort;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static br.com.fiap.techchallenge.lanchonete.utils.PedidoHelper.getAtualizaStatusPedidoDTO;
import static br.com.fiap.techchallenge.lanchonete.utils.PedidoHelper.getPedidoDTO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

class AtualizaStatusPedidoUseCaseTest {

    private AtualizaStatusPedidoInputPort atualizaStatusPedidoInputPort;

    @Mock
    AtualizaStatusPedidoOutputPort atualizaStatusPedidoOutputPort;

    AutoCloseable mock;

    @BeforeEach
    void setUp() {
        mock = MockitoAnnotations.openMocks(this);
        atualizaStatusPedidoInputPort = new AtualizaStatusPedidoUseCase(atualizaStatusPedidoOutputPort);
    }

    @AfterEach
    void tearDown() throws Exception {
        mock.close();
    }

    @Nested
    class buscaTodosPedidosPorStatusUseCase {

        @Test
        void buscaTodosPedidosPorStatus() {
            var id = 1L;
            var status = StatusPedidoEnum.RECEBIDO;
            var pedidoDTO = getPedidoDTO();
            AtualizaStatusPedidoDTO atualizaStatusPedidoDTO = getAtualizaStatusPedidoDTO(status);

            when(atualizaStatusPedidoOutputPort.atualizarStatus(anyLong(), any(StatusPedidoEnum.class))).thenReturn(pedidoDTO);

            var pedidoAtualizado = atualizaStatusPedidoInputPort.atualizarStatus(id, atualizaStatusPedidoDTO);

            assertThat(pedidoAtualizado).isNotNull();
            assertThat(pedidoAtualizado.itens()).allSatisfy( item -> {
               assertThat(item.produtoNome()).isEqualTo(pedidoDTO.itens().get(0).produtoNome());
               assertThat(item.produtoDescricao()).isEqualTo(pedidoDTO.itens().get(0).produtoDescricao());
               assertThat(item.valorUnitario()).isEqualTo(pedidoDTO.itens().get(0).valorUnitario());
               assertThat(item.quantidade()).isEqualTo(pedidoDTO.itens().get(0).quantidade());
               assertThat(item.getValorTotal()).isEqualTo(pedidoDTO.itens().get(0).getValorTotal());
            });
            assertThat(pedidoAtualizado.status()).isEqualTo(pedidoDTO.status());
            assertThat(pedidoAtualizado.valorTotal()).isEqualTo(pedidoDTO.valorTotal());
            assertThat(pedidoAtualizado.dataCriacao()).isEqualTo(pedidoDTO.dataCriacao());

            verify(atualizaStatusPedidoOutputPort, times(1)).atualizarStatus(anyLong(), any(StatusPedidoEnum.class));
            verifyNoMoreInteractions(atualizaStatusPedidoOutputPort);
        }
    }

}