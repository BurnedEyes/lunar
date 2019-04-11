public class Card implements Comparable<Card> {
    private Rank rank;
    private Color color;

    public Card(Rank rank, Color color) {
        this.rank = rank;
        this.color = color;
    }

    public Rank getRank() {
        return rank;
    }

    public Color getColor() {
        return color;
    }

    public int compareTo(Card card) {
        return this.rank.compareTo(card.rank);
    }

    @Override
    public String toString() {
        return rank.toString().substring(1) + color.toString().substring(0,1).toLowerCase();
    }
}
