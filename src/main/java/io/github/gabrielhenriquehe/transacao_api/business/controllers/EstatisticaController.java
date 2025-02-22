package io.github.gabrielhenriquehe.transacao_api.business.controllers;

import io.github.gabrielhenriquehe.transacao_api.business.controllers.dto.EstatisticasDTO;
import io.github.gabrielhenriquehe.transacao_api.business.services.EstatisticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {

    @Autowired
    private EstatisticaService estatisticaService;

    @GetMapping()
    public ResponseEntity<EstatisticasDTO> processarEstatisticas (
        @RequestParam(defaultValue = "60", required = false) Long intervalo
    ) {

        EstatisticasDTO estatisticas = this.estatisticaService.processarEstatisticas(intervalo);

        return ResponseEntity.status(HttpStatus.OK.value()).body(estatisticas);
    }
}
