package model;

import java.util.Objects;

public class Player {
    protected Hand hand = new Hand();
    private String name;

    public Player(String n) {
        name = n;
    }
    
    
    public Hand getHand(){
        return hand;
    }
    public String getName(){
        return name;
    }
    public void setHand(Hand h){
        hand = h;
    }
    @Override
    public String toString(){
        return getName();
    }
    @Override 
    public boolean equals(Object o){
        if(o instanceof Player){
            Player p = (Player) o;
            if(this.getName().equals((p.getName()))){
                return true;
            } else {
                return false;
            }
        }   
        return false;   
    }
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.name);
        return hash;
    }
    

    
    
}
