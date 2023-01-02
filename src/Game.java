import java.util.*;

public class Game {
    static Player p = new Player();
    static Scanner sc = new Scanner(System.in);
    static Stack<Cards> cardDeck = new Stack<>();
    static ArrayList<Cards> onBoard = new ArrayList<>();
    static int trade, fromBoard;
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
        for(int i=0;i<5;i++) p.drawCard();
        do {
            showBoard();
            p.showHand();
            wannaTrade();
        }while(true);
    }
    public static void showBoard(){
        for(int i=0;i<3;i++)
            try{
                onBoard.add(cardDeck.pop());
            }catch(EmptyStackException e){
                System.out.println("The Deck is Empty.");
            }
        int i = 1;
        System.out.println();
        System.out.println("On Board");
        for(var x : onBoard) {
            System.out.println(i + ". " + x);
            i++;
        }
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
        do {
            try {
                System.out.print("What Card you wanna Trade: ");
                trade = Integer.parseInt(sc.nextLine());
                System.out.print("What Card you want from the Board: ");
                fromBoard = Integer.parseInt(sc.nextLine());
                passed = true;
            } catch (NumberFormatException e) {
                System.out.println("Something went wrong...");
                passed = false;
            }
        }while(!passed);
        switch(trade){
            case 1 ->{
                p.hand.remove(0);
                p.hand.add(0, onBoard.get(fromBoard-1));
            }
            case 2 ->{
                p.hand.remove(1);
                p.hand.add(1, onBoard.get(fromBoard-1));
            }
            case 3 ->{
                p.hand.remove(2);
                p.hand.add(2, onBoard.get(fromBoard-1));
            }
            case 4 ->{
                p.hand.remove(3);
                p.hand.add(3, onBoard.get(fromBoard-1));

            }
            case 5 ->{
                p.hand.remove(4);
                p.hand.add(4, onBoard.get(fromBoard));
            }
            default -> System.out.println("Something went wrong...");
        }
        onBoard.clear();

    }
    public static void newCards(){
        onBoard.clear();
    }
}

