package dms.pastor.prototype.dcs.utils.random;

import java.util.Random;

public class InGameRandomUtils implements RandomUtils {

    public static final int FIVE_PERCENT = 5;
    public static final int QUARTER = 25;
    public static final int ONE_THIRD = 33;
    public static final int FORTY = 40;
    public static final int HALF = 50;
    public static final int TWO_THIRD = 66;
    public static final int THREE_QUARTERS = 75;

    private static final Random RANDOM = new Random();
    private static final int MAX_PERCENTAGE = 100;

    public boolean isWillHappenWithProbabilityOf(int percentage) {
        return percentage > MAX_PERCENTAGE || percentage >= 0 && RANDOM.nextInt(MAX_PERCENTAGE) > percentage;
    }
}
