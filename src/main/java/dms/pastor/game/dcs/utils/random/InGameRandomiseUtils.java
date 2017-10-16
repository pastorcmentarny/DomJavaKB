package dms.pastor.game.dcs.utils.random;

import java.util.Random;

public class InGameRandomiseUtils implements RandomiseUtils {

    private static final Random RANDOM = new Random();
    private static final int MAX_PERCENTAGE = 100;

    public boolean isWillHappenWithProbabilityOf(int percentage) {
        return percentage > MAX_PERCENTAGE || percentage >= 0 && RANDOM.nextInt(MAX_PERCENTAGE) > percentage;

    }
}
