package dms.pastor.game.dcs.utils;

import dms.pastor.game.dcs.cards.Card;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-25
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class DebugUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(DebugUtils.class);

    public static void displayCardArray(ArrayList<Card> cards) {
        if (cards != null && !cards.isEmpty()) {
            for (Card card : cards) {
                System.out.println(card.getName());
            }
        } else {
            System.out.println("No cards");
        }

    }

    public static void displayInput(String[] input) {
        LOGGER.debug("Input:");
        if (input != null) {
            for (String s : input) {
                System.out.print(s + " ");
            }
        } else {
            LOGGER.warn("No input typed");
        }
    }
}
