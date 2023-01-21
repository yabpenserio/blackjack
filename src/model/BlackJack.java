package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class BlackJack {
    private final Player croupier;
    private final Player players[] = new Player[3];
    
    public BlackJack(Player p1, Player p2, Player p3, Player c){
        croupier = c;
        players[0] = p1;
        players[1] = p2;
        players[2] = p3;   
    }

    public Player[] getWinners(List<Hand> playerHands, Hand croupierHand, List<Card> deck){
        if(croupierHand.isBlackJack())return new Player[0];
        
        while(croupierHand.value() < 17 && !deck.isEmpty()){
            croupierHand.add(deck.remove(0));
        }
        
        //if(croupierHand.isBust())return Arrays.copyOf(players, 3);
      
        List<Player> winners = new ArrayList<>();
        
        for (int idx = 0; idx < playerHands.size(); idx++) {
            if (playerHands.get(idx).isBust()){
                continue;
            }
            if(playerHands.get(idx).isBlackJack()|| playerHands.get(idx).value() 
                    > croupierHand.value() || (croupierHand.isBust() && !playerHands.get(idx).isBust())){
                winners.add(players[idx]);
            }
        }
        return winners.toArray(Player[]::new);
        
    }
    public Player[] getPlayers(){
        return players;
    }
    
}
