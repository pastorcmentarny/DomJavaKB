package dom.coffirgar.transportmanager.components;

import dom.coffirgar.transportmanager.utlis.UpdateBuildVersionOnStartup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@Slf4j
@Component
public class VersionUpdaterWhenApplicationReady implements ApplicationListener<ApplicationReadyEvent> {


    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        log.debug("Updating build...");
        final var buildNumber = UpdateBuildVersionOnStartup.updateVersion();
        log.debug("Current buildNumber is " + buildNumber);

    }
}

