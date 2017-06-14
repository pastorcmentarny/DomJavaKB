package dms.pastor.tools.coder;

import dms.pastor.domain.exception.SomethingWentTerribleWrongError;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class CodecAppRunnerTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldThrowSomethingWentWrongErrorIfInputIsNull() throws Exception {
        // except
        exception.expect(SomethingWentTerribleWrongError.class);

        // when
        CodecAppRunner.main(null);
    }

    @Test
    public void shouldThrowSomethingWentWrongErrorIfHasTooManyArgumentsIsNull() throws Exception {
        // except
        exception.expect(SomethingWentTerribleWrongError.class);

        // when
        CodecAppRunner.main(new String[]{"e", "E"});
    }

    @Test
    public void shouldThrowSomethingWentWrongErrorIfArgumentsDoesNotMatchTaskName() throws Exception {
        // except
        exception.expect(SomethingWentTerribleWrongError.class);

        // when
        CodecAppRunner.main(new String[]{"ee"});
    }

    @Test
    public void shouldDisplayEncodedMessageReadFromFile() throws Exception {

        // when
        CodecAppRunner.main(new String[]{"e"});
    }

    @Test
    public void shouldDisplayDecodedMessageReadFromFile() throws Exception {

        // when
        CodecAppRunner.main(new String[]{"d"});
    }

}