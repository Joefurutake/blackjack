import java.util.*;

public class Deck {

    private ArrayList<Card> cards;

    public Deck(){

        cards = new ArrayList<>();

        for(int s = 0; s < 4; s++){
            for(int r = 1; r < 14; r++){
                Card c = new Card(r,s);
                cards.add(c);

            }
        }
    }

    public void printDeck(){
        for(Card c: cards){
            System.out.println(c.toString());
        }

    }

    public void shuffle() {
        for (int i = 0; i < 100; i++) {
            int a = (int) (Math.random() * cards.size());
            Card cardA = cards.remove(a);
            int randIndex = (int) (Math.random() * cards.size());
            cards.add(randIndex, cardA);


        }
    }
        public Card dealCard(){
            return cards.remove(0);

    }
    public boolean hasCards(){
        if(cards.size() > 0)
            return true;
        return false;
    }




}