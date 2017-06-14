package dms.pastor.game.dcs.events;

import dms.pastor.game.dcs.units.Unit;
import org.junit.Test;

import static dms.pastor.game.dcs.units.UnitBuilder.unitBuilder;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 29/05/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class NoEventTest {
    private final Event noEvent = new NoEvent();
    private static final Unit UNUSED_UNIT = null;

    @Test
    public void canHaveEventForNotEventShouldReturnTrue() throws Exception {
        // given
        final Unit unit = unitBuilder().build();

        // when
        final boolean result = noEvent.canHaveEvent(unit);

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void makeItHappenShouldReturnNothingHappenMessage() throws Exception {

        // when
        final String message = noEvent.makeItHappen(UNUSED_UNIT, UNUSED_UNIT);

        // then
        assertThat(message).isEqualTo("Another round, where nothing seems to happen.");
    }


}