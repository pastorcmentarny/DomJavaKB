package dms.pastor.domain.exception;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Author Dominik Symonowicz
 * Created 24/02/2017
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class SomethingWentWrongExceptionTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldThrowNotImplementYetExceptionTest() throws Exception {

        // expect
        exception.expect(SomethingWentWrongException.class);

        // when
        throw new SomethingWentWrongException();

    }
}
