package dms.pastor.tasks.other;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class ArraysExercises {

    public static int isMaximumValue(int number, int max) {
        return number > max ? number : max;
    }

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

    public int isMinimumValue(int number, int min) {
        return number < min ? number : min;
    }
}
