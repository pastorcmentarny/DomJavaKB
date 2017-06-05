package dms.pastor.game.dcs.utils.random;

import java.util.Random;

public class InGameRandomiserUtils implements RandomiserUtils {

    static final Random random = new Random();
    static final int MAX_PERCENTAGE = 100;

    public boolean isWillHappenWithProbabilityOf(int percentage) {
        return percentage > MAX_PERCENTAGE || percentage >= 0 && random.nextInt(MAX_PERCENTAGE) > percentage;

    }
}
