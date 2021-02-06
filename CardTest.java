public class CardTest {
    public static void main(String[] args){

        Deck test = new Deck();
        test.shuffle();
        int count = 0;
        while(test.hasCards()){
            count++;
            Card a = test.dealCard();
            System.out.println(a.toString());
        }
        System.out.println(count);
    }

}
