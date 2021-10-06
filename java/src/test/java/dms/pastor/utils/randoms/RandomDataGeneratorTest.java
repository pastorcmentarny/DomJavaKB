package dms.pastor.utils.randoms;


import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

import static dms.pastor.tools.chinese.pinyin.PinyinUtils.getAllPinyinFromFirstToFourthToneWithoutNeutralTone;
import static dms.pastor.utils.EnglishUtils.isStopWord;
import static dms.pastor.utils.randoms.RandomDataGenerator.*;
import static java.lang.Character.*;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class RandomDataGeneratorTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(RandomDataGeneratorTest.class);
    private static final int RANDOM_STRING_LENGTH = 1024;
    private static final String SPACE = " ";
    public static final String ERROR_MESSAGE_SIZE_OF_STRING_MUST_BE_GREATER_THAN_ZERO = "Size of string must be greater than zero";
    private final Random random = new Random();
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private PrintStream printStream;

    @BeforeEach
    public void setUp() {
        printStream = System.out;
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
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
        assertThat(intValues.length).isEqualTo(size);
    }

    @Test
    public void testGetRandomCharacter() {
        // when
        Character randomCharacter = getRandomCharacterFromAlphabet();

        // then
        assertThat(isLetter(randomCharacter)).isEqualTo(true);
    }

    @Test
    public void testGetRandomCharacterAsString() {
        // when
        String randomCharacterAsString = getRandomCharacterAsString();

        // then
        assertThat(isLetter(randomCharacterAsString.charAt(0))).isEqualTo(true);
    }


    @RepeatedTest(10)
    public void testGetRandomTextWithoutMaxLength() {
        // given
        tearDown();

        // when
        final String text = getRandomText();

        // debug
        System.out.println("text is" + text);
        System.out.println("size of text is" + text.length());

        // then
        assertThat(1 <= text.length() && text.length() <= 1000).isEqualTo(true);

        // reset
        setUp();
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

        final int max = random.nextInt(1 + RANDOM_STRING_LENGTH);
        final int min = random.nextInt(1 + RANDOM_STRING_LENGTH) + max;

        // debug info
        LOGGER.info("Generated. Min:" + min + " Max:" + max);
        // when
        final var exception = Assertions.assertThrows(IllegalArgumentException.class, () -> generateString(min, max));

        // then
        assertThat(exception.getMessage()).isEqualTo("Value must be higher than zero and min value must be smaller is larger than max value");
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionForNegativeMinValueTest() {
        // when
        final var exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            final int negativeNumber = new BigDecimal(random.nextInt(1 + RANDOM_STRING_LENGTH)).negate().intValue();
            generateString(negativeNumber, 4);
        });

        // then
        assertThat(exception.getMessage()).isEqualTo("Value must be higher than zero and min value must be smaller is larger than max value");
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionForNegativeMaxValueTest() {
        // when
        final var exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            final int negativeNumber = new BigDecimal(random.nextInt(RANDOM_STRING_LENGTH)).negate().intValue();
            generateString(4, negativeNumber);
        });

        assertThat(exception.getMessage()).isEqualTo("Value must be higher than zero and min value must be smaller is larger than max value");
    }

    @Test
    public void shouldGenerateIntArrayTest() {
        // given
        int size = 10;
        // when
        final int[] intArray = generateIntArray(size, 10);
        // then
        assertThat(intArray.length).isEqualTo(size);
        for (int i : intArray) {
            assertThat(i <= 10 && i >= 0).isEqualTo(true);
        }
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionForNegativeSizeTest() {
        // given
        final var negativeValue = -1;
        // when
        final var exception = Assertions.assertThrows(IllegalArgumentException.class, () -> generateStringList(negativeValue));

        // then
        assertThat(exception.getMessage()).isEqualTo("Size {-1}  must be positive value.");

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
        // given
        final var size = 0;
        // when
        final var exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            final List<String> stringList = generateStringList(size);
        });

        // then
        assertThat(exception.getMessage()).isEqualTo("Size {" + size + "}  must be positive value.");
    }

    @Test
    public void generateStringArrayShouldThrowIllegalArgumentExceptionForNegativeTest() {
        // given
        final var negativeValue = -1;
        // when
        final var exception = Assertions.assertThrows(IllegalArgumentException.class, () -> generateStringList(negativeValue));

        // then
        assertThat(exception.getMessage()).isEqualTo("Size {" + negativeValue + "}  must be positive value.");

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
        // when
        final var exception = Assertions.assertThrows(IllegalArgumentException.class, () -> generateNonAlphanumericString(-1));

        // then
        assertThat(exception.getMessage()).isEqualTo(ERROR_MESSAGE_SIZE_OF_STRING_MUST_BE_GREATER_THAN_ZERO);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionIfSizeIsZeroTest() {
        final var exception = Assertions.assertThrows(IllegalArgumentException.class, () -> generateNonAlphanumericString(0));

        // then
        assertThat(exception.getMessage()).isEqualTo(ERROR_MESSAGE_SIZE_OF_STRING_MUST_BE_GREATER_THAN_ZERO);

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
        // when
        final var exception = Assertions.assertThrows(IllegalArgumentException.class, () -> randomInteger(minValue, maxValue));

        // then
        assertThat(exception.getMessage()).isEqualTo("Value (" + minValue + ") must be lower or equals to than Other Value(" + maxValue + ")");
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
        // given
        final var negativeValue = -1;
        // when
        final var exception = Assertions.assertThrows(IllegalArgumentException.class, () -> generateWords(negativeValue));

        // then
        assertThat(exception.getMessage()).isEqualTo("Value {-1}  must be positive value.");
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
        // given
        final int uuidLength = 36;

        // it is a utility not test
        displayRandomUUID();

        // but I will verify just in case
        assertThat(outputStream.toString().length()).isEqualTo(uuidLength);


    }

    @Test
    public void shouldGenerateNumbersForLotto() {
        // set
        System.setOut(printStream);

        // given
        int start = 1;
        int stop = 59;
        int[] lastDraw = new int[]{12, 24, 33, 34, 39, 56, 38}; // number including bonus
        // when
        final List<Integer> result = generateRandomNumberSequenceExcludingSpecificNumber(start, stop, lastDraw);

        // debug
        result.forEach(number -> System.out.print(number + ","));
        // then
        assertThat(result.size()).isEqualTo(52);

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

    @RepeatedTest(100)
    public void getRandomCharacterFromAlphabetExcludingCharacterShouldReturnCharacterWithoutExcludedOne() {
        // given
        final var character = getRandomCharacterFromAlphabet();
        // when
        final var result = getRandomCharacterFromAlphabetExcludingCharacter(character);

        // then
        assertThat(result).isNotEqualTo(character);
    }

    @RepeatedTest(100)
    public void getRandomCharacterFromAlphabetExcludingCharacterShouldAnyCharacterIfExcludedCharacterIsNull() {
        // when
        final var result = getRandomCharacterFromAlphabetExcludingCharacter(null);

        // debug
        System.out.println(result);

        // then
        assertThat(RandomDataGenerator.ALPHABET.chars().anyMatch(character -> character == result)).isTrue();
    }

    @RepeatedTest(100)
    public void randomPositiveLongShouldReturnValue() {
        // when
        final var result = RandomDataGenerator.randomPositiveLong();

        // debug
        System.out.println(result);

        // then
        assertThat(result).isGreaterThan(0);
    }
}
