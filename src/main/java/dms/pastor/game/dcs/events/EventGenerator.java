package dms.pastor.game.dcs.events;

import dms.pastor.game.dcs.units.Unit;

import java.util.ArrayList;
import java.util.Random;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-26
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class EventGenerator {

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