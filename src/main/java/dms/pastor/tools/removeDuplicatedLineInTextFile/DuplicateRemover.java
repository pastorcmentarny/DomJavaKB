package dms.pastor.tools.removeDuplicatedLineInTextFile;

import dms.pastor.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedHashSet;
import java.util.Scanner;

import static dms.pastor.utils.FileTools.saveTextToFile;
import static java.lang.String.format;

/**
 * Author Dominik Symonowicz
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
class DuplicateRemover {

    private static final Logger LOGGER = LoggerFactory.getLogger(DuplicateRemover.class);

    void performTask(String filePath) {
        LOGGER.debug("Task started.");
        LOGGER.debug("Reading and removing duplicated line from file..." + filePath);
        String cleanedFileAsString;
        try {
            cleanedFileAsString = removeDuplicateLinesFromFile(filePath);
        } catch (FileNotFoundException e) {
            LOGGER.error("File in path:" + filePath + "does NOT exist");
            throw new IllegalArgumentException(e.getMessage());
        }
        LOGGER.debug("Saving file without duplicated lines..." + filePath);
        final boolean result = saveTextToFile(cleanedFileAsString, filePath);
        LOGGER.info("File " + (result ? "" : "NOT") + " saved.");
    }

    private String removeDuplicateLinesFromFile(String filePath) throws FileNotFoundException {
        validateFilePath(filePath);
        LOGGER.info(format("Reading and removing duplicated line from file...%s", filePath));
        LinkedHashSet<String> lines = new LinkedHashSet<>();
        try (Scanner scanner = new Scanner(new FileInputStream(filePath))) {
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
        }
        return StringUtils.toString(lines);
    }

    private void validateFilePath(String filePath) {
        if (filePath == null || filePath.isEmpty()) {
            throw new IllegalArgumentException("Invalid path to file : " + filePath);
        }
    }
}
