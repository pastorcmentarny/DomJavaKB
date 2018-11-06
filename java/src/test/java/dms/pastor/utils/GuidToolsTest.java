package dms.pastor.utils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Pattern;

import static dms.pastor.utils.RegexConstants.GUID_REGEX;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class GuidToolsTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(GuidToolsTest.class);
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private PrintStream printStream;

    @Test // actually used to generate guid for DLC app
    public void shouldGenerateGuid() {
        // when
        final String guid = GuidTools.generateGuid();

        // debug
        LOGGER.info("Generated GUID: " + guid);

        // then
        assertThat(guid).isNotEmpty();
        assertThat(guid).hasSize(36);
    }

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
        GuidTools.main(numberOfGuidsToGenerate);

        // then
        final String[] output = outputStream.toString().split(System.lineSeparator());
        final String lastLog = output[output.length - 1];
        assertThat(lastLog).matches(Pattern.compile(GUID_REGEX));
    }
}