package dms.pastor.tasks.exercises.numbers;

import dms.pastor.utils.NumberUtils;

import java.util.Random;

/**
 * Author Dominik Symonowicz
 * Created 2013-08-09
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
class MathTasks {

    int[] removeRandomNumberFromArray(int[] allItems) {
        int[] almostAll = new int[allItems.length - 1];
        int removedItem = new Random().nextInt(allItems.length);
        for (int i = 0; i < almostAll.length; i++) {
            if (i >= removedItem) {
                almostAll[i] = allItems[i + 1];
            } else {
                almostAll[i] = allItems[i];
            }
        }
        return almostAll;
    }

    int findMissingNumberInArrayWithoutDuplicates(int[] all, int[] almostAll) {
        return NumberUtils.calculateTotal(all) - NumberUtils.calculateTotal(almostAll);
    }
}
