import java.util.ArrayList;

public class Player {
    ArrayList<Cards> hand = new ArrayList<>();
    public void drawCard(){
        hand.add(Game.cardDeck.pop());
    }
    public void showHand(){
        System.out.println();
        System.out.println("Your Hand");
        for(var x : hand) System.out.print(x + " ");
        System.out.println("\n");
    }
}
