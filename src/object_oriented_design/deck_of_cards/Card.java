package object_oriented_design.deck_of_cards;

/**
 * Created by sergei.kostin on 2/3/18.
 */
public abstract class Card {

    private boolean available = true;
    private int faceValue = 0;
    private Suit suit;

    public Card(Suit suit, int faceValue){
        this.suit = suit;
        this.faceValue = faceValue;
    }

    public boolean isAvailable() {
        return available;
    }

    public void markUnavailable(){
        available = false;
    }

    public void markAvailable(){
        available = true;
    }

    public abstract int getFaceValue();

    public Suit getSuit() {
        return suit;
    }
}
