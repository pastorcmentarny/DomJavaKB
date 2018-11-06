package dms.pastor.spring.examples.accessingApplicationArguments;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@Component
public class AccessAppArgsComponent {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccessAppArgsComponent.class);
    private String[] argsList;

    @Autowired
    public AccessAppArgsComponent(ApplicationArguments args) {
        LOGGER.info("AccessAppArgsComponent init");
        argsList = args.getSourceArgs();
    }

    String[] getArgsList() {
        LOGGER.info("getting list..");
        return argsList;
    }
}
