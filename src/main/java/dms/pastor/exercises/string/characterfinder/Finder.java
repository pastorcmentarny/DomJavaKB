package dms.pastor.exercises.string.characterfinder;

import static dms.pastor.utils.RandomDataGenerator.getRandomCharacterAsString;

/**
 * Author Dominik Symonowicz
 * Created 2015-10-30
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
class Finder {
    int find() {

        boolean ba = false;
        boolean bz = false;
        int counter = 0;
        while (!ba && !bz) {
            counter++;
            String s = getRandomCharacterAsString();
            if (s.equalsIgnoreCase("a")) {
                ba = true;
            }
            if (s.equalsIgnoreCase("z")) {
                bz = true;
            }
        }
        return counter;
    }

}
