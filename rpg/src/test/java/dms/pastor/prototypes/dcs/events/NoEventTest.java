package dms.pastor.prototypes.dcs.events;

import dms.pastor.prototypes.dcs.conditions.ElementTypeTest;
import dms.pastor.prototypes.dcs.units.Unit;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static dms.pastor.prototypes.dcs.units.enemies.builders.UnitBuilder.unitBuilder;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 29/05/2017
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class NoEventTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ElementTypeTest.class);
    private static final Unit UNUSED_UNIT = null;
    private final Event noEvent = new NoEvent();

    @Test
    public void canHaveEventForNotEventShouldReturnTrue() {
        // given
        final Unit unit = unitBuilder().build();
        // when
        final boolean result = noEvent.canHaveEvent(unit);

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void makeItHappenShouldReturnNothingHappenMessage() {
        // when
        final String message = noEvent.makeItHappen(UNUSED_UNIT, UNUSED_UNIT);

        // then
        assertThat(message).isNotBlank();

        // debug info
        LOGGER.info("Description generated:" + message);
    }

}