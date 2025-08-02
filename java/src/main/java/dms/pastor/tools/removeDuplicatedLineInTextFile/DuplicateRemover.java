package dms.pastor.tools.removeDuplicatedLineInTextFile;

import dms.pastor.utils.string.ToStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedHashSet;
import java.util.Scanner;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static dms.pastor.utils.file.TextFileUtils.saveTextToFile;

/**
 * Author Dominik Symonowicz
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
class DuplicateRemover {

    private static final Logger LOGGER = LoggerFactory.getLogger(DuplicateRemover.class);

    void performTask(String filePath) {
        LOGGER.debug("Task started.");
        LOGGER.debug("Reading and removing duplicated line from file...{}", filePath);
        String cleanedFileAsString;
        try {
            cleanedFileAsString = removeDuplicateLinesFromFile(filePath);
        } catch (FileNotFoundException e) {
            LOGGER.error("File in path:{}does NOT exist", filePath);
            throw new IllegalArgumentException(e.getMessage());
        }
        LOGGER.debug("Saving file without duplicated lines...{}", filePath);
        final boolean result = saveTextToFile(cleanedFileAsString, filePath);
        LOGGER.info("File {} saved.", result ? EMPTY_STRING : "NOT");
    }

    private String removeDuplicateLinesFromFile(String filePath) throws FileNotFoundException {
        validateFilePath(filePath);
        LOGGER.info("Reading and removing duplicated line from file...{}", filePath);
        LinkedHashSet<String> lines = new LinkedHashSet<>();
        try (Scanner scanner = new Scanner(new FileInputStream(filePath))) {
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
        }
        return ToStringUtils.toString(lines);
    }

    private void validateFilePath(String filePath) {
        if (filePath == null || filePath.isEmpty()) {
            throw new IllegalArgumentException("Invalid path to file : " + filePath);
        }
    }
}
