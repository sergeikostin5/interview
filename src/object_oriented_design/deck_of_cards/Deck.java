package object_oriented_design.deck_of_cards;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergei.kostin on 2/3/18.
 */
public class Deck< T extends Card> {

    private List<T> cards;

    public void setCards(List<T> cards) {
        this.cards = cards;
    }

    public void shuffle(){

    }

    public int remainingCards(){
        return cards.size();
    }

    public Hand<T> dealCard(){
        return null;
    }
}
