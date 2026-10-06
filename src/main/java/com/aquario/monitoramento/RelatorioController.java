package com.aquario.monitoramento;

import org.springframework.stereotype.Controller;

@Controller
public class RelatorioController {

    public String relatorio() {
        return "grafico_aquario";
    }

}
