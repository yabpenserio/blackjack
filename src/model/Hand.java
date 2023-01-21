package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hand {
    private List<Card> cards;

    public Hand (Card... cards) {
        this.cards = new ArrayList<>(Arrays.asList(cards));
    }
    public int value(){
        int sum = 0;
        for (Card card : cards){
            sum += card.value();
        }
        if (!containsCardWithValue(11)) return sum;
        else return obtainValueinHandWithVariableAceValue(sum);
                
    }
    public boolean isBlackJack() {
        return cards.size() == 2 && containsCardWithValue(11) && containsCardWithValue(10);
    }

    private boolean containsCardWithValue(int value) {
        for (Card card : cards) {
            if(card.value() == value) return true;
        }
        return false;
    }
    private int obtainValueinHandWithVariableAceValue(int s){
        for (Card card : cards) {
            if(card.isAce() && s > 21){
                s -= 10;
            }
            if(s <= 21) break;
        }
        return s;
    }

    public boolean isBust() {
        return value() > 21;
    }
    public boolean add(Card card){
        return cards.add(card);
    }
    @Override 
    public String toString(){
        return cards.toString();
    }
            
    
}
