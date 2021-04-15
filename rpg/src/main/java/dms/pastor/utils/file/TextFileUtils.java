package dms.pastor.utils.file;

import dms.pastor.domain.exception.SomethingWentWrongException;
import dms.pastor.utils.ValidatorUtils;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static dms.pastor.utils.file.FileUtils.getFileIfPathExists;

public class TextFileUtils {

    private TextFileUtils() {
    }
    
    public static List<String> loadFileFromResourceAsListOfStrings(String path) {
        ValidatorUtils.validateIfNotEmpty(path, "path to resource file");
        ClassLoader classLoader = FileUtils.class.getClassLoader();

        try {
            final URL resource = classLoader.getResource(path);
            ValidatorUtils.validateIfObjectValueIsNotNull(resource, "URL resource from path " + path);
            return org.apache.commons.io.FileUtils.readLines(getFileIfPathExists(resource.getPath()), StandardCharsets.UTF_8);
        } catch (IOException exception) {
            throw new SomethingWentWrongException(exception.getMessage());

        }
    }


}
