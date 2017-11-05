package dms.pastor.tools.tube;

import dms.pastor.utils.ValidatorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

/**
 * Author Dominik Symonowicz
 * Created 03/11/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class DataWriter {
    private static final Logger LOGGER = LoggerFactory.getLogger(DataWriter.class);

    public void save(String path, List<Station> stationList) {
        ValidatorUtils.validateIfPathExists(path);
        final String content = stationList.stream().map(Station::toString).collect(Collectors.joining("\n"));
        try {
            Files.write(Paths.get(path), content.getBytes());
        } catch (IOException e) {
            LOGGER.error(format("Unable to save due %s", e.getMessage()), e);
        }
    }
}
