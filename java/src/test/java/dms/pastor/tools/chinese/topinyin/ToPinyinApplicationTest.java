package dms.pastor.tools.chinese.topinyin;

import dms.pastor.domain.exception.SomethingWentWrongException;
import dms.pastor.utils.randoms.RandomDataGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static dms.pastor.tools.chinese.topinyin.ToPinyinApplication.main;
import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static dms.pastor.utils.StringUtils.WHITESPACE;
import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
import static dms.pastor.utils.randoms.RandomDataGenerator.randomPositiveInteger;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Author Dominik Symonowicz
 * Created 28/12/2016
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
// auto closable not essential
public class ToPinyinApplicationTest {

    private static final String TEXT_INVALID_MESSAGE = "Text cannot be null or empty. It must be at least 2 characters or more.";
    private static final String PSEUDO_PINYIN_TYPE = "character";

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream original = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void cleanUpStreams() throws IOException {
        outputStream.close();
        System.setOut(original);
    }

    @Test
    public void shouldThrowExceptionWhenInputArgumentIsNull() {
        // when
        final var exception = assertThrows(IllegalArgumentException.class, () -> main(null));

        // when
        assertThat(exception.getMessage()).isEqualTo("Input arguments cannot be null.");
    }

    @Test
    public void shouldThrowExceptionWhenInputArgumentsHas1Argument() {
        // when
        final var exception = assertThrows(IllegalArgumentException.class, () -> main(new String[]{generateString()}));

        // then
        assertThat(exception.getMessage()).isEqualTo("It should contains 2 arguments (type of pinyin (number,character) and text.");
    }

    @Test
    public void shouldThrowExceptionWhenInputArgumentsHasMoreThan2Arguments() {
        // given
        String[] arguments = RandomDataGenerator.generateArray(3 + randomPositiveInteger(32));

        // when
        final var exception = assertThrows(IllegalArgumentException.class, () -> main(arguments));

        // then
        assertThat(exception.getMessage()).isEqualTo("It should contains 2 arguments (type of pinyin (number,character) and text.");
    }

    @Test
    public void shouldThrowSomethingWentWrongExceptionWhenFirstArgumentIsNotValidConverterType() {

        // given
        String[] arguments = new String[]{generateString(), generateString()};

        // when
        final var exception = assertThrows(SomethingWentWrongException.class, () -> main(arguments));

        // then
        assertThat(exception.getMessage()).isEqualTo("Whoops! Something went wrong. Invalid conversation type(can be: number,character). I apologize for any inconvenience caused by your mistake.");
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenTextIsNull() {

        // given
        String[] arguments = new String[]{PSEUDO_PINYIN_TYPE, null};

        // when
        final var exception = assertThrows(IllegalArgumentException.class, () -> main(arguments));

        // then
        assertThat(exception.getMessage()).isEqualTo(TEXT_INVALID_MESSAGE);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenTextIsEmpty() {
        // given
        String[] arguments = new String[]{PSEUDO_PINYIN_TYPE, EMPTY_STRING};

        // when
        final var exception = assertThrows(IllegalArgumentException.class, () -> main(arguments));

        assertThat(exception.getMessage()).isEqualTo(TEXT_INVALID_MESSAGE);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenTextHasLessThan2Characters() {

        // given
        String[] arguments = new String[]{PSEUDO_PINYIN_TYPE, WHITESPACE};

        // when
        final var exception = assertThrows(IllegalArgumentException.class, () -> main(arguments));

        // then
        assertThat(exception.getMessage()).isEqualTo(TEXT_INVALID_MESSAGE);
    }

    @Test
    public void shouldDisplayPinyinForMaWIthSecondToneAcceptanceTest() {
        // given
        final String[] arguments = new String[]{"number", "ma(2)"};
        final String expected = "má" + System.lineSeparator();

        // when
        main(arguments);

        // then
        assertThat(outputStream.toString()).isEqualTo(expected);
    }
}
