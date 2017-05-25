package dms.pastor.tasks.analyser;

import dms.pastor.utils.ValidatorUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Author Dominik Symonowicz
 * Created 01/08/2016
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
class ProjectAnalyser {
    private final List<File> javaFiles = new ArrayList<>();
    private final List<Integer> averageLines = new ArrayList<>();
    private final List<Integer> averageWidth = new ArrayList<>();
    private int lineCount = 0;
    private int characterCount = 0;
    private int widestLine = 0;
    private String widestLineFileName = "";
    private int highestLinesFileCount = 0;
    private String highestLinesFileName = "";

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

        try (FileReader fileReader = new FileReader(file)) {
            int lines;
            try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                String line;
                lines = 0;
                while ((line = bufferedReader.readLine()) != null) {
                    analyseLine(line, file.getName());
                    lines++;
                }
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

    //TODO remove 1 highest and 1 smallest
    private int calculateAverageWidth() {
        final int sum = averageWidth
                .stream()
                .mapToInt(width -> width)
                .filter(width -> width > 0)
                .sum();
        return BigDecimal.valueOf(sum / averageWidth.size()).intValue();
    }

    //TODO remove 1 highest and 1 smallest
    private int calculateAverageLinesPerFile() {
        final int sum = averageLines.stream().mapToInt(width -> width).sum();
        return BigDecimal.valueOf(sum / averageLines.size()).intValue();
    }

    public int getLinesOfCode() {
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
