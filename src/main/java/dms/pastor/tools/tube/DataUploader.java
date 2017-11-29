package dms.pastor.tools.tube;

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
class DataUploader {
    private static final Logger LOGGER = LoggerFactory.getLogger(DataUploader.class);

    List<Station> load(String path) {
        LOGGER.info("Loading data from " + path);
        validateIfPathExists(path);
        try (Stream<String> lines = Files.lines(Paths.get(path))) {
            final List<Station> stationList = lines.map(ToStationConverter::convert).collect(Collectors.toList());
            LOGGER.info("Data loaded.");
            return stationList;
        } catch (IOException e) {
            LOGGER.error("Unable to load data as something went wrong! " + e.getMessage(), e);
        }
        return emptyList();
    }

}