package dom.coffirgar.transportmanager.utlis;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class UpdateBuildVersionOnStartup {
    public static int updateVersion() {
        int buildNumber = 0;
        try {
            final String path = "B:\\GitHub\\DomKB\\TransportManagerDB\\build.gradle";
            List<String> fileContent = new ArrayList<>(Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8));


            for (int lineNumber = 0; lineNumber < fileContent.size(); lineNumber++) {
                if (fileContent.get(lineNumber).startsWith("version = '")) {
                    System.out.println(fileContent.get(lineNumber));
                    String line = fileContent.get(lineNumber).split("version = '")[1];
                    line = line.substring(0, line.length() - 1);

                    buildNumber = Integer.parseInt(line) + 1;
                    fileContent.set(lineNumber, String.format("version = '%d'", buildNumber));


                    break;
                }
            }

            Files.write(Paths.get(path), fileContent, StandardCharsets.UTF_8);
        } catch (IOException exception) {
            System.out.println("Shit hit the fan due to: " + exception.getMessage());
        }
        return buildNumber;
    }
}
