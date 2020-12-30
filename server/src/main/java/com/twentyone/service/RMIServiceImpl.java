package com.twentyone.service;

import com.twentyone.game.TwentyOneGame;
import com.twentyone.rabbitmq.RabbitBroker;
import com.twentyone.rabbitmq.entity.CustomMessage;

import java.util.Map;

public class RMIServiceImpl implements RMIService {
    RabbitBroker rabbit;
    long messageIter = 0;

    public RMIServiceImpl(RabbitBroker rabbit) {
        this.rabbit = rabbit;
    }

    TwentyOneGame game;
    String helloWorld = "Hello World from Server !";

    @Override
    public String helloWorld() {
        return helloWorld;
    }

    @Override
    public Map<String, String> startNewGame() {
        game = new TwentyOneGame();
        rabbit.sendMessage(generateCustomMessage("NEW GAME"));
        return game.getGameState();
    }

    @Override
    public Map<String, String> hit() {
        game.playerHit();
        if(game.playerBusted()) {
            game.resolveDealerHand();
        }
        rabbit.sendMessage(generateCustomMessage("HIT"));
        return game.getGameState();
    }

    @Override
    public Map<String, String> stand() {
        game.stand();
        game.resolveDealerHand();
        rabbit.sendMessage(generateCustomMessage("STAND"));
        return game.getGameState();
    }

    private CustomMessage generateCustomMessage(String message) {
        return new CustomMessage(messageIter++, message, game.result(),
                game.getDealersHand().mapToString(), game.getDealersHand().getTotals(),
                game.getPlayersHand().mapToString(), game.getPlayersHand().getTotals());
    }
}
