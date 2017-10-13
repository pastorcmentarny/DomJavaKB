package dms.pastor.tools.coder;

import dms.pastor.domain.exception.SomethingWentTerribleWrongError;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.File;

import static java.io.File.separator;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class CodecAppRunnerTest {
    private static final String PATH = "src" + separator + "main" + separator + "resources" + separator + "input.txt";

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Before
    public void setUp() throws Exception {
        new File(PATH).createNewFile();
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @After
    public void tearDown() throws Exception {
        new File(PATH).delete();
    }

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