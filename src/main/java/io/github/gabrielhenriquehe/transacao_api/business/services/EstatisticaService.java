package io.github.gabrielhenriquehe.transacao_api.business.services;

import io.github.gabrielhenriquehe.transacao_api.business.controllers.dto.EstatisticasDTO;
import io.github.gabrielhenriquehe.transacao_api.business.entities.Transacao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.List;

@Slf4j
@Service
public class EstatisticaService {

    @Autowired
    private TransacaoService transacaoService;

    public EstatisticasDTO processarEstatisticas(Long intervalo) {
        log.info("Iniciando processamento de transações.");
        List<Transacao> transacoes = this.transacaoService.obterTransacoes(intervalo);

        DoubleSummaryStatistics estatisticas = transacoes.stream()
                .mapToDouble(Transacao::valor).summaryStatistics();

        log.info("Processamento de transações finalizado.");
        return new EstatisticasDTO(
                estatisticas.getCount(),
                estatisticas.getSum(),
                estatisticas.getAverage(),
                String.valueOf(estatisticas.getMin()).equals("Infinity") ? 0 : estatisticas.getMin(),
                String.valueOf(estatisticas.getMax()).equals("-Infinity") ? 0 : estatisticas.getMax());
    }
}
