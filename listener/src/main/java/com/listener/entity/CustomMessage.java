package com.listener.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="messages")
public class CustomMessage {
    @Id
    @Column(name = "id")
    long messageId;
    @Column(name = "action")
    String action;
    @Column(name = "result")
    String result;
    @Column(name = "dealer_hand")
    String dealersHand;
    @Column(name = "dealer_totals")
    String dealersTotals;
    @Column(name = "player_hand")
    String playersHand;
    @Column(name = "player_totals")
    String playersTotals;

    public CustomMessage() {}

    public CustomMessage(long messageId, String action, String result,
                         String dealersHand, String dealersTotals,
                         String playersHand, String playersTotals) {
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

    public void setDealersTotals(List<Integer> totals) {
        this.dealersTotals = totals.toString();
    }

    public List<Integer> getDealersTotals() {
        return extractIntegerList(dealersTotals);
    }

    public String getPlayersHand() {
        return playersHand;
    }

    public List<Integer> getPlayersTotals() {
        return extractIntegerList(playersTotals);
    }

    public void setPlayersTotals(List<Integer> totals) {
        this.playersTotals = totals.toString();
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

    private List<Integer> extractIntegerList(String playersTotals) {
        String s;
        s = playersTotals.substring(1, playersTotals.length() - 2);
        String[] totalsString = s.split(",");
        List<Integer> list = new ArrayList<>();
        for (String i : totalsString) {
            list.add(Integer.valueOf(i));
        }
        return list;
    }
}
