package dms.pastor.rpg.units;

import dms.pastor.rpg.characteristics.Stats;

/**
 * Author Dominik Symonowicz
 * Created 09/01/2019
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class RaceBasicStatsBuilder {

    public static Stats humanBuilder() {
        return new Stats(1, 6, 30, 1, 24, 24, 0, 0, 0, 0, 0, 10);
    }
}
