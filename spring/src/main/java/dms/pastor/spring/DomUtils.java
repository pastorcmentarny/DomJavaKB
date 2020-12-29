package dms.pastor.spring;


import dms.pastor.spring.commons.exceptions.SomethingWentWrongException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.String.format;
import static java.lang.System.out;

/**
THIS IS TEMPORARY CLASS COPIED FROM JAVA PROJECT DUE TO GRADLE IMPORT MODULE ISSUE
 //FIXME replace it with import java module to spring
 */
public final class DomUtils {
    public static final String EMPTY_STRING = "";
    private static final String ERROR_MESSAGE_VALUE_CANNOT_BE_NEGATIVE = " must be positive value.";

    public static final int MAX_SMALL_VALUE_RANGE = 10;
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final Logger LOGGER = LoggerFactory.getLogger(DomUtils.class);
    private static final int MAX_LARGE_VALUE_RANGE = 4096;
    private static final Random RANDOM = new Random(System.nanoTime());
    private static final String ALPHABET_WITH_LOWER_AND_UPPER = ALPHABET.toUpperCase() + ALPHABET;
    private static final String ALPHABET_WITH_ALL_CASES_AND_NUMBERS = ALPHABET_WITH_LOWER_AND_UPPER + "0123456789";
    private static final String NON_ALPHANUMERIC = "~#&@£$^'`\".,:;*–+=(){}[]<>?!\\|/";
    private static final int NOT_SPECIFIED = -1;
    private static final String COMMA = ",";
    private static final String OPEN_ARRAY = "[";
    private static final char CLOSE_ARRAY = ']';
    public static final String DASH = "-";
    public static final int NO_VALUE = -1;
    public static final String WHITESPACE = " ";
    public static final char WHITESPACE_CHAR = ' ';
    public static final String NEW_LINE = System.lineSeparator();
    public static final CharSequence CHAR_SEQUENCE_NEW_LINE = "\n";
    public static final String ALPHANUMERIC = ALPHABET.toUpperCase() + ALPHABET + "0123456789";
    public static final String UNDERSCORE = "_";
    private static final String ALPHABET_BOTH_CASE = ALPHABET + ALPHABET.toUpperCase();
    private static final String ALPHANUMERIC_REGEX = "[^a-zA-Z0-9]";
    private static final String OPEN_ARRAY_WITH_SPACE = OPEN_ARRAY + WHITESPACE_CHAR;
    private static final String[] STOP_WORDS = new String[]{"a", "an", "and", "are", "as", "at", "be", "but", "by", "for", "if", "in", "into", "is", "it", "no", "not", "of", "on", "or", "such", "that", "the", "their", "then", "there", "these", "they", "this", "to", "was", "will", "with"};

    private DomUtils() {
    }

    private static String getRandomText(int length) {
        if (length == NOT_SPECIFIED) {
            length = MAX_LARGE_VALUE_RANGE;
        }
        StringBuilder text = new StringBuilder(EMPTY_STRING);
        for (int i = 1; i < RANDOM.nextInt(length); i++) {
            addRandomCharacterToStringBuilder(text);
        }
        return text.toString();
    }

    public static void addRandomCharacterToStringBuilder(StringBuilder text) {
        int character = (int) (Math.random() * ALPHABET_WITH_ALL_CASES_AND_NUMBERS.length());
        text.append(ALPHABET_WITH_ALL_CASES_AND_NUMBERS, character, character + 1);
    }

    public static String getRandomText() {
        return getRandomText(NOT_SPECIFIED);
    }

    public static int[] generateRandomIntValues(int qty) {
        int[] values = new int[qty];
        for (int i = 0; i < values.length; i++) {
            values[i] = RANDOM.nextInt(MAX_VALUE - 1);
        }
        return values;
    }

    public static byte[] generateRandomByteArray(int size) {
        byte[] bytes = new byte[size];
        new Random().nextBytes(bytes);
        printArray(bytes);
        return bytes;
    }


    public static Character getRandomCharacterFromAlphabet() {
        return getRandomCharacterFrom(ALPHABET);
    }

    public static Character getRandomCharacterFromAlphabetExcludingCharacter(Character character) {
        if (Objects.isNull(character)) {
            return getRandomCharacterFromAlphabet();
        }

        var listOfCharacters = removeCharacterFromString(character, ALPHABET);

        if (isStringEmpty(listOfCharacters)) {
            return getRandomCharacterFromAlphabet();
        }
        return listOfCharacters.toCharArray()[RANDOM.nextInt(listOfCharacters.length())];
    }

    private static Character getRandomCharacterFrom(String array) {
        return array.toCharArray()[RANDOM.nextInt(ALPHABET.length())];
    }

    public static String getRandomCharacterAsString() {
        return getRandomCharacterFromAlphabet().toString();
    }

