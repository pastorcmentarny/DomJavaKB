package dms.pastor.tools.job.gibberishcheck;

import dms.pastor.utils.StringUtils;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.util.List;

import static java.nio.file.Files.readAllLines;


class DataLoader {


    public static String loadEmailFromRecruiter(String path) {
        String base = FileSystems.getDefault().getPath(".").toAbsolutePath().toString();
        System.out.println(Paths.get(base, path).toAbsolutePath());
        try {
            List<String> lines = readAllLines(Paths.get(base, path));
            return lines.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return StringUtils.EMPTY_STRING;
    }
}
