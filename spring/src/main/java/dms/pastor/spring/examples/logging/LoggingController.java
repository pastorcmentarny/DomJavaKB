package dms.pastor.spring.examples.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * <p>
 * tag-log
 */
@Controller
public class LoggingController {

    //TODO add logging service
    private static final String ADDING_TO_LOG = "Adding {} to logs";
    private static final String TRACE = "trace";
    private static final String DEBUG = "debug";
    private static final String INFO = "info";
    private static final String WARN = "warn";
    private static final String ERROR = "ERROR";
    private final Logger LOGGER = LoggerFactory.getLogger(LoggingController.class);

    private void addLog(List<String> logTypes) {
        LOGGER.trace(ADDING_TO_LOG, TRACE);
        logTypes.add(TRACE);
    }

}
