package dms.pastor.tasks.analyser;

import dms.pastor.utils.ValidatorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;

/**
 * Author Dominik Symonowicz
 * Created 01/08/2016
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
class ProjectAnalyser {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectAnalyser.class);

    private final List<File> javaFiles = new ArrayList<>();
    private final List<Integer> averageLines = new ArrayList<>();
    private final List<Integer> averageWidth = new ArrayList<>();
    private int lineCount = 0;
    private int characterCount = 0;
    private int widestLine = 0;
    private String widestLineFileName = EMPTY_STRING;
    private int highestLinesFileCount = 0;
    private String highestLinesFileName = EMPTY_STRING;

    void analyse(String path) {
        validate(path);
        displayAllFilesInProject();
        collectAllJavaFiles(new File(path));
        analyseFiles();
        System.out.println(getResultAsText());
    }

    private void displayAllFilesInProject() {
        try {
            Files.list(Paths.get("."))
                .filter(Files::isRegularFile)
                .forEach(System.out::println);
        } catch (IOException e) {
            LOGGER.error(String.format("Unable to list of all files due %s", e.getMessage()), e);
        }
    }

    private void analyseFiles() {

        javaFiles.forEach(file -> {
            try {
                analyseFile(file);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        });
    }

    private void analyseFile(File file) throws IOException {

        try (FileReader fileReader = new FileReader(file); BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            int lines;
            String line;
            lines = 0;
            while ((line = bufferedReader.readLine()) != null) {
                analyseLine(line, file.getName());
                lines++;
            }

            setIfHighestLineFile(lines, file.getName());
            averageLines.add(lines);
        }
    }

    private void analyseLine(String line, String fileName) {
        addLine();
        addCharactersCount(line.length());
        setIfWidestLine(line.length(), fileName);
        averageWidth.add(line.length());
    }

    private void setIfWidestLine(int length, String fileName) {
        if (length > widestLine) {
            widestLine = length;
            widestLineFileName = fileName;
        }
    }

    private void addCharactersCount(int characters) {
        characterCount += characters;
    }

    private void addLine() {
        lineCount++;
    }

    private void collectAllJavaFiles(File directory) {
        final File[] listOfFiles = directory.listFiles();
        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isDirectory()) {
                    collectAllJavaFiles(file);
                } else {
                    if (file.getName().endsWith(".java")) {
                        javaFiles.add(file);
                    }
                }
            }
        }
    }

    int getNumberOfFiles() {
        return javaFiles.size();
    }

    private void validate(String path) {
        ValidatorUtils.validateIfNotEmpty(path, "Path");
        if (!new File(path).exists() || !new File(path).isDirectory()) {
            throw new IllegalArgumentException("Path to directory doesn't exist or is invalid");
        }
    }

    private String getResultAsText() {
        return "RESULT:\n" +
            "\nFiles: " + getNumberOfFiles() +
            "\nLines of code: " + getLinesOfCode() +
            "\nCharacters: " + getCharacterNumbers() +
            "\nWidest line: " + getWidestLine() + " in " + getWidestLineText() +
            "\nFile with highest lines: " + getHighestLineCount() + " in " + getHighestLinesFileName() +
                "\nAverage width line per file: " + calculateAverageFromIntegerList(averageWidth) +
                "\nAverage lines per file: " + calculateAverageFromIntegerList(averageLines);

    }

    private static int calculateAverageFromIntegerList(List<Integer> integerList) {
        int[] intStream = integerList.stream().mapToInt(width -> width).toArray();
        final int max = IntStream.of(intStream).max().orElse(0);
        final int min = IntStream.of(intStream).min().orElse(0);
        final int sum = IntStream.of(intStream).filter(width -> width > 0).sum();
        return BigDecimal.valueOf(sum - max - min / integerList.size() - 2).intValue();
    }

    int getLinesOfCode() {
        return lineCount;
    }

    public int getCharacterNumbers() {
        return characterCount;
    }

    public int getWidestLine() {
        return widestLine;
    }

    private String getWidestLineText() {
        return widestLineFileName;
    }

    public int getHighestLineCount() {
        return highestLinesFileCount;
    }

    private String getHighestLinesFileName() {
        return highestLinesFileName;
    }

    private void setIfHighestLineFile(int lines, String fileName) {
        if (lines > highestLinesFileCount) {
            highestLinesFileCount = lines;
            highestLinesFileName = fileName;
        }
    }

}
