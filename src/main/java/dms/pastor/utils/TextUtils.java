package dms.pastor.utils;

import dms.pastor.domain.exception.SomethingWentWrongException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TextUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(TextUtils.class);
    private static final String ERROR_MESSAGE = "Unable to count word due ";

    public static long countWordInTextInFile(String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            long counter = 0;
            while (scanner.hasNext()) {
                scanner.next();
                counter++;
            }
            return counter;
        } catch (Exception exception) {
            final String errorMessage = ERROR_MESSAGE + exception.getMessage();
            LOGGER.error(errorMessage, exception);
            throw new SomethingWentWrongException(errorMessage, exception);
        }
    }

    public static List<String> getTextInParagraphs(String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            scanner.useDelimiter("(?m:^$)");
            List<String> paragraphs = new ArrayList<>();
            while (scanner.hasNext()) {
                String paragraph = scanner.next();
                paragraphs.add(paragraph);
            }
            return paragraphs;
        } catch (Exception exception) {
            final String errorMessage = ERROR_MESSAGE + exception.getMessage();
            LOGGER.error(errorMessage, exception);
            throw new SomethingWentWrongException(errorMessage, exception);
        }
    }
}
