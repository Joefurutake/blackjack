import java.util.*;

public class Game {
    private Deck deck;
    private ArrayList<Card>player, dealer;

    public Game(){
        deck = new Deck();
        player = new ArrayList<Card>();
        dealer = new ArrayList<Card>();
    }

    public void dealCards(){
        deck.shuffle();
        for (int i = 0; i < 2; i++) {
            player.add(deck.dealCard());
            dealer.add(deck.dealCard());
            
        }
    }

    public int scoreHand(ArrayList<Card> hand){
        int score = 0;
        int aceCount = 0;

        for(Card card: hand){
            if(card.getRank() >= 10)
                score += 10;
            else if(card.getRank() == 1){
                score += 11;
                aceCount++;

            }

            else
                score += card.getRank();
        }



        while(score > 21 && aceCount > 0){
            score -= 10;
            aceCount--;
        }

        return score;
    }

    public void playerTurn() {
        Scanner input = new Scanner(System.in);

        while(scoreHand(player) < 21){
            System.out.println("Hit or Stay?");
            String choice = input.next().toLowerCase();
            if(choice.startsWith("hit")){
                player.add(deck.dealCard());
                printState();
            }
            else if(choice.startsWith("stay"))
                return;
            else
                System.out.println("Enter to hit or stay, Nothing else");

        }

    }

    public void dealerTurn(){
        while(scoreHand(dealer) < 17){
            dealer.add(deck.dealCard());
        }
    }

    public void printState(){
        System.out.println("\nDealer hand: " + dealer.get(0)+ " *");
        System.out.println("Your Hand: " + player + "\n");
    }

    public void printEndState(){
        System.out.println("\nDealer Hand " + dealer);
        System.out.println("Your Hand " + player +"\n");
    }


    public void playRound(){
        dealCards();
        if(scoreHand(player) == 21){
            printEndState();
            System.out.println("\nWINNER");
            return;
        }
        printState();
        playerTurn();
        if(scoreHand(player) > 21){
            System.out.println("\nLOSER");
            printEndState();
            return;
        }
        dealerTurn();
        printEndState();
        if(scoreHand(dealer) > 21) {
            System.out.println("\nWINNER");
            return;
        }
        else if(scoreHand(dealer) > scoreHand(player)) {
            System.out.println("\nLOSER");
            return;
        }
        else if(scoreHand(dealer) < scoreHand(player)) {
            System.out.println("\nWINNER");
            return;
        }
        else{
            System.out.println("\nTIE");
            return;
        }
    }
}
