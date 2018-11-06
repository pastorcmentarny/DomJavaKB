package dms.pastor.tasks.exercises.string.characterfinder;

import static dms.pastor.utils.randoms.RandomDataGenerator.getRandomCharacterAsString;

/**
 * Author Dominik Symonowicz
 * Created 2015-10-30
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
class Finder {

    int find() {

        boolean ba = false;
        boolean bz = false;
        int counter = 0;
        while (!ba && !bz) {
            counter++;
            String s = getRandomCharacterAsString();
            if ("a".equalsIgnoreCase(s)) {
                ba = true;
            }
            if ("z".equalsIgnoreCase(s)) {
                bz = true;
            }
        }
        return counter;
    }

}
