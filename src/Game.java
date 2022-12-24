import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Game {
    static Scanner sc = new Scanner(System.in);
    static Stack<Cards> cardDeck = new Stack<Cards>();
    static ArrayList<Cards> onBoard = new ArrayList<>();
    static boolean passed;
    public static void shuffleDeck(){
        for(var x : Cards.values()){
            for(int i=0;i<4;i++) cardDeck.push(x);
        }
        Collections.shuffle(cardDeck);
        System.out.println("Deck is shuffled");
        System.out.println();
        startGame();
    }
    public static void startGame(){
        Player p = new Player();
        for(int i=0;i<5;i++) p.drawCard();
        do {
            showBoard();
            p.showHand();
            wannaTrade();
        }while(true);
    }
    public static void showBoard(){
        for(int i=0;i<5;i++) onBoard.add(cardDeck.pop());
        System.out.println("On Board");
        for(var x : onBoard) System.out.println((onBoard.indexOf(x)+1) + ". " + x);
    }
    public static void wannaTrade(){
        do {
            try {
                System.out.println("1: Trade");
                System.out.println("2: New Cards");
                System.out.print("Choose: ");
                int x = Integer.parseInt(sc.nextLine());
                switch (x) {
                    case 1 -> {
                        tradeCard();
                        passed = true;
                    }
                    case 2 -> {
                        newCards();
                        passed = true;
                    }
                    default -> {
                        System.out.println("Wrong Input...");
                        passed = false;
                    }
                }
            } catch (Exception e) {
                System.out.println("Something went wrong...");
                passed = false;
            }
        }while(!passed);
    }
    public static void tradeCard(){

    }
    public static void newCards(){
        onBoard.clear();
    }
}

