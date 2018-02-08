package dms.pastor.utils;

import dms.pastor.domain.exception.SomethingWentWrongException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
final class TextUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(TextUtils.class);
    private static final String ERROR_MESSAGE = "Unable to count word due ";
    private static final String DELIMITER = "(?m:^$)";

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
}
