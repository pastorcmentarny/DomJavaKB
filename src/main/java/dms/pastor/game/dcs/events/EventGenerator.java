package dms.pastor.game.dcs.events;

import dms.pastor.game.dcs.units.Unit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
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
public class EventGenerator {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventGenerator.class);

    private static final ArrayList<Event> events = new ArrayList<>();
    private static final Random random = new Random();

    static {
        events.add(new AirElementEvent());
        events.add(new EarthElementEvent());
        events.add(new FireElementEvent());
        events.add(new WaterElementEvent());
        events.add(new ShieldRechargeEvent());
        events.add(new NoEvent());
        events.addAll(getAllBadEvents());
    }

    private static ArrayList<Event> getAllBadEvents() {
        ArrayList<Event> events = new ArrayList<>();
        events.add(new ElementStolenEvent());
        return events;
    }

    public static Event getRandomEvent() {

        return events.get(random.nextInt(events.size()));
    }

    public static void event(Unit player1, Unit player2) {
        LOGGER.debug("Generating random event..");
        if (random.nextInt(100) > 40) {
            Event event = getRandomEvent();
            System.out.println("EVENT:" + event.makeItHappen(player1, player2));
        } else {
            System.out.println("EVENT: Nothing happen");
        }
    }

    //TODO
    public static Event badEvent(Unit defender) {
        return new NoEvent();
    }
}