    @SuppressWarnings("MagicNumber")
    public static String generateRandomParagraph() {
        StringBuilder stringBuilder = new StringBuilder(EMPTY_STRING);

        IntStream.range(10, RANDOM.nextInt(100) + 20).forEach(text -> stringBuilder.append(getRandomText(MAX_SMALL_VALUE_RANGE)).append(WHITESPACE_CHAR));

        return '\t' + getRandomCharacterAsString().toUpperCase() + getRandomText(MAX_SMALL_VALUE_RANGE) + WHITESPACE_CHAR + stringBuilder.toString() + ".\n";
    }

    public static int[] generateIntArray(int size, int numberRange) {
        Random random = new Random();
        int[] intArray = new int[size];
        for (int i = 0; i < size; i++) {
            intArray[i] = random.nextInt(numberRange);
        }
        printIntArray(intArray);
        return intArray;
    }

    public static String[] generateArray(int size) {
        validateIfPositiveNumber(size, "Size");
        String[] array = new String[size];
        for (int i = 0; i < size; i++) {
            array[i] = generateString(4, MAX_LARGE_VALUE_RANGE);
        }
        return array;
    }

    public static String generateString() {
        return generateString(RANDOM.nextInt(MAX_LARGE_VALUE_RANGE) + 1);
    }

    public static String generateString(int max) {
        return generateString(0, max);
    }

    public static String generateString(int min, int max) {
        if (min > max || min < 0 || max <= 0) {
            throw new IllegalArgumentException("Value must be higher than zero and min value must be smaller is larger than max value");
        }
        int sizeOfString = min + RANDOM.nextInt(max - min);
        StringBuilder stringBuilder = new StringBuilder(EMPTY_STRING);
        for (int i = 0; i <= sizeOfString; i++) {
            stringBuilder.append(getRandomCharacterFromAlphabet());
        }
        return stringBuilder.toString();
    }

