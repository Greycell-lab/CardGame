import java.util.Stack;

public enum Cards {
    KING(10),
    QUEEN(10),
    JACK(10),
    TEN(10),
    NINE(9),
    EIGHT(8),
    SEVEN(7),
    SIX(6),
    FIVE(5),
    FOUR(4),
    THREE(3),
    TWO(2),
    ACE(1);
    final int value;
    Cards(int value){
        this.value = value;
    }

}
