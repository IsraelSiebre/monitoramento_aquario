package com.aquario.monitoramento;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LeituraService {

    private final LeituraRepository repository;

    public void salvar(LeituraRequest dto) {
        Leitura leitura = new Leitura();
        leitura.setTemperatura(dto.temperatura());
        leitura.setCoolerLigado(dto.coolerLigado());
        leitura.setAquecedorLigado(dto.aquecedorLigado());
        leitura.setDataHora(dto.dataHora());
        repository.save(leitura);
    }

    public List<Leitura> listar() {
        return repository.findAll();
    }

}
