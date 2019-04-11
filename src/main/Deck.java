import java.util.*;

public class Deck {
    private final Stack<Card> cards;

    public Deck() {
        Stack<Card> cards = new Stack<>();
        for (Color color : Color.values()) {
            for (Rank rank : Rank.values()) {
                cards.push(new Card(rank, color));
            }
        }
        this.cards = cards;
    }

    public Stack<Card> getCards() {
        return cards;
    }
}
