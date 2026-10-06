package com.aquario.monitoramento;

import java.time.Instant;

public record LeituraRequest(

        Double temperatura,

        Boolean coolerLigado,

        Boolean aquecedorLigado,

        Instant dataHora,

        String key
) {


}
