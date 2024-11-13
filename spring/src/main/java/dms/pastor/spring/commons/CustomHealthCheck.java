package dms.pastor.spring.commons;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

/**
 * Author Dominik Symonowicz
 * Created 02/10/2018
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@Component
public class CustomHealthCheck implements HealthIndicator {
    @Override
    public Health health() {
        int errorCode = 0;
        LocalTime now = LocalTime.now();
        if (now.getMinute() % 2 != 0) {
            errorCode = 1;
        }

        if (errorCode != 0) {
            return Health.status("AWESOME").withDetail("Error Code", errorCode).build();
        }
        return Health.up().build();
    }
}