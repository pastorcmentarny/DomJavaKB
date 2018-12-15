package dms.pastor.tools.gibberishcheck;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class JobDescriptionToWordsConverter {
    public static List<String> convert(String job) {
        List<String> wordList = Arrays.asList(job.toLowerCase().replaceAll("[.,;:_]", "").split(" "));

        return wordList.stream()
            .filter(word -> !word.equalsIgnoreCase("a"))
            .filter(word -> !word.equalsIgnoreCase("+44"))
            .filter(word -> !word.equalsIgnoreCase("0"))
            .collect(Collectors.toList());
    }
}
