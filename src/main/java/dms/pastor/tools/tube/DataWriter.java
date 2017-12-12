package dms.pastor.tools.tube;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static dms.pastor.utils.ValidatorUtils.validateIfPathExists;
import static java.lang.String.format;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
class DataWriter {
    private static final Logger LOGGER = LoggerFactory.getLogger(DataWriter.class);

    public void save(String path, List<Station> stationList) {
        validateIfPathExists(path);
        final String content = stationList.stream().map(Station::asLine).collect(Collectors.joining("\n"));
        try {
            Files.write(Paths.get(path), content.getBytes());
            LOGGER.info("Date saved to file :" + path);
        } catch (IOException e) {
            LOGGER.error(format("Unable to save due %s", e.getMessage()), e);
        }
    }
}
