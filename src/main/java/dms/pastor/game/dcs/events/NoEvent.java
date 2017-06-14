package dms.pastor.game.dcs.events;


import dms.pastor.game.dcs.units.Unit;

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

    public NoEvent() {
        setName("No Event");
        setDescription("Another round, where nothing seems to happen."); //TODO make it random message
    }

    @Override
    public String makeItHappen(Unit player1, Unit player2) {
        return getDescription();
    }
}
