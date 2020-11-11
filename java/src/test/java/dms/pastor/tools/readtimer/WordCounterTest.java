package dms.pastor.tools.readtimer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static dms.pastor.TestConfig.MAX_RANDOM_SIZE;
import static dms.pastor.tools.readtimer.WordCounter.countFullWords;
import static dms.pastor.utils.randoms.RandomDataGenerator.*;
import static java.lang.String.valueOf;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 22/03/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class WordCounterTest {


    @Test
    public void countFullWordsShouldThrowExceptionIfWordsIsNull() {
        // when
        final var exception = Assertions.assertThrows(IllegalArgumentException.class, () -> countFullWords(null));

        // then
        assertThat(exception.getMessage()).isEqualTo("Input cannot be null or empty.");

    }

    @Test
    public void countFullWordsShouldThrowExceptionIfWordsIsEmpty() {
        // when
        final var exception = Assertions.assertThrows(IllegalArgumentException.class, () -> countFullWords(new String[0]));

        // then
        assertThat(exception.getMessage()).isEqualTo("Input cannot be null or empty.");
    }

    @Test
    public void fullWordsShouldReturn1ForCollectionOfSingleWordTest() {
        // given
        String[] oneWord = new String[]{"Test"};
        // when
        final int counter = countFullWords(oneWord);

        // then
        assertThat(counter).isEqualTo(1);
    }

    @Test
    public void shouldReturn10WordsForCountFullWordsTest() {
        // given
        int size = 10;
        String[] tenWords = generateArray(size);
        // when
        final int counter = countFullWords(tenWords);

        // then
        assertThat(counter).isEqualTo(size);
    }

    @Test
    public void fullWordsShouldNotCountSpaceAsWordTest() {
        // given
        String[] twoWordsOneSpace = new String[]{"Test", " ", "Test2"};
        // when
        final int counter = countFullWords(twoWordsOneSpace);

        // then
        assertThat(counter).isEqualTo(2);
    }

    @Test
    public void fullWordsShouldNotCountNullAsWordTest() {
        // given
        String[] twoWordsOneNull = new String[]{"Test", null, "Test2"};
        // when
        final int counter = countFullWords(twoWordsOneNull);

        // then
        assertThat(counter).isEqualTo(2);
    }

    @Test
    public void fullWordsShouldCountNumberAsWordTest() {

        // given
        String[] twoWordsOneNumber = new String[]{"Test", valueOf(randomPositiveInteger(MAX_RANDOM_SIZE)), "Test2"};
        // when
        final int counter = countFullWords(twoWordsOneNumber);

        // then
        assertThat(counter).isEqualTo(3);
    }

    @Test
    public void fullWordsShouldNotCountWordThatDoesNotContainAtLeastOneAlphanumericCharacterTest() {
        // given
        String[] twoWordsOneNonAlphanumericWord = new String[]{"Test", generateNonAlphanumericString(MAX_RANDOM_SIZE), "Test2"};
        // when
        final int counter = countFullWords(twoWordsOneNonAlphanumericWord);

        // then
        assertThat(counter).isEqualTo(2);

    }

    @Test
    public void fullWordsShouldReturnSizeForCollectionTest() {
        // given
        String[] manyWord = generateArray(MAX_RANDOM_SIZE);
        // when
        final int counter = countFullWords(manyWord);

        // then
        assertThat(counter).isEqualTo(manyWord.length);
    }

    @Test
    public void countFullWordShouldNotCountStopWords() {
        // given
        final String[] words = {"Dominik", "is", "awesome"};
        // when
        final int counter = countFullWords(words);

        // then
        assertThat(counter).isEqualTo(2);
    }
}