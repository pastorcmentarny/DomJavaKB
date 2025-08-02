package dms.pastor.tasks.exercises.string.characterfinder;

import static dms.pastor.utils.randoms.RandomDataGenerator.getRandomCharacterAsString;

/**
 * Author Dominik Symonowicz
 * Created 2015-10-30
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
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
