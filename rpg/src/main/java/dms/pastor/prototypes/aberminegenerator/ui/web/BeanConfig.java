package dms.pastor.prototypes.aberminegenerator.ui.web;

import dms.pastor.prototypes.aberminegenerator.Activity;
import dms.pastor.prototypes.aberminegenerator.Wanderer;
import dms.pastor.prototypes.aberminegenerator.model.generators.WorldGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public Activity activity() {
        return new Activity(Wanderer.withRandomNameAt(10, 3), WorldGenerator.generateFromFile());
    }
}
