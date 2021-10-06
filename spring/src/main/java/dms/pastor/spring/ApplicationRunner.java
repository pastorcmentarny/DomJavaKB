package dms.pastor.spring;

import dms.pastor.spring.examples.eventsonstartup.CustomApplicationEnvironmentPreparedEventListener;
import dms.pastor.spring.examples.eventsonstartup.CustomApplicationFailedEventListener;
import dms.pastor.spring.examples.eventsonstartup.CustomApplicationPreparedEventListener;
import dms.pastor.spring.examples.eventsonstartup.CustomApplicationReadyEventListener;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@SpringBootApplication
@EnableCaching
public class ApplicationRunner {
    public static void main(String[] args) {

        new SpringApplicationBuilder()
                .sources(ApplicationRunner.class) //You pass ApplicationRunner.class as an argument to the run method to tell SpringApplication which is the primary Spring component.
                .listeners(new CustomApplicationEnvironmentPreparedEventListener(),
                        new CustomApplicationPreparedEventListener(),
                        new CustomApplicationReadyEventListener(),
                        new CustomApplicationFailedEventListener())
                .run(args); //The args array is also passed through to expose any command-line arguments.
    }

}
