package dms.pastor.spring.examples.profiles;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * tag-profile-specific-properties
 */
@Profile("dom") // <- annotation that specify which  profile should use below component
@Component
public class DomProfilesExample {

    @Value("${app.test.value}")
    private String value;

    @Bean
    String luckyNumber() {
        return value + ":" + new BigDecimal("7.77");
    }

}
