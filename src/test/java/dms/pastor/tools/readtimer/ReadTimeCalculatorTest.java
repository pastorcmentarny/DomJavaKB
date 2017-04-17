package dms.pastor.tools.readtimer;

import dms.pastor.test.rules.Repeat;
import dms.pastor.test.rules.RepeaterRule;
import dms.pastor.utils.randoms.RandomDataGenerator;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Random;

import static dms.pastor.tools.readtimer.ReadSpeed.ADULT_AVERAGE;
import static dms.pastor.utils.DateUtils.HOUR;
import static dms.pastor.utils.DateUtils.MINUTE;
import static dms.pastor.utils.randoms.RandomDataGenerator.*;
import static java.lang.Integer.MAX_VALUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 06/04/2016
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class ReadTimeCalculatorTest {

    private static final int REPEAT_TEST_TIMES = 10;
    private final Random random = new Random();

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Rule
    public RepeaterRule repeater = RepeaterRule.use();

    private ReadTimeCalculator readTimeCalculator;

    @Before
    public void setUp() throws Exception {
        readTimeCalculator = new ReadTimeCalculator(generateRandomParagraph(), ADULT_AVERAGE.speed());
    }

    @Test
    public void acceptanceCriteria() throws Exception {

        // when
        final String text = readTimeCalculator.displayTimeNeededToRead();

        // then
        assertThat(text).contains("second");
        assertThat(text).contains("to read.");
        System.out.println(text);
    }

    @Test
    public void shouldReturnIllegalArgumentExceptionForNullInputTest() throws Exception {
        //given
        readTimeCalculator = new ReadTimeCalculator(null, randomInteger());

        // except
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("It must contain not empty text with size bigger than 1 character");

        // when
        readTimeCalculator.calculateTimeNeedToReadFor();
    }

    @Test
    public void shouldReturnIllegalArgumentExceptionForZeroWordPerMinutes() throws Exception {
        //given
        readTimeCalculator = new ReadTimeCalculator(generateString(), randomNegativeInteger());

        // except
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Speed of reading must be equal or higher than 60  words per minute");

        // when
        readTimeCalculator.calculateTimeNeedToReadFor();
    }

    //name of this test is shocking , i know :)
    @Test
    @Repeat(times = REPEAT_TEST_TIMES)
    //check for few random values, this is used as part of learning using own Rule(check RepeaterRule class)
    public void shouldThrowIllegalArgumentExceptionForTooSlowReadingTest() throws Exception {
        // given
        int lessThan60WordsPerMinutes = randomNegativeInteger() + 59;
        readTimeCalculator = new ReadTimeCalculator(generateRandomParagraph(), lessThan60WordsPerMinutes);

        // except
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Speed of reading must be equal or higher than 60  words per minute");

        // when
        readTimeCalculator.calculateTimeNeedToReadFor();

    }

    @Test
    public void itShouldTake6SecondToRead60WordsWithSpeed1WordPerSecondTest() throws Exception {
        // given
        String sentence = "This is an test example sentence.";
        readTimeCalculator = new ReadTimeCalculator(sentence, 60);

        // when
        final int wordPerMinute = readTimeCalculator.calculateTimeNeedToReadFor();

        // then
        assertThat(wordPerMinute, is(6));
    }

    @Test
    public void shouldReadOneWordPerSecond() throws Exception {
        // given
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < 60; i++) {
            stringBuilder.append("Word").append(i + 1).append(' ');
        }
        String sentence = stringBuilder.append('.').toString();
        readTimeCalculator = new ReadTimeCalculator(sentence, 60);

        // when
        final int wordPerMinute = readTimeCalculator.calculateTimeNeedToReadFor();

        // then
        assertThat(wordPerMinute, is(60));
    }


    //running test few time for various negative numbers
    @Test
    @Repeat(times = REPEAT_TEST_TIMES)
    public void shouldDisplayEmptyStringForDisplayTimeNeededToReadWhenTimeIsInvalidTest() throws Exception {
        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Speed of reading must be equal or higher than 60  words per minute");

        // given
        readTimeCalculator = new ReadTimeCalculator(generateRandomParagraph(), RandomDataGenerator.randomNegativeInteger());

        // when
        readTimeCalculator.displayTimeNeededToRead();
    }

    @Test
    public void shouldReturn59SecondsTest() throws Exception {
        // given
        readTimeCalculator = new ReadTimeCalculator(generateWords(59), MINUTE);

        // when
        final String result = readTimeCalculator.displayTimeNeededToRead();

        // then
        final String expected = "59 seconds to read.";
        assertThat(result, is(expected));
    }

    @Test
    public void shouldReturn1MinuteTest() throws Exception {
        // given
        readTimeCalculator = new ReadTimeCalculator(generateWords(60), MINUTE);

        // when
        final String result = readTimeCalculator.displayTimeNeededToRead();

        // then
        final String expected = "1 minute to read.";
        assertThat(result, is(expected));
    }

    @Test
    public void shouldReturn1MinuteAnd1SecondTest() throws Exception {
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
    public void shouldReturn1HourTest() throws Exception {
        // given
        readTimeCalculator = new ReadTimeCalculator(generateWords(HOUR), MINUTE);

        // when
        final String result = readTimeCalculator.displayTimeNeededToRead();

        // then
        final String expected = "1 hour to read.";
        assertThat(result, is(expected));
    }

    @Test
    public void shouldReturn1Hour1MinuteAnd1SecondTest() throws Exception {
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
    public void shouldReturn1HourAnd1SecondTest() throws Exception {
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
    public void shouldReturn6Hours6MinutesAnd6SecondsTest() throws Exception {
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
    public void shouldDisplayTimeNeededToReadTest() throws Exception {
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
