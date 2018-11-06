package dms.pastor.utils;

import dms.pastor.domain.exception.SomethingWentWrongException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

import static dms.pastor.TestConfig.PATH;
import static org.assertj.core.api.Assertions.assertThat;

public class TextUtilsTest {
    private static final String FILE_PATH = PATH + "test.txt";

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void countWordInTextInFileShouldThrowSomethingWentWrongExceptionIfAnyExceptionIsThrownDuringCounting() {
        // expect
        exception.expect(SomethingWentWrongException.class);
        exception.expectMessage("Unable to count word due null");

        // when
        TextUtils.countWordInTextInFile(null);
    }

    @Test
    public void countWordInTextInFileShouldReturn8Words() {
        // when
        final long result = TextUtils.countWordInTextInFile(FILE_PATH);

        // then
        assertThat(result).isEqualTo(8);
    }

    @Test
    public void getTextInParagraphShouldThrowSomethingWentWrongExceptionIfAnyExceptionIsThrownDuringCounting() {
        // expect
        exception.expect(SomethingWentWrongException.class);
        exception.expectMessage("Unable to count word due null");

        // when
        TextUtils.getTextInParagraphs(null);
    }

    @Test
    public void getTextInParagraphShouldReturnArrayOfParagraphs() {
        // given
        final String expectedParagraph = "This is a default test file" + System.lineSeparator() + "test" + System.lineSeparator();

        // when
        final List<String> result = TextUtils.getTextInParagraphs(FILE_PATH);

        // then
        assertThat(result).hasSize(2);
        assertThat(result.get(0)).isEqualTo(expectedParagraph);
    }
}
