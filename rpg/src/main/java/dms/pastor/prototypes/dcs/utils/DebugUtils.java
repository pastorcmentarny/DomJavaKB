package dms.pastor.prototypes.dcs.utils;

import dms.pastor.prototypes.dcs.cards.Card;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-25
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public final class DebugUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(DebugUtils.class);

    private DebugUtils() {
    }

    public static void displayCardArray(List<Card> cards) {
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
            LOGGER.warn("No input typed.");
        }
    }
}
