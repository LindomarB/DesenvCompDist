package com.lindomar.TesteOAuth2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/")
    public String Inicial() {
        return "voce nao precisa estar logado";
    }

    @GetMapping("/todos")
    public String todosUsuarios() {
        return "voce nao precisa estar logado";
    }

    @GetMapping("/logado")
    public String logado() {
        return "se voce esta vendo isso voce esta logado";
    }
}