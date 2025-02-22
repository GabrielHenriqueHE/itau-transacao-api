package io.github.gabrielhenriquehe.transacao_api.business.controllers.dto;

import lombok.NonNull;

import java.time.OffsetDateTime;

public record TransacaoRequestDTO(
        @NonNull Double valor,
        @NonNull OffsetDateTime dataHora
) {
}
