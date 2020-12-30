package com.twentyoneclient.game.entity;


import com.twentyoneclient.game.entity.enums.Suit;
import com.twentyoneclient.game.entity.enums.Value;

import java.io.Serializable;
import java.util.Map;

public class Card implements Serializable {
    private Value value;
    private Suit suit;

    public Value getIntValue() {
        return value;
    }

    public Card(Suit suit, Value value) {
        this.value = value;
        this.suit = suit;
    }

    public Card(String cardString) {
        for (Map.Entry<Value, Character> entry : valueMap.entrySet()) {
            if (entry.getValue().equals(cardString.charAt(1))) {
                value = entry.getKey();
            }
        }
        for (Map.Entry<Suit, Character> entry : suitMap.entrySet()) {
            if (entry.getValue().equals(cardString.charAt(2))) {
                suit = entry.getKey();
            }
        }
    }

    @Override
    public String toString() {
        Character value = valueMap.get(this.value);
        Character suit = suitMap.get(this.suit);

        return "[" + value + suit + "]";
    }

    private static final Map<Value, Character> valueMap;

    static {
        valueMap = Map.ofEntries(
                Map.entry(Value.ACE, 'A'),
                Map.entry(Value.TWO, '2'),
                Map.entry(Value.THREE, '3'),
                Map.entry(Value.FOUR, '4'),
                Map.entry(Value.FIVE, '5'),
                Map.entry(Value.SIX, '6'),
                Map.entry(Value.SEVEN, '7'),
                Map.entry(Value.EIGHT, '8'),
                Map.entry(Value.NINE, '9'),
                Map.entry(Value.TEN, 'T'),
                Map.entry(Value.JACK, 'J'),
                Map.entry(Value.QUEEN, 'Q'),
                Map.entry(Value.KING, 'K'));
    }

    private static final Map<Suit, Character> suitMap;

    static {
        suitMap = Map.of(
                Suit.SPADE, '\u2660',
                Suit.HEART, '\u2665',
                Suit.DIAMOND, '\u2666',
                Suit.CLUB, '\u2663');
    }
}
