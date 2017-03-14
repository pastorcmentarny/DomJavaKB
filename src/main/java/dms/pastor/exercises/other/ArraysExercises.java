package dms.pastor.exercises.other;

/**
 * Author Dominik Symonowicz
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class ArraysExercises {

    //Find Largest and Smallest Number in an Array in Java without  any third-party library or API method
    public String findLargestAndSmallest(int[] numbers) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int number : numbers) {
            max = isMaximumValue(number, max);
            min = isMinimumValue(number, min);
        }
        return "Min:" + min + " Max:" + max;
    }

    public static int isMaximumValue(int number, int max) {
        return number > max ? number : max;
    }

    public int isMinimumValue(int number, int min) {
        return number < min ? number : min;
    }
}