    public static List<String> generateStringList(int size) {
        validateIfPositiveNumber(size, "Size");

        List<String> randomStrings = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            randomStrings.add(generateString(10));
        }
        return randomStrings;
    }

    public static String generateWords(int size) {
        if (size == 0) {
            return EMPTY_STRING;
        }
        validateIfPositiveNumber(size);
        LOGGER.debug("Generate " + size + "  word(s).");
        StringBuilder stringBuilder = new StringBuilder(EMPTY_STRING);
        for (int i = 1; i <= size; i++) {
            stringBuilder.append(generateWordWithoutStopWord(MAX_SMALL_VALUE_RANGE)).append(WHITESPACE);
        }
        final String words = stringBuilder.substring(0, stringBuilder.length() - 1);
        LOGGER.debug("Generated output: " + words);
        return words;
    }

    public static String generateWordWithoutStopWord(int size) {
        validateIfPositiveNumber(size);
        final int maxAttemptsToCreate = 512;
        for (int i = 0; i < maxAttemptsToCreate; i++) {
            final String generatedString = generateString(MAX_SMALL_VALUE_RANGE);
            if (isNotStopWord(generatedString)) {
                return generatedString;
            }
        }
        throw new SomethingWentWrongException("Tried to generate word " + maxAttemptsToCreate + " times ,but I failed, because somebody screw up something {Size of word" + size + "}");
    }

    public static String generateNonAlphanumericString(int maxRandomSize) {
        StringBuilder stringBuilder = new StringBuilder(EMPTY_STRING);
        if (maxRandomSize <= 0) {
            throw new IllegalArgumentException("Size of string must be greater than zero");
        }
        for (int i = 0; i < maxRandomSize; i++) {
            stringBuilder.append(getRandomCharacterFrom(NON_ALPHANUMERIC));
        }
        return stringBuilder.toString();
    }

    public static int randomPositiveInteger() {
        return RANDOM.nextInt(Integer.MAX_VALUE - 1) + 1;
    }

    public static String generateRandomIntegerAsString(int maxValue) {
        return String.valueOf(randomPositiveInteger(maxValue));
    }

    public static int randomPositiveInteger(int minValue, int maxValue) {
        validateIfPositiveNumber(maxValue);
        final int minValuePlusOne = minValue + 1;
        validateIfSumOfIntegerIsInIntegerValueRange(minValuePlusOne, maxValue);
        return minValuePlusOne + RANDOM.nextInt(maxValue);
    }


    public static int randomPositiveInteger(int maxValue) {
        validateIfPositiveNumber(maxValue);
        return RANDOM.nextInt(maxValue);
    }

    public static int randomIntegerExcluding(int min, int max, int[] numbers) {
        validateIfValuesIsInRange(min, max, numbers);

        int randomNumber = randomInteger(min, max);
        boolean repeat = true;
        while (repeat) {
            int numberToCheck = randomNumber;
            repeat = Arrays.stream(numbers)
                    .boxed()
                    .collect(Collectors.toList())
                    .stream()
                    .anyMatch(number -> numberToCheck == number);
            if (repeat) {
                randomNumber = randomInteger(min, max);
            }

        }
        return randomNumber;
    }

    public static int randomInteger() {
        if (RANDOM.nextBoolean()) {
            return randomPositiveInteger();
        } else {
            return randomNegativeInteger();
        }
    }

    public static int randomInteger(int minValue, int maxValue) {
        validateValueIsSmallerOrEqualsThatOtherValue(minValue, maxValue);
        final int randomInteger = RANDOM.nextInt(maxValue + 1);
        return Math.max(randomInteger, minValue);
    }

    public static int randomNegativeInteger() {
        return new BigDecimal(randomPositiveInteger()).negate().intValue();
    }

    public static BigDecimal randomNegativeBigDecimal() {
        return randomPositiveBigDecimal().negate();
    }

    public static BigDecimal randomPositiveBigDecimal() {
        return new BigDecimal(RANDOM.nextInt(Integer.MAX_VALUE));
    }

    public static List<String> generateStringList() {
        List<String> randomStrings = new ArrayList<>();
        int size = RANDOM.nextInt(MAX_SMALL_VALUE_RANGE) + 4;
        for (int i = 0; i < size; i++) {
            randomStrings.add(generateString(MAX_SMALL_VALUE_RANGE));
        }
        return randomStrings;
    }

    @SuppressWarnings("BooleanMethodNameMustStartWithQuestion") // this is generator
    public static boolean generateRandomBoolean() {
        return RANDOM.nextBoolean();
    }



    public static List<Integer> generateRandomNumberSequenceExcludingSpecificNumber(int start, int stop, int[] excluded) {
        final List<Integer> numberList = IntStream.rangeClosed(start, stop).filter(number -> !contains(number, excluded)).boxed().collect(Collectors.toList());
        Collections.shuffle(numberList);
        return numberList;
    }

    private static boolean contains(int number, int[] list) {
        for (int i : list) {
            if (i == number) {
                return true;
            }
        }
        return false;
    }


    static void displayRandomUUID() {
        System.out.print(UUID.randomUUID());
    }

    public static void printArray(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder(OPEN_ARRAY);
        if (bytes.length == 0) {
            throw new IllegalArgumentException("byte array is empty");
        }
        for (byte aByte : bytes) {
            stringBuilder.append(aByte).append(COMMA);
        }
        final String result = stringBuilder.toString();
        final String substring = result.substring(0, result.length() - 1);

        out.print(substring + CLOSE_ARRAY);
    }

    public static String removeCharacterFromString(Character character, String string) {
        if (Objects.isNull(string)) {
            return null;
        }
        return string.replaceAll(character.toString(), EMPTY_STRING);
    }

    public static boolean isStringEmpty(String string) {
        return string == null || string.isEmpty();
    }

    public static void printIntArray(int[] values) {
        StringBuilder stringBuilder = new StringBuilder(OPEN_ARRAY_WITH_SPACE);
        IntStream.of(values).forEach(integer -> stringBuilder.append(integer).append(WHITESPACE_CHAR));
        printInConsole(stringBuilder);
    }

    private static void printInConsole(StringBuilder sb) {
        sb.append(CLOSE_ARRAY);
        out.println(sb.toString());
    }
    public static void validateIfPositiveNumber(int number) {
        validateIfPositiveNumber(number, "value");
    }

    public static void validateIfPositiveNumber(int number, String valueName) {
        if (number <= 0) {
            throw new IllegalArgumentException(valueName + " {" + number + "} " + ERROR_MESSAGE_VALUE_CANNOT_BE_NEGATIVE);
        }
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public static void validateIfSumOfIntegerIsInIntegerValueRange(int minValue, int maxValue) {
        try {
            Math.addExact(minValue, maxValue);
        } catch (ArithmeticException exception) {
            throw new IllegalArgumentException("Range may produce number bigger than valid range for integer.", exception);
        }
    }

    public static boolean isStopWord(String word) {
        if (isStringBlank(word)) {
            return false;
        }
        for (String stopWord : STOP_WORDS) {
            if (word.equalsIgnoreCase(stopWord)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNotStopWord(String word) {
        return !isStopWord(word);
    }

    public static void validateIfValuesIsInRange(int min, int max, int[] numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException();
        }
        for (int number : numbers) {
            if (!isValueInRange(min, max, number)) {
                throw new IllegalArgumentException("One of values is not in range.");
            }
        }
    }

    public static boolean isValueInRange(int min, int max, int number) {
        validateMinValueIsSmallerThanMaxValue(min, max);
        return number >= min && number <= max;
    }

    public static void validateMinValueIsSmallerThanMaxValue(int minValue, int maxValue) {
        if (minValue >= maxValue) {
            throw new IllegalArgumentException(format("MinValue (%d) must be lower than MaxValue(%d)", minValue, maxValue));
        }
    }

    public static void validateValueIsSmallerOrEqualsThatOtherValue(int value, int otherValue) {
        if (value > otherValue) {
            throw new IllegalArgumentException(format("Value (%d) must be lower or equals to than Other Value(%d)", value, otherValue));
        }
    }

    public static boolean isStringBlank(String string) {
        return string == null || string.trim().isEmpty();
    }
}
