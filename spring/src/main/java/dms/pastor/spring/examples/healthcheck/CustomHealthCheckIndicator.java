package dms.pastor.spring.services;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

//TODO add practical version
@Component
public class DomHealthIndicator implements HealthIndicator {
    private final String messageKey = "ExampleService";

    @Override
    public Health health() {
        return Health.up().withDetail(messageKey,"Service works").build();
    }
}

