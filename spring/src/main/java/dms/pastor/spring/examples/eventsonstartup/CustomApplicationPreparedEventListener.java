package dms.pastor.spring.examples.eventsonstartup;

import org.slf4j.Logger;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class CustomApplicationPreparedEventListener implements ApplicationListener<ApplicationPreparedEvent> {
    private static final Logger LOG = getLogger(CustomApplicationEnvironmentPreparedEventListener.class);

    @Override
    public void onApplicationEvent(ApplicationPreparedEvent event) {
        LOG.info("))]}>CustomApplicationPreparedEventListener. This event is sent just before the refresh is started," +
                " but after bean definitions have been loaded.");
    }
}
