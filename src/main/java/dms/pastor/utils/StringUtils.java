package dms.pastor.utils;

import dms.pastor.utils.randoms.RandomDataGenerator;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static dms.pastor.domain.Message.INPUT_CANNOT_BE_EMPTY;
import static dms.pastor.utils.ValidatorUtils.validateIfNotNull;
import static java.lang.Character.*;
import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.toList;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * <p>
 * Yes, Apache commons is better, but this class was created to learn TDD.
 */
@SuppressWarnings("QuestionableName") // because string is valid name
public final class StringUtils {
    public static final String EMPTY_STRING = "";
    public static final String WHITESPACE = " ";
    public static final char WHITESPACE_CHAR = ' ';
    public static final char NEW_LINE = '\n'; //TODO replace with System.lineSeparator()
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    public static final String ALPHANUMERIC = ALPHABET.toUpperCase() + ALPHABET + "0123456789";
    public static final String UNDERSCORE = "_";
    public static final char COMMA = ',';
    static final String NON_ALPHANUMERIC = "~#&@£$^'`\".,:;*–+=(){}[]<>?!\\|/";
    private static final String ALPHABET_BOTH_CASE = ALPHABET + ALPHABET.toUpperCase();
    private static final String ALPHANUMERIC_REGEX = "[^a-zA-Z0-9]";


    private StringUtils() {
    }

    private static Map<Character, Integer> getAlphabetAsMap() {
        Map<Character, Integer> alphabetMap = new HashMap<>();
        for (char letter : ALPHABET.toCharArray()) {
            alphabetMap.put(letter, 0);
        }
        return alphabetMap;
    }

    public static Character getRandomCharacter() {
        return ALPHABET.toCharArray()[new Random().nextInt(ALPHABET.length())];
    }

    public static String getRandomText(int size) {
        if (size <= 0) {
            return EMPTY_STRING;
        }
        StringBuilder text = new StringBuilder(EMPTY_STRING);
        for (int i = 0; i < 2 + size; i++) {
            RandomDataGenerator.addRandomCharacterToStringBuilder(text);
        }
        return text.toString();
    }

    public static String getUnknownWhenNullString(String string) {
        return string != null ? string : "Unknown";
    }

