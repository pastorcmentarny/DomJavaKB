package dms.pastor.tools;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Pattern;

import static dms.pastor.utils.RegexUtils.GUID_REGEX;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
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

    @BeforeEach
    public void setUp() {
        printStream = System.out;
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
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


    @Test
    public void generateGuidWithoutDashAcceptanceTest() {
        // when
        final String result = GuidTools.generateGuidWithoutDash();

        // debug
        System.out.println(result);

        // then
        assertThat(result).isNotEmpty();
        assertThat(result).hasSize(32);
    }

    @Test
    public void generateShortGuidAcceptanceTest() {
        // when
        final String result = GuidTools.generateShortGuid();

        // debug
        System.out.println(result);

        // then
        assertThat(result).isNotEmpty();
        assertThat(result).hasSize(8);
    }

}