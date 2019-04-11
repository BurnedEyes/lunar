import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CardFactory {
    private static final List<Color> colors = Arrays.asList(Color.values());

    public static Card of(Rank rank) {
        return new Card(rank, getRandomColor());
    }

    public static Color getRandomColor() {
        Random random = new Random();
        return colors.get(random.nextInt(colors.size()));
    }
}
