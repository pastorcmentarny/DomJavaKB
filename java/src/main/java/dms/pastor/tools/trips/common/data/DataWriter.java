package dms.pastor.tools.trips.common.data;

import dms.pastor.tools.trips.common.station.Station;
import dms.pastor.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

import static dms.pastor.utils.ValidatorUtils.validateIfPathIsAccessible;

/**
 * Author Dominik Symonowicz
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
public class DataWriter {
    private static final Logger LOGGER = LoggerFactory.getLogger(DataWriter.class);

    public void save(Path path, List<Station> stationList) {
        validateIfPathIsAccessible(path);
        LOGGER.info("Saving data.. to {}", path.toString());
        final String content = stationList.stream().map(Station::asLine).collect(Collectors.joining(StringUtils.CHAR_SEQUENCE_NEW_LINE));
        try {
            Files.write(path, content.getBytes());
            LOGGER.info("Date saved to file :{}", path);
        } catch (IOException exception) {
            LOGGER.error("Unable to save due {}", exception.getMessage(), exception);
        }
    }
}
