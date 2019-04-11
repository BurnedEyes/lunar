import java.util.*;
import java.util.stream.Collectors;

public class Hand {
    private List<Card> cards;

    public Hand(List<Card> cards) {
        Collections.sort(cards);
        this.cards = cards;
    }

    public boolean isStraight() {
        List<Rank> ranks = cards.stream().map(Card::getRank).collect(Collectors.toList());
        if (ranks.get(ranks.size() - 1) == Rank._A) {
            return ranks.containsAll(EnumSet.of(Rank._2, Rank._3, Rank._4, Rank._5)) ||
                    ranks.containsAll(EnumSet.of(Rank._T, Rank._J, Rank._Q, Rank._K));
        }
        IntSummaryStatistics summary = ranks.stream().mapToInt(Enum::ordinal).distinct().summaryStatistics();
        return summary.getMax() - summary.getMin() == cards.size() - 1;
    }

    public boolean hasPair() {
        return hasSameRanks(2);
    }

    public boolean hasTrips() {
        return hasSameRanks(3);
    }

    public boolean hasFourOfAKind() {
        return hasSameRanks(4);
    }

    public boolean isFull() {
        return hasSameRanks(3, 2);
    }

    private boolean hasSameRanks(int i, int... extra) {
        Map<Rank, List<Card>> ranks = cards.stream().collect(Collectors.groupingBy(Card::getRank));
        boolean condition = true;
        for (int j : extra) {
            condition &= ranks.entrySet().stream().anyMatch(x -> x.getValue().size() == j);
        }
        return ranks.entrySet().stream().anyMatch(x -> x.getValue().size() == i) && condition;
    }
}
