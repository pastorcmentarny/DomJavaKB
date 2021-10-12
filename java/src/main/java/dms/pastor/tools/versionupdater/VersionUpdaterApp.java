package dms.pastor.tools.versionupdater;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class VersionUpdaterApp {
    private static final String DEFAULT_PATH = "B:\\GitHub\\DomKB";


    public static void main(String[] args) throws IOException {
        final var path = VersionUpdateConfig.getPathFor("java", DEFAULT_PATH);

        updateVersion(path);
    }

    private static void updateVersion(String path) throws IOException {
        List<String> fileContent = new ArrayList<>(Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8));

        int number = 0;
        for (int lineNumber = 0; lineNumber < fileContent.size(); lineNumber++) {
            if (fileContent.get(lineNumber).startsWith("version = '")) {
                String line = fileContent.get(lineNumber).split("version = '")[1];
                line = line.substring(0, line.length() - 1);
                number = Integer.parseInt(line) + 1;
                fileContent.set(lineNumber, String.format("version = '%d'", number));
                break;
            }
        }

        Files.write(Paths.get(path), fileContent, StandardCharsets.UTF_8);
    }
}
