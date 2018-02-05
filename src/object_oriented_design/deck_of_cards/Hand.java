package object_oriented_design.deck_of_cards;

import java.util.List;

/**
 * Created by sergei.kostin on 2/3/18.
 */
public class Hand<T extends Card> {

    private List<T> handOfCards;

    public Hand(List<T> cards){
        handOfCards = cards;
    }

    public int getScore(){
        int score = 0;
        for(T t : handOfCards){
            score = + t.getFaceValue();
        }
        return score;
    }

    public void addCard(T card){
        handOfCards.add(card);
    }

}
