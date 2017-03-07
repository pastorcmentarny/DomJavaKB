package dms.pastor.tasks.sunspotanalyser.data;


import java.io.File;

import static dms.pastor.utils.FileTools.readRawData;
import static java.lang.Integer.valueOf;

/**
 * Author Dominik Symonowicz
 * Created 2013-08-26
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class InputParser {

    private final String rawData;
    private String[] data;

    public InputParser(File inputFile) {
        rawData = readRawData(inputFile);
    }

    //Use for debug purposes only
    public InputParser(String inputString) {
        rawData = inputString;
    }

    public final Grid generateGrid() {
        data = rawData.split(" ");
        validateData();
        return new Grid(data);
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
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
            return valueOf(data[0]);
        } else {
            exitProgramOnError();
        }
        return -1;
    }

}
