package dms.pastor.tools.tube;

import java.io.File;
import java.util.List;

import static java.io.File.separator;

/**
 * Author Dominik Symonowicz
 * Created 07/11/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
class USSDominikStatsApplicationRunner {
    private static final String SRC = "src" + separator;
    private static final String RESOURCES = "resources" + separator;
    private static final String BASE_PATH = System.getProperty("user.dir") +
            separator + SRC + "main" +
            separator + RESOURCES;
    private static final String path = BASE_PATH + "tube" + File.separator + "station.txt";

    private USSDominikStatsApplicationRunner() {
    }

    public static void main(String[] args) {

        DataUploader dataUploader = new DataUploader();
        final List<Station> stationList = dataUploader.load(path);
        stationList.forEach(System.out::println);
        DataWriter dataWriter = new DataWriter();
        dataWriter.save(path, stationList);
    }
}
