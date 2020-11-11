package dms.pastor.tools.readtimer;

import dms.pastor.test.rules.Repeat;
import dms.pastor.test.rules.RepeaterRule;
import dms.pastor.utils.StringUtils;
import dms.pastor.utils.randoms.RandomDataGenerator;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static dms.pastor.tools.readtimer.ReadSpeed.ADULT_AVERAGE;
import static dms.pastor.utils.DateUtils.HOUR;
import static dms.pastor.utils.DateUtils.MINUTE;
import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static dms.pastor.utils.randoms.RandomDataGenerator.*;
import static java.lang.Integer.MAX_VALUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 06/04/2016
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class ReadTimeCalculatorTest {

    private static final int REPEAT_TEST_TIMES = 10;
    private static final int ONE_WORD_PER_SECOND = 60;
    private static final String ERROR_READING_SPEED_EQUAL_OR_HIGHER = "Speed of reading must be equal or higher than 60  words per minute";

    private final Random random = new Random();

    @Rule
    public RepeaterRule repeater = RepeaterRule.use();

    private ReadTimeCalculator readTimeCalculator;

    @BeforeEach
    public void setUp() {
        readTimeCalculator = new ReadTimeCalculator(generateRandomParagraph(), ADULT_AVERAGE.speed());
    }

    @Test
    public void acceptanceCriteria() {
        // when
        final String text = readTimeCalculator.displayTimeNeededToRead();

        // then
        assertThat(text).contains("second");
        assertThat(text).contains("to read.");
        System.out.println(text);
    }

    @Test
    public void shouldReturnIllegalArgumentExceptionForNullInputTest() {
        // given
        readTimeCalculator = new ReadTimeCalculator(null, randomInteger());
        // when
        final var exception = Assertions.assertThrows(IllegalArgumentException.class, () -> readTimeCalculator.calculateTimeNeedToReadFor());

        // then
        assertThat(exception.getMessage()).isEqualTo("It must contain not empty text with size bigger than 1 character");
    }

    @Test
    public void shouldReturnIllegalArgumentExceptionForZeroWordPerMinutes() {
        // given
        readTimeCalculator = new ReadTimeCalculator(generateString(), randomNegativeInteger());
        // when
        final var exception = Assertions.assertThrows(IllegalArgumentException.class, () -> readTimeCalculator.calculateTimeNeedToReadFor());

        // then
        assertThat(exception.getMessage()).isEqualTo(ERROR_READING_SPEED_EQUAL_OR_HIGHER);
    }

    //name of this test is shocking , i know :)
    @Test
    @Repeat(times = REPEAT_TEST_TIMES)
    //check for few random values, this is used as part of learning using own Rule(check RepeaterRule class)
    public void shouldThrowIllegalArgumentExceptionForTooSlowReadingTest() {
        // given
        int lessThan60WordsPerMinutes = randomNegativeInteger() + 59;
        readTimeCalculator = new ReadTimeCalculator(generateRandomParagraph(), lessThan60WordsPerMinutes);
        // when
        final var exception = Assertions.assertThrows(IllegalArgumentException.class, () -> readTimeCalculator.calculateTimeNeedToReadFor());

        // then
        assertThat(exception.getMessage()).isEqualTo(ERROR_READING_SPEED_EQUAL_OR_HIGHER);
    }

    @Test
    public void itShouldTake6SecondToRead60WordsWithSpeed1WordPerSecondTest() {
        // given
        String sentence = "one two three four five six.";
        readTimeCalculator = new ReadTimeCalculator(sentence, ONE_WORD_PER_SECOND);
        // when
        final int wordPerMinute = readTimeCalculator.calculateTimeNeedToReadFor();

        // then
        assertThat(wordPerMinute).isEqualTo(6);
    }

    @Test
    public void shouldReadOneWordPerSecond() {
        // given
        StringBuilder stringBuilder = new StringBuilder(EMPTY_STRING);
        for (int i = 0; i < 60; i++) {
            stringBuilder.append("Word").append(i + 1).append(StringUtils.WHITESPACE_CHAR);
        }
        String sentence = stringBuilder.append('.').toString();
        readTimeCalculator = new ReadTimeCalculator(sentence, ONE_WORD_PER_SECOND);
        // when
        final int wordPerMinute = readTimeCalculator.calculateTimeNeedToReadFor();

        // then
        assertThat(wordPerMinute, is(ONE_WORD_PER_SECOND));
    }


    @Test //running test few time for various negative numbers
    @Repeat(times = REPEAT_TEST_TIMES)
    public void shouldDisplayEmptyStringForDisplayTimeNeededToReadWhenTimeIsInvalidTest() {

        // given
        readTimeCalculator = new ReadTimeCalculator(generateRandomParagraph(), RandomDataGenerator.randomNegativeInteger());
        // when
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            readTimeCalculator.displayTimeNeededToRead();
        });

    }

    @Test
    public void shouldReturn59SecondsTest() {
        // given
        readTimeCalculator = new ReadTimeCalculator(generateWords(59), MINUTE);
        // when
        final String result = readTimeCalculator.displayTimeNeededToRead();

        // then
        final String expected = "59 seconds to read.";
        assertThat(result, is(expected));
    }

    @Test
    public void shouldReturn1MinuteTest() {
        // given
        readTimeCalculator = new ReadTimeCalculator(generateWords(60), MINUTE);
        // when
        final String result = readTimeCalculator.displayTimeNeededToRead();

        // then
        final String expected = "1 minute to read.";
        assertThat(result, is(expected));
    }

    @Test
    public void shouldReturn1MinuteAnd1SecondTest() {
        // given
        int minuteAndOneSecond = MINUTE + 1;
        readTimeCalculator = new ReadTimeCalculator(generateWords(minuteAndOneSecond), MINUTE);
        // when
        final String result = readTimeCalculator.displayTimeNeededToRead();

        // then
        final String expected = "1 minute and 1 second to read.";
        assertThat(result, is(expected));
    }

    @Test
    public void shouldReturn1HourTest() {
        // given
        readTimeCalculator = new ReadTimeCalculator(generateWords(HOUR), MINUTE);
        // when
        final String result = readTimeCalculator.displayTimeNeededToRead();

        // then
        final String expected = "1 hour to read.";
        assertThat(result, is(expected));
    }

    @Test
    public void shouldReturn1Hour1MinuteAnd1SecondTest() {
        // given
        int hourMinuteAndOneSecond = HOUR + MINUTE + 1;
        readTimeCalculator = new ReadTimeCalculator(generateWords(hourMinuteAndOneSecond), MINUTE);
        // when
        final String result = readTimeCalculator.displayTimeNeededToRead();

        // then
        final String expected = "1 hour, 1 minute and 1 second to read.";
        assertThat(result, is(expected));
    }

    @Test
    public void shouldReturn1HourAnd1SecondTest() {
        // given
        int hourAndOneSecond = HOUR + 1;
        readTimeCalculator = new ReadTimeCalculator(generateWords(hourAndOneSecond), MINUTE);
        // when
        final String result = readTimeCalculator.displayTimeNeededToRead();

        // then
        final String expected = "1 hour and 1 second to read.";
        assertThat(result, is(expected));
    }

    @Test
    public void shouldReturn6Hours6MinutesAnd6SecondsTest() {
        // given
        int minuteAndOneSecond = 6 * HOUR + 6 * MINUTE + 6;
        readTimeCalculator = new ReadTimeCalculator(generateWords(minuteAndOneSecond), MINUTE);
        // when
        final String result = readTimeCalculator.displayTimeNeededToRead();

        // then
        final String expected = "6 hours, 6 minutes and 6 seconds to read.";
        assertThat(result, is(expected));
    }

    @Test
    public void shouldDisplayTimeNeededToReadTest() {
        // given
        int randomTime = random.nextInt(MAX_VALUE);
        readTimeCalculator = new ReadTimeCalculator(generateRandomParagraph(), randomTime);
        // when
        final String result = readTimeCalculator.displayTimeNeededToRead();

        // then
        System.out.println(result);
        assertThat(result).isNotEmpty();
    }

}
