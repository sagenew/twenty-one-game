package com.twentyoneclient.game.state;

import com.twentyoneclient.game.entity.Hand;

import java.util.Map;

public class TwentyOneGameState {
    public Hand dealersHand;
    public Hand playersHand;
    public String result;

    public TwentyOneGameState(Map<String, String> gameState) {
        this.dealersHand = new Hand(gameState.get("dealer"));
        this.playersHand = new Hand(gameState.get("player"));
        this.result = gameState.get("result");
    }

    public String printDealersHand() {
        return dealersHand.toString();
    }

    public String printDealersTotals() {
        return dealersHand.getTotals().toString();
    }

    public String printPlayersHand() {
        return playersHand.toString();
    }

    public String printDealersResult() {
        return dealersHand.result();
    }

    public String printPlayersTotals() {
        return playersHand.getTotals().toString();
    }

    public String printPlayersResult() {
        return playersHand.result();
    }

    public String printResult() {
        return result;
    }

    public String toString() {
        return "result : \"" + printResult() + "\"; " +
                "dealer hand : " + dealersHand.toString() + " (score : " + dealersHand.getTotals() + "); " +
                "player hand : " + playersHand.toString() + " (score : " + playersHand.getTotals() + "); ";
    }
}
