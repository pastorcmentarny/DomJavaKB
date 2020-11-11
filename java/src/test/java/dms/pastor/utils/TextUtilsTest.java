package dms.pastor.utils;

import dms.pastor.domain.exception.SomethingWentWrongException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static dms.pastor.TestConfig.PATH;
import static org.assertj.core.api.Assertions.assertThat;

public class TextUtilsTest {
    private static final String FILE_PATH = PATH + "test/test.txt";



    @Test
    public void countWordInTextInFileShouldThrowSomethingWentWrongExceptionIfAnyExceptionIsThrownDuringCounting() {
        // when
        final var exception = Assertions.assertThrows(SomethingWentWrongException.class, () -> TextUtils.countWordInTextInFile(null));

        // then
        assertThat(exception.getMessage()).isEqualTo("Whoops! Something went wrong. Unable to count word due null. I apologize for any inconvenience caused by your mistake.");
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
        // when
        final var exception = Assertions.assertThrows(SomethingWentWrongException.class, () -> TextUtils.getTextInParagraphs(null));

        // then
        assertThat(exception.getMessage()).isEqualTo("Whoops! Something went wrong. Unable to count word due null. I apologize for any inconvenience caused by your mistake.");
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
