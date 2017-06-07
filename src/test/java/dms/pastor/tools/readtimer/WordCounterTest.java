package dms.pastor.tools.readtimer;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

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
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class WordCounterTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void countFullWordsShouldThrowExceptionIfWordsIsNull() throws Exception {
        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Input can not be null or empty.");

        // when
        countFullWords(null);

    }

    @Test
    public void countFullWordsShouldThrowExceptionIfWordsIsEmpty() throws Exception {
        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Input can not be null or empty.");

        // when
        countFullWords(new String[0]);
    }

    @Test
    public void fullWordsShouldReturn1ForCollectionOfSingleWordTest() throws Exception {
        // given
        String[] oneWord = new String[]{"Test"};

        // when
        final int counter = countFullWords(oneWord);

        // then
        assertThat(counter).isEqualTo(1);
    }

    @Test
    public void shouldReturn10WordsForCountFullWordsTest() throws Exception {
        // given
        int size = 10;
        String[] tenWords = generateArray(size);

        // when
        final int counter = countFullWords(tenWords);

        // then
        assertThat(counter).isEqualTo(size);
    }

    @Test
    public void fullWordsShouldNotCountSpaceAsWordTest() throws Exception {
        // given
        String[] twoWordsOneSpace = new String[]{"Test", " ", "Test2"};

        // when
        final int counter = countFullWords(twoWordsOneSpace);

        // then
        assertThat(counter).isEqualTo(2);
    }

    @Test
    public void fullWordsShouldNotCountNullAsWordTest() throws Exception {
        // given
        String[] twoWordsOneNull = new String[]{"Test", null, "Test2"};

        // when
        final int counter = countFullWords(twoWordsOneNull);

        // then
        assertThat(counter).isEqualTo(2);
    }

    @Test
    public void fullWordsShouldCountNumberAsWordTest() throws Exception {

        // given
        String[] twoWordsOneNumber = new String[]{"Test", valueOf(randomPositiveInteger(MAX_RANDOM_SIZE)), "Test2"};

        // when
        final int counter = countFullWords(twoWordsOneNumber);

        // then
        assertThat(counter).isEqualTo(3);
    }

    @Test
    public void fullWordsShouldNotCountWordThatDoesNotContainAtLeastOneAlphanumericCharacterTest() throws Exception {
        // given
        String[] twoWordsOneNonAlphanumericWord = new String[]{"Test", generateNonAlphanumericString(MAX_RANDOM_SIZE), "Test2"};

        // when
        final int counter = countFullWords(twoWordsOneNonAlphanumericWord);

        // then
        assertThat(counter).isEqualTo(2);

    }

    @Test
    public void fullWordsShouldReturnSizeForCollectionTest() throws Exception {
        // given
        String[] manyWord = generateArray(MAX_RANDOM_SIZE);

        // when
        final int counter = countFullWords(manyWord);

        // then
        assertThat(counter).isEqualTo(manyWord.length);
    }

    @Test
    public void countFullWordShouldNotCountStopWords() throws Exception {
        // given
        final String[] words = {"Dominik", "is", "awesome"};

        // when
        final int counter = countFullWords(words);

        // then
        assertThat(counter).isEqualTo(2);
    }
}