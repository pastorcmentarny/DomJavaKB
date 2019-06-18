package dms.pastor.utils.file;

import dms.pastor.domain.exception.SomethingWentTerribleWrongError;
import dms.pastor.utils.FileUtils;
import dms.pastor.utils.ValidatorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static dms.pastor.utils.FileUtils.getFileIfPathExists;
import static dms.pastor.utils.FileUtils.recreateFileIfExists;
import static dms.pastor.utils.StringUtils.NEW_LINE;
import static dms.pastor.utils.ValidatorUtils.validateIfFileIsAccessible;

public class TextFileUtils {
    public static final String FIELD_SEPARATOR = ";;";
    private static final Logger LOGGER = LoggerFactory.getLogger(FileUtils.class);

    private TextFileUtils() {
    }

    @SuppressWarnings("BooleanMethodNameMustStartWithQuestion")
    public static boolean saveTextToFile(String text, String path2file) {
        LOGGER.debug("Saving text to file: " + path2file);

        recreateFileIfExists(path2file);

        try (PrintWriter out = new PrintWriter(new FileWriter(path2file))) {
            out.print(text);
            LOGGER.info("File saved.");
        } catch (IOException ex) {
            LOGGER.error("Unable to save file ");
            return false;
        }
        return true;
    }

    @SuppressWarnings("BooleanMethodNameMustStartWithQuestion") //as method action is to save
    public static boolean saveListToFile(String[] content, String file) {
        return saveListToFile(Arrays.asList(content), file);
    }

    public static boolean saveListToFile(List<String> content, String file) {
        StringBuilder list = new StringBuilder();
        for (String line : content) {
            list.append(line);
            list.append(NEW_LINE);
        }

        try (FileWriter fileWriter = new FileWriter(file);
             BufferedWriter out = new BufferedWriter(fileWriter)) {
            out.write(list.toString());
        } catch (IOException e) {
            LOGGER.error("Unable to save source list to file: " + file);
            return false;
        }
        return true;
    }

    public static String loadFileFromResourceAsString(String path) {
        ValidatorUtils.validateIfNotEmpty(path, "path to resource file");
        ClassLoader classLoader = FileUtils.class.getClassLoader();

        try {
            final URL resource = classLoader.getResource(path);
            ValidatorUtils.validateIfObjectValueIsNotNull(resource, "URL resource from path " + path);
            validateIfFileIsAccessible(resource.getFile());
            File file = new File(resource.getFile());
            return org.apache.commons.io.FileUtils.readFileToString(file, StandardCharsets.UTF_8);
        } catch (IOException exception) {
            throw new SomethingWentTerribleWrongError(exception.getMessage());

        }
    }

    public static List<String> loadFileFromResourceAsListOfStrings(String path) {
        ValidatorUtils.validateIfNotEmpty(path, "path to resource file");
        ClassLoader classLoader = FileUtils.class.getClassLoader();

        try {
            final URL resource = classLoader.getResource(path);
            ValidatorUtils.validateIfObjectValueIsNotNull(resource, "URL resource from path " + path);
            return org.apache.commons.io.FileUtils.readLines(getFileIfPathExists(resource.getPath()), StandardCharsets.UTF_8);
        } catch (IOException exception) {
            throw new SomethingWentTerribleWrongError(exception.getMessage());

        }
    }

    public static String loadFile(Path path) {
        StringBuilder builder = new StringBuilder();
        try {
            Files.lines(path).forEach(line -> builder.append(line).append(System.lineSeparator()));
        } catch (IOException e) {
            return "Something went wrong";
        }
        return builder.toString();
    }
}
