package dms.pastor.tools.trips.tube.data;

import dms.pastor.tools.trips.tube.station.ToStationConverter;
import dms.pastor.tools.trips.tube.station.TubeStation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static dms.pastor.utils.ValidatorUtils.validateIfPathExists;
import static java.util.Collections.emptyList;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class DataUploader {
    private static final Logger LOGGER = LoggerFactory.getLogger(DataUploader.class);

    public List<TubeStation> load(String path) {
        LOGGER.info("Loading data from " + path);
        validateIfPathExists(path);
        try (Stream<String> lines = Files.lines(Paths.get(path))) {
            final List<TubeStation> tubeStationList = lines.map(ToStationConverter::convert).collect(Collectors.toList());
            LOGGER.info("Data loaded.");
            return tubeStationList;
        } catch (IOException e) {
            LOGGER.error("Unable to load data as something went wrong! " + e.getMessage(), e);
        }
        return emptyList();
    }

}