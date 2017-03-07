package dms.pastor.exercises.numbers;

import java.util.Random;

/**
 * Author Dominik Symonowicz
 * Created 2013-08-09
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
class MathTasks {

    int[] removeRandomNumberFromArray(int[] allItems) {
        int[] almostAll = new int[allItems.length - 1];
        int removedItem = new Random().nextInt(allItems.length);
        for (int i = 0; i < almostAll.length; i++) {
            if (i >= removedItem) {
                almostAll[i] = allItems[i + 1];
            } else
                almostAll[i] = allItems[i];
        }
        return almostAll;
    }

    int findMissingNumberInArrayWithoutDuplicates(int all, int almostAll) {
        return all - almostAll;
    }
}