    /**
     * A palindrome is a word, phrase, number, or other sequence of symbols or elements that reads the same forward or reversed,
     */
    public static boolean isPalindromeOfAnyPermutationString(String word) {
        char[] characters = word.toCharArray();
        Map<Character, Integer> characterCounter = new HashMap<>();
        for (char character : characters) {
            increaseByOne(characterCounter, character);
        }

        boolean odd = false;

        Iterator<Map.Entry<Character, Integer>> it = characterCounter.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Character, Integer> pairs = it.next();
            int value = pairs.getValue();
            if (value % 2 != 0) {
                if (odd) {
                    return false;
                } else {
                    odd = true;
                }
            }
            it.remove(); // avoids a ConcurrentModificationException
        }
        return true;
    }

    private static void increaseByOne(Map<Character, Integer> characterCounter, char character) {
        if (characterCounter.containsKey(character)) {
            Integer count = characterCounter.get(character);
            count += 1;
            characterCounter.put(character, count);
        } else {
            characterCounter.put(character, 1);
        }
    }

    static boolean isPalindromeString(String word) {
        return word.equalsIgnoreCase(reverseString(word));
    }

    public static String reverseString(String string) {
        return new StringBuilder(string).reverse().toString();
    }

    static boolean isAlpha(String string) {
        char[] stringAsCharArray = string.toCharArray();
        for (char ch : stringAsCharArray) {
            if (!Character.isLetter(ch)) {
                return false;
            }
        }
        return true;
    }

    /*
        A panagram is a holoalphabetic sentence for a given ALPHABET is a sentence using every letter of the ALPHABET at least once.
     */
    static boolean isPangrams(String sentence) {
        Map<Character, Integer> alphabet = StringUtils.getAlphabetAsMap();
        char[] sentenceAsCharArray = sentence.toLowerCase().toCharArray();

        for (char character : sentenceAsCharArray) {
            if (Character.isLetter(character)) {
                alphabet.put(character, increaseCountByOne(alphabet, character));
            }
        }
        return isAPangrams(alphabet);
    }

    private static boolean isAPangrams(Map<Character, Integer> alphabet) {
        Iterator<Map.Entry<Character, Integer>> it = alphabet.entrySet().iterator();
        Map.Entry<Character, Integer> pair;
        while (it.hasNext()) {
            pair = it.next();
            if (pair.getValue() < 1) {
                return false;
            }
        }
        return true;
    }

    private static int increaseCountByOne(Map<Character, Integer> alphabet, char character) {
        return alphabet.get(character) + 1;
    }

    static String[] toStringArray(List<String> list) {
        validateIfNotNull(list);
        String[] stringArray = new String[list.size()];
        int counter = 0;
        for (String string : list) {
            stringArray[counter] = string;
            counter++;
        }
        return stringArray;
    }

    static String getNullSafeString(String string) {
        return nonNull(string) ? string : EMPTY_STRING;
    }

    //it considers only whitespaces as empty string since .trim()
    public static boolean isStringBlank(String string) {
        return string == null || string.trim().isEmpty();
    }

    public static boolean isStringEmpty(String string) {
        return string == null || string.isEmpty();
    }

    public static boolean isStringNotEmpty(String string) {
        return !isStringBlank(string);
    }

    public static String[] splitContentIntoWords(String content) {
        if (isStringBlank(content)) {
            throw new IllegalArgumentException(INPUT_CANNOT_BE_EMPTY);
        }
        return content.split(WHITESPACE);
    }

    public static boolean hasNonAlphanumericCharactersOnly(String string) {
        char[] charArray = string.toCharArray();
        for (char character : charArray) {
            for (char letterOrNumber : ALPHANUMERIC.toCharArray()) {
                if (character == letterOrNumber) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean hasNonAlphabetCharactersOnly(String string) {
        char[] charArray = string.toCharArray();
        for (char character : charArray) {
            for (char letterOrNumber : ALPHABET_BOTH_CASE.toCharArray()) {
                if (character == letterOrNumber) {
                    return false;
                }
            }
        }
        return true;
    }

    public static String swapCaseLettersInString(String text) {
        validateIfNotNull(text, "text");
        if (text.isEmpty()) {
            return EMPTY_STRING;
        }
        StringBuilder stringBuilder = new StringBuilder(EMPTY_STRING);
        for (Character character : text.toCharArray()) {
            if (isUpperCase(character)) {
                stringBuilder.append(toLowerCase(character));
            } else if (isLowerCase(character)) {
                stringBuilder.append(toUpperCase(character));
            } else {
                stringBuilder.append(character);
            }
        }
        return stringBuilder.toString();
    }

    public static boolean isAllStringsAreNotEmpty(String... values) {
        for (String value : values) {
            if (value.equals(EMPTY_STRING)) {
                return false;
            }
        }
        return true;
    }

    static String removeAllNonAlphaNumericCharactersFromString(String string) {
        if (isStringEmpty(string)) {
            return string;
        }
        return string.replaceAll(ALPHANUMERIC_REGEX, EMPTY_STRING);
    }

    static boolean startsWithUpperCase(String string) {
        return !isStringBlank(string) && Character.isUpperCase(string.charAt(0));
    }

    static String trimAllWhiteSpaces(String text) {
        if (isStringBlank(text)) {
            return text;
        }
        final char[] charArray = text.trim().toCharArray();
        StringBuilder stringBuilder = new StringBuilder(EMPTY_STRING);
        for (char character : charArray) {
            if (isNotWhitespaceCharacter(character)) {
                stringBuilder.append(character);
            }
        }
        return stringBuilder.toString();
    }

    public static boolean isNotWhitespaceCharacter(char character) {
        return !isWhitespace(character);
    }

    static char[] addCharToCharArray(char character, char[] charArray) {
        String newCharArray = new String(charArray);
        newCharArray += character;
        return newCharArray.toCharArray();
    }

    static int countOccurrenceOf(String occurrence, String string) {
        if (isStringBlank(occurrence) || isStringBlank(string)) {
            return 0;
        }

        if (occurrence.length() > occurrence.length()) {
            return 0;
        }

        Pattern pattern = Pattern.compile(occurrence.toLowerCase());
        Matcher matcher = pattern.matcher(string.toLowerCase());

        int counter = 0;
        while (matcher.find()) {
            counter++;
        }
        return counter >= 0 ? counter : 0;
    }

    static List<String> getCountryList() {
        return Arrays.stream(Locale.getISOCountries())
                .map(countryCode -> new Locale("", countryCode).getDisplayCountry())
                .collect(toList());
    }

    public static String getStringWithCapitalizedFirstCharacter(String string) {
        validateIfNotNull(string, "text");
        if (string.isEmpty()) {
            return string;
        }
        return string.substring(0, 1).toUpperCase() + string.substring(1, string.length());
    }

    public static String capitalizeFirstCharacter(String string) {
        validateIfNotNull(string, "text");
        if (string.isEmpty()) {
            return string;
        }
        return string.substring(0, 1).toUpperCase();
    }

    public static boolean isNotBlank(String text) {
        return !isStringBlank(text);
    }
}
