package dms.pastor.game.dcs.events;

import dms.pastor.game.dcs.units.Unit;

import java.util.Random;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-26
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class NoEvent extends Event {
    private static final Random RANDOM = new Random();
    private static final String[] description = new String[]{
            "Another round, where nothing seems to happen.",
            "Wind of boredom pass through this round"
    };

    public NoEvent() {
        setName("No Event");
        setDescription(description[RANDOM.nextInt(description.length)]);
    }

    @Override
    public String makeItHappen(Unit player1, Unit player2) {
        return getDescription();
    }
}
