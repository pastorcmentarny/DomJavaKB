package dms.pastor.domain;

import dms.pastor.utils.randoms.RandomDataGenerator;

import static dms.pastor.utils.randoms.RandomDataGenerator.*;

/**
 * Author: Dominik Symonowicz
 * Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
 * LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
 * GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 * Created 04/09/2016
 */

public record Treasure(String name, String description, int value) {

    public static Treasure getRandomTreasure() {
        return new Treasure(generateString(MAX_SMALL_VALUE_RANGE), generateRandomParagraph(), RandomDataGenerator.randomPositiveInteger());
    }

}
