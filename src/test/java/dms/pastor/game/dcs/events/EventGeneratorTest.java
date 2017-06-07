package dms.pastor.game.dcs.events;

import org.junit.Test;

import static dms.pastor.game.dcs.events.EventGenerator.getRandomEvent;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 29/05/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class EventGeneratorTest {

    @Test
    public void eventShouldReturnAnEvent() throws Exception {
        // when
        final Event randomEvent = getRandomEvent();

        // then
        assertThat(randomEvent).isNotNull();
    }

    @Test
    public void generateEventShouldReturnEventOrNoEvent() {
        // given

        // when

        // then

    }
}