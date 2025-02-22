package io.github.gabrielhenriquehe.transacao_api.business.controllers.dto;

import io.github.gabrielhenriquehe.transacao_api.business.services.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @PostMapping()
    public ResponseEntity<Void> processarTransacao(@RequestBody TransacaoRequestDTO data) {

        this.transacaoService.processarTransacao(data);

        return ResponseEntity.status(HttpStatus.CREATED.value()).build();
    }
}
