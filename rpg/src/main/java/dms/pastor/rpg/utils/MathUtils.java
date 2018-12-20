package dms.pastor.rpg.utils;


public class MathUtils {
    public static int increaseByPercent(double value, double percent) {
        double result = value + (value * (percent / 100));

        if (result - value < 1) {
            return (int) value + 1;
        }
        return (int) Math.round(result);
    }
}
