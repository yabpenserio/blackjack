package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static model.Card.*;
import model.Hand.*;
import model.Player;
import model.Player.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import model.BlackJack;
import model.Card;
import model.Hand;


public class getWinnersBlackJackTest {

    BlackJack blackjack;
    Player p1, p2, p3, croupier;
    
    @Before
    public void setUpBlackjack(){
        croupier = new Player("croupier");
        p1 = new Player("player1");
        p2 = new Player("player2");
        p3 = new Player("player3");
        
        blackjack = new BlackJack(p1, p2, p3, croupier);
    }
    @Test
    public void test_blackjack_no_winners_players_bust(){
        p1.setHand(new Hand(_2,Ace, King));
        p2.setHand(new Hand(_5,_7, _10));
        p3.setHand(new Hand(King,_2,_4,Queen));
        croupier.setHand(new Hand(Ace,_6));
        
        
        List<Hand> hands = Arrays.asList(p1.getHand(),p2.getHand(),p3.getHand());
        List<Card> deck = Arrays.asList(Ace);
        assertEquals(0, blackjack.getWinners(hands, croupier.getHand(),deck).length);
    }
    
    @Test
    public void test_blackjack_no_winners_croupier_blackjack(){
        p1.setHand(new Hand(Ace, King));
        p2.setHand(new Hand(_4,_7, _10));
        p3.setHand(new Hand(King,_2,_8));
        croupier.setHand(new Hand(Ace,King));
        
        
        List<Hand> hands = Arrays.asList(p1.getHand(),p2.getHand(),p3.getHand());
        ArrayList<Card> deck = new ArrayList<Card>(){{
            add(_6);
            add(_3);
            add(Ace);
            add(_8);
        }};
        assertEquals(0, blackjack.getWinners(hands, croupier.getHand(),deck).length);
    }
    
    @Test
    public void test_blackjack_all_winners_croupier_is_bust(){
        p1.setHand(new Hand(_2,_8,_5,_4));
        p2.setHand(new Hand(_7,Queen,Ace));
        p3.setHand(new Hand(King,_2,_8));
        croupier.setHand(new Hand(Queen,_6));
        
        
        List<Hand> hands = Arrays.asList(p1.getHand(),p2.getHand(),p3.getHand());
        ArrayList<Card> deck = new ArrayList<Card>(){{
            add(_6);
            add(_3);
            add(Ace);
            add(_8);
        }};
        assertEquals(3, blackjack.getWinners(hands, croupier.getHand(),deck).length);
    }
    @Test
    public void test_blackjack_with_one_winner(){
        p1.setHand(new Hand(_2,_8,_5,_4));
        p2.setHand(new Hand(_7,Queen));
        p3.setHand(new Hand(King,_2,_6,Ace,_6));
        croupier.setHand(new Hand(_5,_7,_2));
        
        
        List<Hand> hands = Arrays.asList(p1.getHand(),p2.getHand(),p3.getHand());
        ArrayList<Card> deck = new ArrayList<Card>(){{
            add(_3);
            add(_9);
        }};
        Player[] ExpectedWinners = {p1};
        Player[] ActualWinners = blackjack.getWinners(hands, croupier.getHand(),deck);
        assertTrue(Arrays.equals(ExpectedWinners, ActualWinners));
    }
    
    @Test
    public void test_blackjack_with_two_winners(){
        p1.setHand(new Hand(_2,_10,Ace,_2));
        p2.setHand(new Hand(_10,Ace));
        p3.setHand(new Hand(King,_3,_3,Ace,Ace));
        croupier.setHand(new Hand(_5,_7,_2));
        
        
        List<Hand> hands = Arrays.asList(p1.getHand(),p2.getHand(),p3.getHand());
        ArrayList<Card> deck = new ArrayList<Card>(){{
            add(_3);
        }};
        Player[] ExpectedWinners = {p2,p3};
        Player[] ActualWinners = blackjack.getWinners(hands, croupier.getHand(),deck);
        assertTrue(Arrays.equals(ExpectedWinners, ActualWinners));
    }
    
    
    
    
}
