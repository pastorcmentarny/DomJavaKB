package dms.pastor.game.dcs.events;

import dms.pastor.game.dcs.units.Unit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
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
public final class EventGenerator {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventGenerator.class);

    private static final List<Event> EVENTS = new ArrayList<>();
    private static final Random RANDOM = new Random();

    static {
        EVENTS.add(new AirElementEvent());
        EVENTS.add(new EarthElementEvent());
        EVENTS.add(new FireElementEvent());
        EVENTS.add(new WaterElementEvent());
        EVENTS.add(new ShieldRechargeEvent());
        EVENTS.add(new NoEvent());
        EVENTS.addAll(getAllBadEvents());
    }

    private EventGenerator() {
    }

    private static ArrayList<Event> getAllBadEvents() {
        ArrayList<Event> events = new ArrayList<>();
        events.add(new ElementStolenEvent());
        return events;
    }

    public static Event getRandomEvent() {

        return EVENTS.get(RANDOM.nextInt(EVENTS.size()));
    }

    public static void event(Unit player1, Unit player2) {
        LOGGER.debug("Generating RANDOM event..");
        if (RANDOM.nextInt(100) > 40) {
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
