package dms.pastor.tools.readtimer;

import org.junit.Test;

import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
import static dms.pastor.utils.randoms.RandomDataGenerator.randomPositiveInteger;

/**
 * Author Dominik Symonowicz
 * Created 25/12/2016
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
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