package com.twentyoneclient.controller;

import com.twentyoneclient.game.state.TwentyOneGameState;
import com.twentyoneclient.service.RMIService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/")
public class ClientController {
    RMIService rmi;
    ClientController(ConfigurableApplicationContext context) {
        rmi = context.getBean(RMIService.class);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(Model model) {
        model.addAttribute("message", rmi.helloWorld());
        System.out.println(rmi.helloWorld());
        return "mainMenu";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String startNewGame(Model model) {
        TwentyOneGameState gameState = new TwentyOneGameState(rmi.startNewGame());
        System.out.println(gameState.toString());
        model.addAttribute("game", gameState);
        return "inProgress";
    }

    @RequestMapping(method = RequestMethod.POST, params = "hit")
    public String hit(Model model) {
        TwentyOneGameState gameState = new TwentyOneGameState(rmi.hit());
        model.addAttribute("game", gameState);
        if(gameState.printResult().equals("In progress")) {
            return "inProgress";
        }
        else return "endGame";
    }

    @RequestMapping(method = RequestMethod.POST, params = "stand")
    public String stand(Model model) {
        TwentyOneGameState gameState = new TwentyOneGameState(rmi.stand());
        model.addAttribute("game", gameState);
        return "endGame";
    }
}