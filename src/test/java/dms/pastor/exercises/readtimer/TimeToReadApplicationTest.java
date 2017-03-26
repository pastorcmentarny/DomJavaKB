package dms.pastor.exercises.readtimer;

import org.junit.Test;

import static dms.pastor.utils.RandomDataGenerator.generateString;
import static dms.pastor.utils.RandomDataGenerator.randomPositiveInteger;

/**
 * Author Dominik Symonowicz
 * Created 25/12/2016
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class TimeToReadApplicationTest {

    //TODO
    @Test
    public void shouldRunDemoWhenRunningWithoutArgumentsAcceptanceTest() throws Exception {
        // given
        final String[] args = {generateString(), String.valueOf(randomPositiveInteger())};

        // when
        TimeToReadApplication.main(args);

        // then check for is result appear in logs
    }

}