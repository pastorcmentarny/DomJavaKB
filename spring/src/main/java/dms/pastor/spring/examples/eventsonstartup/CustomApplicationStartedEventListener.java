package dms.pastor.spring.examples.eventsonstartup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;
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
public class CustomApplicationStartedEventListener implements ApplicationListener<ApplicationStartingEvent> {
    private static final Logger LOG = LoggerFactory.getLogger(CustomApplicationStartedEventListener.class);

    @Override
    public void onApplicationEvent(ApplicationStartingEvent event) {
        LOG.info("))]}> CustomApplicationStartedEventListener. Application started. This is running after registration of listeners and initializers and before but before any processing.");
    }
}

