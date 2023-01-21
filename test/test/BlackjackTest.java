package test;

import static model.Card.*;
import model.Hand;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BlackjackTest {

    @Test
    public void test_hand_value_with_one_card() {
        assertEquals(3, new Hand(_3).value());
        assertEquals(8, new Hand(_8).value());
        assertEquals(10, new Hand(Queen).value());
        assertEquals(10, new Hand(King).value());
        assertEquals(10, new Hand(_10).value());
        assertEquals(11, new Hand(Ace).value());
        
     }
    @Test
    public void test_hand_value_with_two_cards(){
        assertEquals(13, new Hand(Ace,_2).value());
        assertEquals(6, new Hand(_3,_3).value());
        assertEquals(20, new Hand(_10,Queen).value());
        assertEquals(12, new Hand(Ace,Ace).value());
    }
    @Test 
    public void test_hand_is_blackjack(){
        assertEquals(false, new Hand(Ace,Ace).isBlackJack());
        assertEquals(false, new Hand(_3,_7).isBlackJack());
        assertEquals(true, new Hand(Ace,_10).isBlackJack());
        assertEquals(true, new Hand(Queen,Ace).isBlackJack());
        assertEquals(false, new Hand(Queen,King).isBlackJack());
        assertEquals(false, new Hand(Queen,King,Ace).isBlackJack());
        
    }
    @Test
    public void test_hand_value_with_three_cards(){
        assertEquals(21, new Hand(Ace,_2,_8).value());
        assertEquals(23, new Hand(Queen,_3,King).value());
        assertEquals(17, new Hand(_10,_5,_2).value());
        assertEquals(17, new Hand(Ace,_8,_8).value());
        assertEquals(16, new Hand(_8,Ace,_7).value());
        assertEquals(17, new Hand(_8,_8,Ace).value());
    }
    @Test
    public void test_hand_with_three_cards_is_bust(){
        assertEquals(false, new Hand(_8,_8,Ace).isBust());
        assertEquals(true, new Hand(_8,_8,_9).isBust());
        assertEquals(false, new Hand(Ace,Ace,Ace).isBust());
        assertEquals(true, new Hand(Jack,Queen,King).isBust());
        
    }
    @Test 
    public void test_hand_with_three_cards_is_not_black_jack() {
       assertEquals(false, new Hand(_5, _6, Queen).isBlackJack());               
    }
    @Test
    public void test_hand_value_with_four_cards(){
        assertEquals(29,  new Hand(Ace,Queen,_8 ,_10).value());
        assertEquals(22, new Hand(Queen,Ace,King,Ace).value());
        assertEquals(21, new Hand(_3,_5,_2,Ace).value());
        assertEquals(21, new Hand(Ace,_4,_2,_4).value());
        assertEquals(21, new Hand(_7,Ace,Ace,_2).value());
        assertEquals(19, new Hand(_8,_8,Ace,_2).value());
    }
    
    
    }
    
    

