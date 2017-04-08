package dms.pastor.tools.topinyin;

import dms.pastor.domain.exception.SomethingWentWrongException;
import dms.pastor.utils.RandomDataGenerator;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static dms.pastor.tools.topinyin.ToPinyinApplication.main;
import static dms.pastor.utils.RandomDataGenerator.generateString;
import static dms.pastor.utils.RandomDataGenerator.randomInteger;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 28/12/2016
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class ToPinyinApplicationTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream original = System.out;
    private static final String TEXT_INVALID_MESSAGE = "Text cannot be null or empty. It must be at least 2 characters or more.";
    private static final String PSEUDO_PINYIN_TYPE = "character";

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outputStream));
    }

    @After
    public void cleanUpStreams() throws IOException {
        outputStream.close();
        System.setOut(original);
    }


    @Test
    public void shouldThrowExceptionWhenInputArgumentIsNull() throws Exception {
        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Input arguments cannot be null.");

        // when
        main(null);
    }

    @Test
    public void shouldThrowExceptionWhenInputArgumentsHas1Argument() throws Exception {
        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("It should contains 2 arguments (type of pinyin (number,character) and text.");

        // when
        main(new String[]{generateString()});
    }

    @Test
    public void shouldThrowExceptionWhenInputArgumentsHasMoreThan2Arguments() throws Exception {
        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("It should contains 2 arguments (type of pinyin (number,character) and text.");

        // given
        String[] arguments = RandomDataGenerator.generateArray(3 + randomInteger(32));

        // when
        main(arguments);
    }

    @Test
    public void shouldThrowSomethingWentWrongExceptionWhenFirstArgumentIsNotValidConverterType() throws Exception {
        // except
        exception.expect(SomethingWentWrongException.class);
        exception.expectMessage("Whoops! Something went wrong. Invalid conversation type(can be: number,character). I apologize for any inconvenience caused by your mistake.");

        // given
        String[] arguments = new String[]{generateString(), generateString()};

        // when
        main(arguments);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenTextIsNull() throws Exception {
        // except
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(TEXT_INVALID_MESSAGE);

        // given
        String[] arguments = new String[]{PSEUDO_PINYIN_TYPE, null};

        // when
        main(arguments);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenTextIsEmpty() throws Exception {
        // except
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(TEXT_INVALID_MESSAGE);

        // given
        String[] arguments = new String[]{PSEUDO_PINYIN_TYPE, ""};

        // when
        main(arguments);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenTextHasLessThan2Characters() throws Exception {
        // except
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(TEXT_INVALID_MESSAGE);

        // given
        String[] arguments = new String[]{PSEUDO_PINYIN_TYPE, " "};

        // when
        main(arguments);
    }

    @Test
    public void shouldDisplayPinyinForMaWIthSecondToneAcceptanceTest() throws Exception {
        // given
        final String[] arguments = new String[]{"number", "ma(2)"};
        final String expected = "má\r\n";

        // when
        main(arguments);

        // then
        assertThat(outputStream.toString()).isEqualTo(expected);
    }
}
