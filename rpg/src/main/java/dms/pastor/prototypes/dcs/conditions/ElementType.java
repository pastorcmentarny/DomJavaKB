package dms.pastor.prototypes.dcs.conditions;

import java.util.Random;

/**
 * Author Dominik Symonowicz
 * Created 2015-08-02
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public enum ElementType {
    AIR, EARTH, FIRE, WATER;

    private static final Random RANDOM = new Random();

    public static ElementType getRandomElement() {
        return ElementType.values()[RANDOM.nextInt(ElementType.values().length)];
    }

}
