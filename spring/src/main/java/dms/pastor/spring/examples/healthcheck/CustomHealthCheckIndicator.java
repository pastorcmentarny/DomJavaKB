package dms.pastor.spring.examples.healthcheck;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

//TODO add practical version
@Component
public class CustomHealthCheckIndicator implements HealthIndicator {

    @Override
    public Health health() {
        String messageKey = "ExampleService";
        return Health.up().withDetail(messageKey, "Service works").build();
    }
}

