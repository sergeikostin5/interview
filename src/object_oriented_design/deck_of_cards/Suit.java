package object_oriented_design.deck_of_cards;

/**
 * Created by sergei.kostin on 2/3/18.
 */
public enum Suit {

    CLUB(0), DIAMOND(1), HEART(2), SAPDE(3);

    private int value;

    Suit(int value) {
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    public Suit getSuitFromValue(int value){
        for(Suit suit : Suit.values()){
            if(suit.getValue() == value)
            return suit;
        }
        return null;
    }

}
