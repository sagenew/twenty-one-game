package com.twentyone.rabbitmq.entity;

import java.util.List;

public class CustomMessage {
    long messageId;
    String action;
    String result;
    String dealersHand;
    List<Integer> dealersTotals;
    String playersHand;
    List<Integer> playersTotals;

    public CustomMessage(long messageId, String action, String result,
                         String dealersHand, List<Integer> dealersTotals,
                         String playersHand, List<Integer> playersTotals) {
        this.messageId = messageId;
        this.action = action;
        this.result = result;
        this.dealersHand = dealersHand;
        this.dealersTotals = dealersTotals;
        this.playersHand = playersHand;
        this.playersTotals = playersTotals;
    }

    public long getMessageId() {
        return messageId;
    }

    public String getAction() {
        return action;
    }

    public String getresult() {
        return result;
    }

    public String getDealersHand() {
        return dealersHand;
    }

    public List<Integer> getDealersTotals() {
        return dealersTotals;
    }

    public String getPlayersHand() {
        return playersHand;
    }

    public List<Integer> getPlayersTotals() {
        return playersTotals;
    }

    @Override
    public String toString() {
        return "CustomMessage{" +
                "messageId=" + messageId +
                ", action='" + action + '\'' +
                ", result='" + result + '\'' +
                ", dealersHand='" + dealersHand + '\'' +
                ", dealersTotals=" + dealersTotals +
                ", playersHand='" + playersHand + '\'' +
                ", playersTotals=" + playersTotals +
                '}';
    }
}
