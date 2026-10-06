package com.aquario.monitoramento;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leituras")
@RequiredArgsConstructor
public class LeituraController {

    @Value("${aquario.api-key}")
    private String API_KEY;

    private final LeituraService service;

    @PostMapping
    public ResponseEntity<Void> registrar(
            @RequestBody LeituraRequest request) {

        if (!API_KEY.equals(request.key())) {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .build();
        }

        service.salvar(request);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Leitura>> listarLeituras() {

        List<Leitura> leituras = service.listar();

        return ResponseEntity.ok(leituras);
    }

    @PostMapping("/delete")
    public ResponseEntity<Void> resetLeituras(@RequestParam String senha) {
        if (senha.equals("deixeiapagar")) {
            service.apagarLeituras();
            return ResponseEntity.ok().build();
        }

        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .build();
    }
}