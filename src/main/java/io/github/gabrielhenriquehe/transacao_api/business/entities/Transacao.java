package io.github.gabrielhenriquehe.transacao_api.business.entities;

import java.time.OffsetDateTime;

public record Transacao(
        Double valor,
        OffsetDateTime dataHora
) {
}
