package dms.pastor.tasks.sunspotanalyser;

import dms.pastor.tasks.sunspotanalyser.data.Analyser;
import dms.pastor.tasks.sunspotanalyser.data.Grid;
import dms.pastor.tasks.sunspotanalyser.data.InputParser;

import java.io.File;

import static dms.pastor.utils.FileTools.isFileValid;

/**
 * author: Dominik Symonowicz
 * WWW: http://pastor.ovh.org
 * Github: https://github.com/pastorcmentarny
 * Google Play:
 * https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * Email: email can be found on my website
 * <p>
 * Created ?
 * <p>
 * Runs application.Nothing excited .Is it?
 */
final class AppRunner {

    private AppRunner() {
    }

    public static void main(String[] args) {
        validateArgs(args);

        for (String filePath : args) {
            validateFile(filePath);
            String result = analyse(filePath);
            displayResult(result);
        }
    }

    private static void displayResult(String result) {
        System.out.println(result);
    }

    private static String analyse(String filePath) {
        InputParser parser = getInputParser(filePath);

        Grid grid = parser.generateGrid();

        Analyser analyser = new Analyser(grid);
        analyser.analyse();

        return generateResult(parser, analyser);
    }

    private static String generateResult(InputParser parser, Analyser analyser) {
        return analyser.getResults(parser.getResultsNo());
    }

    private static InputParser getInputParser(String filePath) {
        InputParser parser = null;
        try {
            parser = new InputParser(new File(filePath));
        } catch (Exception e) {
            error("There was problem with access to file due " + e.getMessage());
        }
        return parser;
    }

    private static void validateFile(String filePath) {
        if (!isFileValid(filePath)) {
            error("Command-Line Argument or Data in File is incorrect.Please correct it and try again. ");
        }
    }

    private static void validateArgs(String[] args) {
        if (args == null) {
            error("No arguments.You need add arguments with path to files.");
        }
    }

    private static void error(String what) {
        throw new IllegalArgumentException("\tWhoops!\nSomething went terrible terrible wrong\n" + what);
    }

}
