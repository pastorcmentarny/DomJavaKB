package dms.coffirgar.transportmanager.components;


import dms.coffirgar.transportmanager.utils.UpdateBuildVersionOnStartup;
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
        log.info("Updating build...");
        final var buildNumber = UpdateBuildVersionOnStartup.updateVersion();
        log.info("Current buildNumber is " + buildNumber);

    }
}

