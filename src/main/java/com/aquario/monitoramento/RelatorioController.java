package com.aquario.monitoramento;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RelatorioController {

    @GetMapping("/")
    public String relatorio() {
        return "grafico_aquario";
    }

}
