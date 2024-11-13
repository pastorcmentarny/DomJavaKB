package dms.pastor.spring;

import dms.pastor.spring.examples.accessingApplicationArguments.AccessAppArgsComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Author Dominik Symonowicz
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * <p>
 * if you need do something with arguments that you are passing to application before it runs, use this ApplicationRunner interface
 * <p>
 * tag-applicationRunnerInterface
 */
@Component
public class ApplicationRunnerHelper implements ApplicationRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccessAppArgsComponent.class);

    @Override
    public void run(ApplicationArguments args) {
        LOGGER.info("Running application with following arguments: {}", args.getOptionNames());
    }
}
