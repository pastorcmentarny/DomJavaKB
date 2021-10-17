package dom.coffirgar.transportmanager.components;


import dom.coffirgar.transportmanager.common.Utils;
import dom.coffirgar.transportmanager.domain.stations.Station;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;


import static dom.coffirgar.transportmanager.common.Utils.validateIfPathIsAccessible;
import static java.lang.String.format;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class DataWriter {
    private static final Logger LOGGER = LoggerFactory.getLogger(DataWriter.class);

    public void save(Path path, List<Station> stationList) {
        validateIfPathIsAccessible(path);
        LOGGER.info("Saving data.. to " + path.toString());
        final String content = stationList.stream().map(Station::asLine).collect(Collectors.joining(Utils.CHAR_SEQUENCE_NEW_LINE));
        try {
            Files.write(path, content.getBytes());
            LOGGER.info("Date saved to file :" + path);
        } catch (IOException exception) {
            LOGGER.error(format("Unable to save due %s", exception.getMessage()), exception);
        }
    }
}
