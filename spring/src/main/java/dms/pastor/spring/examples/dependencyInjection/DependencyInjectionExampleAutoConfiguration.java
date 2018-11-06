package dms.pastor.spring.examples.dependencyInjection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@Configuration
public class DependencyInjectionExampleAutoConfiguration {

    @Bean
    DataValidator dataValidator() {
        return new DefaultDataValidator();
    }

    @Bean
    DataService dataService(DataValidator dataValidator) {
        return new DataService(dataValidator);
    }

}
