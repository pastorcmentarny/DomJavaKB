package dms.pastor.utils.randoms;

import org.junit.*;
import org.junit.rules.ExpectedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

import static dms.pastor.tools.chinese.pinyin.PinyinUtils.getAllPinyinFromFirstToFourthToneWithoutNeutralTone;
import static dms.pastor.utils.EnglishUtils.isStopWord;
import static dms.pastor.utils.StringUtils.hasNonAlphabetCharactersOnly;
import static dms.pastor.utils.randoms.RandomDataGenerator.*;
import static java.lang.Character.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class RandomDataGeneratorTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(RandomDataGeneratorTest.class);

    private static final int RANDOM_STRING_LENGTH = 1024;
    private static final String SPACE = " ";
    @Rule
    public final ExpectedException exception = ExpectedException.none();
    private final Random random = new Random();
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private PrintStream printStream;

    @Before
    public void setUp() {
        printStream = System.out;
        System.setOut(new PrintStream(outputStream));
    }

    @After
    public void tearDown() {
        System.setOut(printStream);
    }

    @Test
    public void testGenerateRandomIntValues() {
        // given
        int size = 10;

        // when
        int[] intValues = generateRandomIntValues(size);

        // then
        Assert.assertThat(intValues.length, is(size));
    }

    @Test
    public void testGetRandomCharacter() {
        // when
        Character randomCharacter = getRandomCharacterFromAlphabet();

        // then
        Assert.assertThat(isLetter(randomCharacter), is(true));
    }

    @Test
    public void testGetRandomCharacterAsString() {
        // when
        String randomCharacterAsString = getRandomCharacterAsString();

        // then
        Assert.assertThat(isLetter(randomCharacterAsString.charAt(0)), is(true));
    }

    @Test
    public void testGetRandomTextWithoutMaxLength() {
        // when
        final String text = getRandomText();

        // then
        Assert.assertThat("Text dictSize is out of range: " + text.length(), 1 <= text.length() && text.length() <= 1000, is(true));
    }

    @SuppressWarnings("QuestionableName") // because string is valid name
    @Test
    public void shouldGenerateRandomStringOfLengthBetween4And10Test() {
        // when
        final String string = generateString(4, 10);

        // then
        assertThat(string.length()).isGreaterThanOrEqualTo(4);
        assertThat(string.length()).isLessThanOrEqualTo(10);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenMinValueIsHigherThanMinForGenerateStringTest() {
        // except
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Value must be higher than zero and min value must be smaller is larger than max value");
        final int max = random.nextInt(1 + RANDOM_STRING_LENGTH);
        final int min = random.nextInt(1 + RANDOM_STRING_LENGTH) + max;

        // debug info
        LOGGER.info("Generated. Min:" + min + " Max:" + max);

        // when
        generateString(min, max);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionForNegativeMinValueTest() {
        // except
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Value must be higher than zero and min value must be smaller is larger than max value");

        // when
        final int negativeNumber = new BigDecimal(random.nextInt(1 + RANDOM_STRING_LENGTH)).negate().intValue();
        generateString(negativeNumber, 4);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionForNegativeMaxValueTest() {
        // except
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Value must be higher than zero and min value must be smaller is larger than max value");

        // when
        final int negativeNumber = new BigDecimal(random.nextInt(RANDOM_STRING_LENGTH)).negate().intValue();
        generateString(4, negativeNumber);
    }

    @Test
    public void shouldGenerateIntArrayTest() {
        // given
        int size = 10;

        // when
        final int[] intArray = generateIntArray(size, 10);
        // then
        Assert.assertThat(intArray.length, is(size));
        for (int i : intArray) {
            Assert.assertThat(i <= 10 && i >= 0, is(true));
        }
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionForNegativeSizeTest() {
        // except
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Size must be positive value.");

        // when
        generateStringList(-1);
    }

    @SuppressWarnings("QuestionableName") // because string is valid name
    @Test
    public void generateStringShouldReturnStringList() {
        // given
        final int arraySize = 10;

        // when
        final List<String> stringList = generateStringList(arraySize);

        // then
        assertThat(stringList).hasSize(arraySize);
        for (String string : stringList) {
            assertThat(string).isNotEmpty();
        }
    }

    @Test
    public void generateStringListTest() {
        // except
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Size must be positive value.");

        // when
        final List<String> stringList = generateStringList(0);

        // then
        Assert.assertThat(stringList.isEmpty(), is(true));
    }

    @Test
    public void generateStringArrayShouldThrowIllegalArgumentExceptionForNegativeTest() {
        // except
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Size must be positive value.");

        // when
        generateArray(-1);
    }

    @SuppressWarnings("QuestionableName") // because string is valid name
    @Test
    public void generateStringArrayShouldReturnStringArray() {
        // given
        final int arraySize = 10;

        // when
        final String[] strings = generateArray(arraySize);

        // then
        assertThat(strings).hasSize(arraySize);
        for (String string : strings) {
            assertThat(string).isNotEmpty();
        }
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionIfSizeIsBelowZeroTest() {
        // except
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Size of string must be greater than zero");

        // when
        generateNonAlphanumericString(-1);

    }

    @Test
    public void shouldThrowIllegalArgumentExceptionIfSizeIsZeroTest() {
        // except
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Size of string must be greater than zero");

        // when
        generateNonAlphanumericString(0);

    }

    @Test
    public void shouldReturnStringWithNonAlphanumericCharactersTest() {
        // except
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Size of string must be greater than zero");

        // when
        final String result = generateNonAlphanumericString(-1);

        // then
        assertThat(result).isNotNull();
        assertThat(hasNonAlphabetCharactersOnly(result)).isFalse(); //bad testing
    }

    @Test
    public void shouldReturnIntArray() {
        // when
        final int size = 10;
        final int numberRange = 10;
        final int[] ints = generateIntArray(size, numberRange);

        // then
        assertThat(ints).hasSize(size);
    }

    @Test
    public void shouldGenerateStringListTest() {
        // when
        final List<String> stringList = generateStringList();

        // then
        assertThat(stringList).isNotEmpty();
        assertThat(stringList.size()).isGreaterThanOrEqualTo(4);
    }

    @Test
    public void shouldReturnParagraph() {

        // when
        final String result = generateRandomParagraph();

        // then
        assertThat(result).isNotNull();
        assertThat(result.length()).isGreaterThan(10);
        System.out.println(result);

    }

    @Test
    public void randomIntegerWithMinAndMaxValueShouldThrowExceptionWhenMinValueIsHigherThanMaxValue() {
        // given
        int maxValue = randomPositiveInteger(MAX_SMALL_VALUE_RANGE);
        int minValue = maxValue + randomInteger(1, MAX_SMALL_VALUE_RANGE);

        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Value (" + minValue + ") must be lower or equals to than Other Value(" + maxValue + ")");

        // when
        randomInteger(minValue, maxValue);
    }

    @Test
    public void randomIntegerWithMinAndMaxValueShouldReturnValueInRange() {
        // given
        int minValue = randomPositiveInteger(MAX_SMALL_VALUE_RANGE);
        int maxValue = minValue + randomInteger(1, 1 + MAX_SMALL_VALUE_RANGE);

        // when
        final int number = randomInteger(minValue, maxValue);

        // then
        assertThat(number).isBetween(minValue, maxValue);
    }

    @Test
    public void randomIntegerWithEqualMinAndMaxValueShouldReturnThatValue() {
        // given
        int value = randomPositiveInteger(MAX_SMALL_VALUE_RANGE);

        // when
        final int number = randomInteger(value, value);

        // then
        assertThat(number).isEqualTo(value);
    }

    @Test
    public void randomNegativeIntegerShouldReturnNegativeInteger() {

        // when
        final int negativeInteger = randomNegativeInteger();

        // then
        assertThat(negativeInteger).isNegative();

    }

    @Test
    public void generateNonAlphanumericStringShouldGenerateString() {
        // when
        final String nonAlphanumericString = generateNonAlphanumericString(2);

        // then
        final char[] chars = nonAlphanumericString.toCharArray();
        assertThat(isAlphabetic(chars[0])).isFalse();
        assertThat(isAlphabetic(chars[1])).isFalse();
        assertThat(isDigit(chars[0])).isFalse();
        assertThat(isDigit(chars[1])).isFalse();
    }

    @Test
    public void shouldGetRandomPositiveBigDecimal() {
        // when
        final BigDecimal positiveBigDecimal = RandomDataGenerator.randomPositiveBigDecimal();

        // then
        assertThat(positiveBigDecimal).isPositive();
    }

    @Test
    public void shouldGetRandomNegativeBigDecimal() {
        // when
        final BigDecimal negativeBigDecimal = RandomDataGenerator.randomNegativeBigDecimal();

        // then
        assertThat(negativeBigDecimal).isNegative();
    }

    @Test
    public void shouldReturnRandomInteger() {

        // when
        final int integer = RandomDataGenerator.randomInteger();

        // then it should generate valid integer

        // debug info
        LOGGER.info(String.valueOf(integer));
    }

    @Test
    public void generateWordsShouldThrowIllegalArgumentExceptionIfValueIsNegative() {
        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Value must be positive value.");

        // when
        generateWords(-1);
    }

    @Test
    public void generateWordsShouldReturnEmptyStringForSizeZero() {
        // given
        final int zeroSize = 0;
        // when
        final String result = generateWords(zeroSize);

        // then
        assertThat(result).isEmpty();
    }

    @Test
    public void generateWordsShouldReturnEmptyStringForSizeOne() {
        // given
        final int size = 1;

        // when
        final String result = generateWords(size);

        // then
        assertThat(result).isNotEmpty();
        assertThat(result).doesNotEndWith(SPACE);
    }

    @Test
    public void generateWordsShouldReturnEmptyStringForFiveWords() {
        // given
        final int size = 5;

        // when
        final String result = generateWords(size);

        // then
        assertThat(result).isNotEmpty();
        assertThat(result).contains(SPACE);
        assertThat(result).doesNotEndWith(SPACE);
    }

    @Test
    public void generateWordWithoutStopWordShouldReturnPseudoWordThatIsNotStopWord() {

        // when
        final String word = generateWordWithoutStopWord(MAX_SMALL_VALUE_RANGE);

        // then
        assertThat(word).isNotEmpty();
        assertThat(isStopWord(word)).isFalse();
    }

    @Test
    public void shouldGenerateRandomBoolean() {
        // when
        final boolean value = RandomDataGenerator.generateRandomBoolean();

        // then
        assertThat(Boolean.valueOf(value)).isNotNull();

    }

    @Test
    public void generateRandomIntegerAsStringShouldReturnRandomPinyinCharacter() {
        // when
        final String value = RandomDataGenerator.generateRandomPinyinCharacter();

        // debug
        LOGGER.debug(value);

        // then
        assertThat(getAllPinyinFromFirstToFourthToneWithoutNeutralTone().contains(value)).isTrue();
    }

    @Test
    public void generateRandomIntegerAsStringShouldReturnRandomIntegerAsString() {
        // when
        final String result = RandomDataGenerator.generateRandomIntegerAsString(10);

        // then
        final int number = Integer.parseInt(result);

        // debug
        LOGGER.info("Number generated: " + number);
    }

    @Test // it is not a test,i need generate UUID sometimes
    public void shouldPrintRandomUUID() {
        //given
        final int uuidLength = 36;

        // it is a utility not test
        displayRandomUUID();

        // but I will verify just in case
        assertThat(outputStream.toString().length()).isEqualTo(uuidLength);


    }

    @Test //TODO tool to generate random numbers in lotto
    public void shouldGenerateNumbersForLotto() {
        // given
        int start = 1;
        int stop = 59;
        int[] lastDraw = new int[]{12, 24, 33, 34, 39, 56, 38}; // number including bonus

        // when
        final List<Integer> result = generateRandomNumberSequenceExcludingSpecificNumber(start, stop, lastDraw);

        // then
        System.out.println(result.size());
        result.forEach(number -> System.out.println(number + ","));
    }

    @Test
    public void generateNonAlphanumericStringAcceptanceTest() {
        // given

        // when
        final String result = generateNonAlphanumericString(100);

        // debug
        System.out.println(result);

        // then
        assertThat(result.length()).isGreaterThan(0);
        assertThat(result).isNotEmpty();
    }
}
