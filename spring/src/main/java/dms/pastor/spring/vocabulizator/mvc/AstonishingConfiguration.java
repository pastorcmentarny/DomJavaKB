package dms.pastor.spring.vocabulizator.mvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_SINGLETON;

/**
 * Author Dominik Symonowicz
 * Created 15/09/2016
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
@Configuration
public class AstonishingConfiguration {

    @Bean
    @Scope(value = SCOPE_SINGLETON) //if you need set scope for bean (Singleton is a default , I left here as an example
    public ServiceInterface legendaryService(){
        return new LegendaryService();
    }


}
