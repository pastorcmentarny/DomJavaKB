package dms.pastor.utils;

import dms.pastor.domain.exception.SomethingWentWrongException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Author Dominik Symonowicz
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public final class TextUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(TextUtils.class);
    private static final String ERROR_MESSAGE = "Unable to count word due ";
    private static final String DELIMITER = "(?m:^$)";
    private static final HashMap<String, String> SINGULAR_SAME_AS_PLULAR = getListOfWords();

    private static HashMap<String, String> getListOfWords() {
        HashMap<String, String> words = new HashMap<>();
        words.put("sheep", "sheep");
        words.put("series", "series");
        words.put("species", "species");
        words.put("deer", "deer");
        words.put("child", "children");
        words.put("goose", "geese");
        words.put("man", "men");
        words.put("woman", "women");
        words.put("tooth", "teeth");
        words.put("foot", "feet");
        words.put("mouse", "mice");
        words.put("person", "people");
        words.put("volcano", "volcanoes");
        words.put("phenomenon", "phenomena");
        words.put("criterion", "criteria");
        return words;
    }

    private TextUtils() {
    }

    public static long countWordInTextInFile(String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            return countWords(scanner);
        } catch (Exception exception) {
            final String errorMessage = ERROR_MESSAGE + exception.getMessage();
            LOGGER.error(errorMessage, exception);
            throw new SomethingWentWrongException(errorMessage, exception);
        }
    }

    static List<String> getTextInParagraphs(String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            scanner.useDelimiter(DELIMITER);
            List<String> paragraphs = new ArrayList<>();
            addParagraphsToParagraphs(scanner, paragraphs);
            return paragraphs;
        } catch (Exception exception) {
            final String errorMessage = ERROR_MESSAGE + exception.getMessage();
            LOGGER.error(errorMessage, exception);
            throw new SomethingWentWrongException(errorMessage, exception);
        }
    }

    private static long countWords(Scanner scanner) {
        long counter = 0;
        while (scanner.hasNext()) {
            scanner.next();
            counter++;
        }
        return counter;
    }

    private static void addParagraphsToParagraphs(Scanner scanner, List<String> paragraphs) {
        while (scanner.hasNext()) {
            String paragraph = scanner.next();
            paragraphs.add(paragraph);
        }
    }

    public static String getWordIfPlural(String word, long count) {
        ValidatorUtils.validateIfNotBlank(word, "word");
        ValidatorUtils.validateIfPositiveNumber(count, "count");
        if (count == 1) {
            return word;
        }
        if (SINGULAR_SAME_AS_PLULAR.containsKey(word)) {
            return SINGULAR_SAME_AS_PLULAR.get(word);
        }
        if (word.endsWith("o")) {
            return word + "es";
        }
        if (word.endsWith("is")) {
            return word.substring(0, word.length() - 2) + "es";
        }
        if (word.endsWith("s")) {
            return word + "es";
        }
        return word + "s";
    }

/*
    public static String trimAllWhitespace(String str) {
        if (str == null) {
            return null;
        }
        return trimAllWhitespace((CharSequence) str).toString();
    }
    public static CharSequence trimAllWhitespace(CharSequence text) {
        if (!hasLength(text)) {
            return text;
        }

        int len = str.length();
        StringBuilder sb = new StringBuilder(str.length());
        int len = text.length();
        StringBuilder sb = new StringBuilder(text.length());
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            char c = text.charAt(i);
            if (!Character.isWhitespace(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
 */

    public static String getYesNoFromBoolean(boolean booleanValue) {
        return booleanValue ? "yes" : "no";
    }
}
