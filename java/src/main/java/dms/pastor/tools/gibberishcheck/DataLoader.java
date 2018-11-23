package dms.pastor.tools.gibberishcheck;

import dms.pastor.utils.StringUtils;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.nio.file.Files.readAllLines;


public class DataLoader {


    public static List<String> loadDictionary(String path){
        String base = FileSystems.getDefault().getPath(".").toAbsolutePath().toString();
        var dictionary = new ArrayList<String>();
        try (Stream<String> stream = Files.lines(Paths.get(base + path))) {

            stream.forEach(dictionary::add);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return dictionary;
    }

    public static String loadEmailFromRecruiter(String path) {
        String base = FileSystems.getDefault().getPath(".").toAbsolutePath().toString();
        System.out.println(Paths.get(base + path).toAbsolutePath());
        try{
            List<String> lines = readAllLines(Paths.get(path));
            return lines.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return StringUtils.EMPTY_STRING;
    }
}
