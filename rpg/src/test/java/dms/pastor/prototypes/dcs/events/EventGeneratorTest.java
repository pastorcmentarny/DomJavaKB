package dms.pastor.prototypes.dcs.events;

import org.junit.jupiter.api.Test;

import static dms.pastor.prototypes.dcs.events.EventGenerator.getRandomEvent;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 29/05/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class EventGeneratorTest {

    @Test
    public void eventShouldReturnAnEvent() {
        // when
        final Event randomEvent = getRandomEvent();

        // then
        assertThat(randomEvent).isNotNull();
    }

}