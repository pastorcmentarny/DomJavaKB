package dms.pastor.tasks.analyser;

import dms.pastor.utils.ValidatorUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
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
        collectAllJavaFiles(new File(path));
        analyseFiles();
        System.out.println(getResultAsText());
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
                "\nAverage width line per file: " + calculateAverageWidth() +
                "\nAverage lines per file: " + calculateAverageLinesPerFile();

    }

    private int calculateAverageWidth() {
        int[] intStream = averageWidth.stream().mapToInt(width -> width).toArray();
        final int max = IntStream.of(intStream).max().orElse(0);
        final int min = IntStream.of(intStream).min().orElse(0);
        final int sum = IntStream.of(intStream).filter(width -> width > 0).sum();
        return BigDecimal.valueOf(sum - max - min / averageWidth.size() - 2).intValue();
    }

    private int calculateAverageLinesPerFile() {
        int[] intStream = averageLines.stream().mapToInt(width -> width).toArray();
        final int max = IntStream.of(intStream).max().orElse(0);
        final int min = IntStream.of(intStream).min().orElse(0);
        final int sum = IntStream.of(intStream).sum();
        return BigDecimal.valueOf(sum - max - min / averageLines.size() - 2).intValue();
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
