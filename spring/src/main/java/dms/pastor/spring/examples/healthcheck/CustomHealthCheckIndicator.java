package dms.pastor.spring.examples.healthcheck;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

//TODO add practical version
@Component
public class CustomHealthCheckIndicator implements HealthIndicator {
    private final String messageKey = "ExampleService";

    @Override
    public Health health() {
        return Health.up().withDetail(messageKey, "Service works").build();
    }
}

