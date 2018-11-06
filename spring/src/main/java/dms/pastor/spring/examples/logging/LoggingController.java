package dms.pastor.spring.examples.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

import static dms.pastor.spring.examples.TemplatePaths.LOGGING_TEMPLATE;

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

    @RequestMapping("/logging")
    String logging(Model model) {
        List<String> logTypes = new ArrayList<>();

        addLog(logTypes);

        LOGGER.debug(ADDING_TO_LOG, DEBUG);
        logTypes.add(DEBUG);

        LOGGER.info(ADDING_TO_LOG, INFO);
        logTypes.add(INFO);

        LOGGER.warn(ADDING_TO_LOG, WARN);
        logTypes.add(WARN);

        LOGGER.error(ADDING_TO_LOG, ERROR);
        logTypes.add(ERROR);

        model.addAttribute("logs", logTypes);
        return LOGGING_TEMPLATE;
    }

    private void addLog(List<String> logTypes) {
        LOGGER.trace(ADDING_TO_LOG, TRACE);
        logTypes.add(TRACE);
    }

}
