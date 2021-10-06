package dms.pastor.spring.examples.eventsonstartup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.context.ApplicationListener;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class CustomApplicationFailedEventListener implements ApplicationListener<ApplicationFailedEvent> {
    private static final Logger LOG = LoggerFactory.getLogger(CustomApplicationFailedEventListener.class);

    @Override
    public void onApplicationEvent(ApplicationFailedEvent event) {
        LOG.error("))]}>CustomApplicationFailedEventListener Something went wrong :(");
    }
}
