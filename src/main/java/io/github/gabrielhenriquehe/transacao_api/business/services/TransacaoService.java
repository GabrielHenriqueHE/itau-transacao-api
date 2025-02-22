package io.github.gabrielhenriquehe.transacao_api.business.services;

import io.github.gabrielhenriquehe.transacao_api.business.controllers.dto.TransacaoRequestDTO;
import io.github.gabrielhenriquehe.transacao_api.business.entities.Transacao;
import io.github.gabrielhenriquehe.transacao_api.infrastructure.exceptions.UnprocessableEntityException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class TransacaoService {

    private final List<Transacao> transacoes = new ArrayList<>();

    public void processarTransacao(TransacaoRequestDTO data) {
        if (data.valor() < 0) {
            log.error("Valor inválido para transação. Não deve ser um valor negativo.");
            throw new UnprocessableEntityException(null);
        }

        if (data.dataHora().isAfter(OffsetDateTime.now())) {
            log.error("Data e hora inválida. Não deve ser uma data futura.");
            throw new UnprocessableEntityException(null);
        }

        log.info("Iniciando processamento da transação.");
        Transacao transacao = new Transacao(data.valor(), data.dataHora());
        this.transacoes.add(transacao);
        log.info("Processamento da transação finalizado.");
    }

    public void limparTransacoes() {
        log.info("Iniciando procedimento para exclusão das transações.");
        this.transacoes.clear();
        log.info("Procedimento de exclusão de transações finalizado.");
    }

    public List<Transacao> obterTransacoes(Long intervalo) {
        log.info("Obtendo transações.");
        List<Transacao> transacoesFiltradas = this.transacoes
                .stream()
                .filter(transacao -> transacao.dataHora()
                        .isAfter(OffsetDateTime.now()
                                .withOffsetSameLocal(ZoneOffset.of("-03:00"))
                                .minusSeconds(intervalo))).toList();
        log.info("Transações obtidas com sucesso.");

        return transacoesFiltradas;
    }
}
