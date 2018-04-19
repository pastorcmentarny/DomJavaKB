package dms.pastor.tools.guid;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Pattern;

import static dms.pastor.utils.RegexUtils.GUID_REGEX;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 18/04/2018
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class MultiGuidGeneratorTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private PrintStream printStream;

    @Before
    public void setUp() {
        printStream = System.out;
        System.setOut(new PrintStream(outputStream));
    }

    @After
    public void tearDown() {
        System.setOut(printStream);
    }


    @Test
    public void shouldGenerateGuids() {
        // given
        final String[] numberOfGuidsToGenerate = {"1"};

        // when
        MultiGuidGenerator.main(numberOfGuidsToGenerate);

        // then
        final String[] output = outputStream.toString().split(System.lineSeparator());
        final String lastLog = output[output.length - 1];
        assertThat(lastLog).matches(Pattern.compile(GUID_REGEX));
    }
}