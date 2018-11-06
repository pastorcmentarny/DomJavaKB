package dms.pastor.spring.vocabulizator;

import dms.pastor.spring.vocabulizator.check.DefaultDefinitionService;
import dms.pastor.spring.vocabulizator.check.DefinitionService;
import dms.pastor.spring.vocabulizator.check.db.DefinitionRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author Dominik Symonowicz
 * Created 27/10/2016
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
@Configuration
public class ApplicationAutoConfiguration {

    @Bean
    public DefinitionService definitionService(DefinitionRepository definitionRepository){
        return new DefaultDefinitionService(definitionRepository);
    }
}
