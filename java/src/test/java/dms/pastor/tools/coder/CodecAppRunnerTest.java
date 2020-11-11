package dms.pastor.tools.coder;

import dms.pastor.domain.exception.SomethingWentTerribleWrongError;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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


    @SuppressWarnings("ResultOfMethodCallIgnored")
    @BeforeEach
    public void setUp() throws Exception {
        new File(PATH).createNewFile();
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @AfterEach
    public void tearDown() {
        new File(PATH).delete();
    }

    @Test
    public void shouldThrowSomethingWentWrongErrorIfInputIsNull() {
        // when
        Assertions.assertThrows(SomethingWentTerribleWrongError.class, () -> CodecAppRunner.main(null));

    }

    @Test
    public void shouldThrowSomethingWentWrongErrorIfHasTooManyArgumentsIsNull() {
        // when
        Assertions.assertThrows(SomethingWentTerribleWrongError.class, () -> CodecAppRunner.main(new String[]{"e", "E"}));

    }

    @Test
    public void shouldThrowSomethingWentWrongErrorIfArgumentsDoesNotMatchTaskName() {
        // when
        Assertions.assertThrows(SomethingWentTerribleWrongError.class, () -> CodecAppRunner.main(new String[]{"ee"}));
    }

    @Test
    public void shouldDisplayEncodedMessageReadFromFile() {
        // when
        CodecAppRunner.main(new String[]{"e"});
    }

    @Test
    public void shouldDisplayDecodedMessageReadFromFile() {
        // when
        CodecAppRunner.main(new String[]{"d"});
    }

}