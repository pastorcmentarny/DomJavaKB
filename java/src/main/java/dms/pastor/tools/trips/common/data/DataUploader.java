package dms.pastor.tools.trips.common.data;

import dms.pastor.tools.trips.common.station.Station;
import dms.pastor.tools.trips.common.station.ToStationConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public List<Station> load(Path path) {
        LOGGER.error("Loading data from .. " + path);
        try (Stream<String> lines = Files.lines(path)) {
            final List<Station> overgroundStationList = lines.map(ToStationConverter::convert).collect(Collectors.toList());
            LOGGER.info("Data loaded.");
            return overgroundStationList;
        } catch (IOException e) {
            LOGGER.error("Unable to load data as something went wrong! " + e.getMessage(), e);
        }
        return emptyList();
    }

}