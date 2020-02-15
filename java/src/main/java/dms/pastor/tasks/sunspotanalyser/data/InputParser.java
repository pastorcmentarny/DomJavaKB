package dms.pastor.tasks.sunspotanalyser.data;

import static dms.pastor.utils.file.FileUtils.readRawData;
import static java.lang.Integer.valueOf;

/**
 * Author Dominik Symonowicz
 * Created 2013-08-26
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class InputParser {

    private String rawData;
    private String[] data;

    public InputParser(String inputFile) {
        rawData = readRawData(inputFile);
    }

    private InputParser() {
    }

    public static InputParser getInputParserFromString(String rawString) {
        InputParser inputParser = new InputParser();
        inputParser.setRawData(rawString);
        return inputParser;
    }

    private void setRawData(String rawData) {
        this.rawData = rawData;
    }

    public final Grid generateGrid() {
        data = rawData.split(" ");
        validateData();
        return new Grid(data);
    }

    final void validateData() {
        for (String number : data) {
            try {
                valueOf(number);
            } catch (Exception e) {
                exitProgramOnError();
            }
        }
    }

    private void exitProgramOnError() {
        System.err.println("Data is incorrect.Please correct it");
        System.exit(1);
    }

    public final int getResultsNo() {
        validateData();
        if (data != null && data.length > 1) {
            return Integer.parseInt(data[0]);
        } else {
            exitProgramOnError();
        }
        return -1;
    }

}
