package dms.pastor.tasks.other;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * <p>
 * Very old exercise
 * Find Largest and Smallest Number in an Array in Java without  any third-party library or API method
 */
class ArraysExercises {

    public String findLargestAndSmallest(int[] numbers) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int number : numbers) {
            max = getMaximumValue(number, max);
            min = getMinimumValue(number, min);
        }
        return "Min:" + min + " Max:" + max;
    }

    //Normally you will use Math method for that, it is just exercise
    @SuppressWarnings("ManualMinMaxCalculation")
    int getMaximumValue(int number, int max) {
        return number > max ? number : max;
    }

    //Normally you will use Math method for that, it is just exercise
    @SuppressWarnings("ManualMinMaxCalculation")
    int getMinimumValue(int number, int min) {
        return number < min ? number : min;
    }

}
