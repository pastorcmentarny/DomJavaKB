package dms.pastor.domain;

import dms.pastor.utils.randoms.RandomDataGenerator;

import static dms.pastor.utils.randoms.RandomDataGenerator.*;

/**
 * Author Dominik Symonowicz
 * Created 04/09/2016
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class Treasure {

    private final String name;
    private final String description;
    private final int value;

    public Treasure(String name, String description, int value) {
        this.name = name;
        this.description = description;
        this.value = value;
    }

    public static Treasure getRandomTreasure() {
        return new Treasure(generateString(MAX_SMALL_VALUE_RANGE), generateRandomParagraph(), RandomDataGenerator.randomPositiveInteger());
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getValue() {
        return value;
    }

}
