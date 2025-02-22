package io.github.gabrielhenriquehe.transacao_api.business.controllers.dto;

public record EstatisticasDTO(
        Long count,
        Double sum,
        Double avg,
        Double min,
        Double max
) {
}
