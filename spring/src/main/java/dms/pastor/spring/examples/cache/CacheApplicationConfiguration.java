package dms.pastor.spring.examples.cache;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheApplicationConfiguration {

    @Bean
    public BookRepository bookRepository() {
        return new DummyBookRepository();
    }
}
