package dms.pastor.spring.examples.eventsonstartup;

import org.slf4j.Logger;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Author Dominik Symonowicz
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@Component
public class CustomApplicationReadyEventListener implements ApplicationListener<ApplicationReadyEvent> {
    private static final Logger LOG = getLogger(CustomApplicationReadyEventListener.class);

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        LOG.info("))]}>CustomApplicationReadyEventListener. This event is sent after the refresh and any related callbacks have been processed to indicate the application is ready to service requests.");
    }
}
