package dms.pastor.tools.job.gibberishcheck;

import dms.pastor.utils.StringUtils;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static java.nio.file.Files.readAllLines;


class DataLoader {


    public static String loadEmailFromRecruiter(String path) {
        String base = FileSystems.getDefault().getPath(".").toAbsolutePath().toString();
        final Path emailPath = Paths.get(base, path);
        System.out.println(emailPath.toAbsolutePath());
        try {
            List<String> lines = readAllLines(emailPath);
            return lines.toString();
        } catch (IOException e) {
            System.out.printf("Unable to read email from %s%n", path);
        }
        return StringUtils.EMPTY_STRING;
    }
}
