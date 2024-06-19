package com.html.input.InputController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Random;

@Controller
public class JogoController {

    private int numeroSecreto;
    private boolean jogoAtivo;

    @GetMapping("/game")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        if (!jogoAtivo) {
            iniciarJogo();
        }
        modelAndView.setViewName("jogoSecreto");
        modelAndView.addObject("jogoAtivo", jogoAtivo);
        return modelAndView;
    }

    @PostMapping("/game")
    public ModelAndView chute(@RequestParam("palpite") int palpite) {
        ModelAndView modelAndView = new ModelAndView();
        if (!jogoAtivo) {
            iniciarJogo();
        }
        modelAndView.setViewName("jogoSecreto");

        if (jogoAtivo) {
            if (palpite < numeroSecreto) {
                modelAndView.addObject("mensagem", "O número secreto é maior que " + palpite);
            } else if (palpite > numeroSecreto) {
                modelAndView.addObject("mensagem", "O número secreto é menor que " + palpite);
            } else {
                modelAndView.addObject("mensagem", "ACERTOU!! O número secreto era " + palpite);
                jogoAtivo = false;
            }
        }
        modelAndView.addObject("jogoAtivo", jogoAtivo);
        return modelAndView;
    }

    @GetMapping("/reset")
    public RedirectView resetGame() {
        iniciarJogo();
        return new RedirectView("/game");
    }

    private void iniciarJogo() {
        jogoAtivo = true;
        Random rd = new Random();
        numeroSecreto = rd.nextInt(100);
    }
}
