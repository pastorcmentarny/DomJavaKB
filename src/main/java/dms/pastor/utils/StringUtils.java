package dms.pastor.utils;

import java.lang.Character;
import java.util.*;

import static dms.pastor.domain.Message.INPUT_CANNOT_BE_EMPTY;
import static java.lang.Character.*;

/**
 * Author Dominik Symonowicz
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 * <p>
 * Yes, Apache commons is better, but this class was created to learn TDD.
 */
public final class StringUtils {

    static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    static final String NON_ALPHANUMERIC = "~#&@£$^'`\".,:;*–+=(){}[]<>?!\\|/";
    private static final String ALPHABET_BOTH_CASE = ALPHABET + ALPHABET.toUpperCase();
    private static final char COMMA = ',';
    public static final String EMPTY_STRING = "";
    private static final String ALPHANUMERIC = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"; //TODO replace it with RandomDataGenerator
    private static final String ALPHANUMERIC_REGEX = "[^a-zA-Z0-9]";
    private static final String WHITESPACE = " ";
    public static final char NEW_LINE = '\n';

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
        char[] chars = word.toCharArray();
        Map<Character, Integer> hm = new HashMap<>();
        for (char ch : chars) {
            if (hm.containsKey(ch)) {
                Integer x = hm.get(ch);
                x += 1;
                hm.put(ch, x);
            } else {
                hm.put(ch, 1);
            }
        }

        boolean odd = false;

        Iterator<Map.Entry<Character, Integer>> it = hm.entrySet().iterator();
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

    //A palindrome is a word, phrase, number, or other sequence of symbols or elements that reads the same forward or reversed,
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

    public static String toString(int[] values) {
        StringBuilder sb = new StringBuilder("[ ");
        for (int i : values) {
            sb.append(i).append(WHITESPACE);
        }
        sb.append(']');
        return sb.toString();
    }

    //     * A panagram is a holoalphabetic sentence for a given ALPHABET is a sentence using every letter of the ALPHABET at least once.
    static boolean isPangrams(String sentence) {
        Map<Character, Integer> alphabet = StringUtils.getAlphabetAsMap();
        char[] array = sentence.toLowerCase().toCharArray();

        for (char ch : array) {
            if (Character.isLetter(ch)) {
                alphabet.put(ch, alphabet.get(ch) + 1);
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

    public static String toString(LinkedHashSet<String> lines) {
        StringBuilder stringBuilder = new StringBuilder(EMPTY_STRING);
        for (String line : lines) {
            stringBuilder.append(line).append('\n');
        }
        return stringBuilder.toString();
    }

    static String[] toStringArray(List<String> list) {
        validateInput(list);
        String[] stringArray = new String[list.size()];
        int counter = 0;
        for (String string : list) {
            stringArray[counter] = string;
            counter++;
        }
        return stringArray;
    }

    public static String toString(List<String> stringList) {
        final StringBuilder stringBuilder = new StringBuilder(EMPTY_STRING);
        stringList.forEach(element -> stringBuilder.append(element).append(COMMA));
        return stringBuilder.toString().substring(0, stringBuilder.length() - 1);
    }

    private static void validateInput(List<String> arrayList) {
        if (arrayList == null) {
            throw new NullPointerException("list is null");
        }
    }

    //TODO move TextUtils
    public static String getNbsp(int times) {
        StringBuilder nsbpBuilder = new StringBuilder(EMPTY_STRING);
        for (int i = 0; i < times; i++) {
            nsbpBuilder.append("&nbsp;");
        }
        return nsbpBuilder.toString();
    }

    static boolean containsOnly(String text, char[] characters) {
        if (isStringBlank(text) || characters == null || characters.length == 0) {
            return false;
        }

        char[] textArray = text.toCharArray();
        for (char characterFromArray : textArray) {
            boolean characterFound = false;
            for (char character : characters) {
                if (characterFromArray == character) {
                    characterFound = true;
                }
            }
            if (!characterFound) {
                return false;
            }
        }
        return true;
    }

    static String getNullSafeString(String str) {
        return str != null ? str : EMPTY_STRING;
    }

    //it considers only whitespaces as empty string since .trim()
    public static boolean isStringBlank(String string) {
        return string == null || string.trim().isEmpty();
    }

    private static boolean isStringEmpty(String string) {
        return string == null || string.isEmpty();
    }

    static boolean isStringNotEmpty(String string) {
        return !isStringBlank(string);
    }

    static String[] splitContentIntoWords(String content) {
        if (isStringBlank(content)) {
            throw new IllegalArgumentException(INPUT_CANNOT_BE_EMPTY);
        }
        return content.split(WHITESPACE);

    }

    static boolean isContainSpace(String word) {
        if (isStringEmpty(word)) {
            return false;
        }

        final char[] chars = word.toCharArray();
        for (char character : chars) {
            if (isNotWhitespaceCharacter(character)) {
                return false;
            }
        }
        return true;
    }

    static boolean hasNonAlphanumericCharactersOnly(String string) {
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

    static boolean hasNonAlphabetCharactersOnly(String string) {
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


    static boolean isTextContainsAllKeywordsExists(List<String> keywords, String text) {
        if (keywords == null || keywords.isEmpty() || text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Keywords or text cannot be null or empty");
        }
        return keywords.stream().anyMatch(text::contains);
    }

    public static String swapCaseLettersInString(String text) {
        if (text == null) {
            throw new IllegalArgumentException("You cannot swap characters if String is null");
        }
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

    private static boolean isNotWhitespaceCharacter(char character) {
        return !isWhitespace(character);
    }

}
