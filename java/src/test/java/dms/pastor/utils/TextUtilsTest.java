package dms.pastor.utils;

import dms.pastor.domain.exception.SomethingWentWrongException;
import dms.pastor.utils.randoms.RandomDataGenerator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static dms.pastor.TestConfig.PATH;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TextUtilsTest {
    private static final String FILE_PATH = PATH + "test/test.txt";


    @Test
    public void countWordInTextInFileShouldThrowSomethingWentWrongExceptionIfAnyExceptionIsThrownDuringCounting() {
        // when
        final var exception = assertThrows(SomethingWentWrongException.class, () -> TextUtils.countWordInTextInFile(null));

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
        final var exception = assertThrows(SomethingWentWrongException.class, () -> TextUtils.getTextInParagraphs(null));

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


    @Test
    public void getWordDependsOnNumberThrowsExceptionIfWordIsNull() {
        // given
        final var count = RandomDataGenerator.randomPositiveInteger();

        // debug
        System.out.println("number: " + count);

        // throws exception when
        assertThrows(IllegalArgumentException.class, () -> TextUtils.getWordIfPlural(null, count));
    }

    @Test
    public void getWordDependsOnNumberThrowsExceptionIfWordIsEmpty() {
        // given
        final var count = RandomDataGenerator.randomPositiveInteger();

        // debug
        System.out.println("number: " + count);

        // throws exception when
        assertThrows(IllegalArgumentException.class, () -> TextUtils.getWordIfPlural(null, count));
    }


    @Test
    public void getWordDependsOnNumberThrowsExceptionIfCountIsNegative() {
        // given
        final var count = RandomDataGenerator.randomNegativeInteger();

        // debug
        System.out.println("number: " + count);

        // throws exception when
        assertThrows(IllegalArgumentException.class, () -> TextUtils.getWordIfPlural("cat", count));
    }


    @Test
    public void getWordDependsOnNumberShouldAddSForRegularNounsForPlural() {
        // given
        final var count = RandomDataGenerator.randomPositiveInteger() + 1;
        final var expectResult = "dogs";

        // debug
        System.out.println("number: " + count);

        // when
        final var result = TextUtils.getWordIfPlural("dog", count);

        // then
        assertThat(result).isEqualTo(expectResult);
    }

    @Test
    public void getWordDependsOnNumberShouldAddEsForRegularNounsForPlural() {
        // given
        final var count = RandomDataGenerator.randomPositiveInteger() + 1;
        final var expectResult = "buses";

        // debug
        System.out.println("number: " + count);

        // when
        final var result = TextUtils.getWordIfPlural("bus", count);

        // then
        assertThat(result).isEqualTo(expectResult);
    }

    @Test
    public void getWordDependsOnNumberShouldIfAddEsIfPlural() {
        // given
        final var count = RandomDataGenerator.randomPositiveInteger() + 1;
        final var expectResult = "potatoes";

        // debug
        System.out.println("number: " + count);

        // when
        final var result = TextUtils.getWordIfPlural("potato", count);

        // then
        assertThat(result).isEqualTo(expectResult);
    }


    @Test
    public void getWordDependsOnNumberShouldAddEsIfWordEndWithIsIfPlural() {
        // given
        final var count = RandomDataGenerator.randomPositiveInteger() + 1;
        final var expectResult = "analyses";

        // debug
        System.out.println("number: " + count);

        // when
        final var result = TextUtils.getWordIfPlural("analysis", count);

        // then
        assertThat(result).isEqualTo(expectResult);
    }

    @Test //fixed bug to ensure that plural for station is stations
    public void getWordDependsOnNumberShouldReturnStationsForStation() {
        // given
        final var count = RandomDataGenerator.randomPositiveInteger() + 1;
        final var expectResult = "stations";

        // debug
        System.out.println("number: " + count);

        // when
        final var result = TextUtils.getWordIfPlural("station", count);

        // then
        assertThat(result).isEqualTo(expectResult);
    }

    @Test
    public void getWordDependsOnNumberShouldAddAIfWordEndWithOnIfPlural() {
        // given
        final var count = RandomDataGenerator.randomPositiveInteger() + 1;
        final var expectResult = "phenomena";

        // debug
        System.out.println("number: " + count);

        // when
        final var result = TextUtils.getWordIfPlural("phenomenon", count);

        // then
        assertThat(result).isEqualTo(expectResult);
    }

    @Test
    public void getWordDependsOnNumberReturnChildrenForChildIfPlural() {
        // given
        final var count = RandomDataGenerator.randomPositiveInteger() + 1;
        final var expectedResult = "children";

        // when
        final var result = TextUtils.getWordIfPlural("child", count);

        // then
        assertThat(result).isEqualTo(expectedResult);

    }


    @Test
    public void getWordDependsOnNumberReturnPeopleForPersonIfPlural() {
        // given
        final var count = RandomDataGenerator.randomPositiveInteger() + 1;
        final var expectedResult = "people";

        // when
        final var result = TextUtils.getWordIfPlural("person", count);

        // then
        assertThat(result).isEqualTo(expectedResult);

    }

    @Test
    public void getWordDependsOnNumberReturnWomenForWomanIfPlural() {
        // given
        final var count = RandomDataGenerator.randomPositiveInteger() + 1;
        final var expectedResult = "women";

        // when
        final var result = TextUtils.getWordIfPlural("woman", count);

        // then
        assertThat(result).isEqualTo(expectedResult);

    }


    @Test
    public void getWordDependsOnNumberShouldReturnSameWordNounsDontChangeWhenPluralized() {
        // given
        final var words = Arrays.asList("sheep", "series", "species", "deer","station");

        // when & then
        words.forEach(word -> assertThat(TextUtils.getWordIfPlural(word, 1)).isEqualTo(word));
    }


    @Test
    public void getWordDependsOnNumberShouldReturnSameWordForSingularForm() {
        // given
        final var words = Arrays.asList("cat", "dog", "truss", "bus", "lunch", "potato", "analysis");

        // when & then
        words.forEach(word -> assertThat(TextUtils.getWordIfPlural(word, 1)).isEqualTo(word));
    }

}
