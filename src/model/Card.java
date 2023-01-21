package model;

public enum Card {
        Ace, _2, _3, _4, _5, _6, _7, _8, _9, _10, Jack, Queen, King;
       
        boolean isFace() {
            return this == Jack || this == Queen || this == King;            
        }
        boolean isAce(){
            return this == Ace;   
        }

        int value() {
            if (isAce()) return 11;
            return isFace() ? 10 : ordinal() + 1;
        }
        
        
} 
