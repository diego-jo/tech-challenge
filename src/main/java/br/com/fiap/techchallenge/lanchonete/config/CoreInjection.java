package br.com.fiap.techchallenge.lanchonete.config;

import br.com.fiap.techchallenge.lanchonete.core.port.in.CriaImagemProdutoInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.in.CriaProdutoInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.SalvaImagemProdutoOutputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.SalvaProdutoOutputPort;
import br.com.fiap.techchallenge.lanchonete.core.usecase.CriaImagemProdutoUseCase;
import br.com.fiap.techchallenge.lanchonete.core.usecase.CriaProdutoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoreInjection {

    @Bean
    CriaProdutoInputPort criarProduto(SalvaProdutoOutputPort salvaProdutoOutputPort) {
        return new CriaProdutoUseCase(salvaProdutoOutputPort);
    }

    @Bean
    CriaImagemProdutoInputPort criarImagemProduto(SalvaImagemProdutoOutputPort salvaImagemProdutoOutputPort) {
        return new CriaImagemProdutoUseCase(salvaImagemProdutoOutputPort);
    }

}
