package dms.pastor.spring.tools.getdone;

import dms.pastor.spring.tools.getdone.services.TaskServiceDummy;
import dms.pastor.spring.tools.getdone.services.TaskServiceI;
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
public class AppConfiguration {

    @Bean
    public TaskServiceI taskService() {
        return new TaskServiceDummy();
    }

		/* TODO figure out how jsp works 
         * 	@Bean
		    public ViewResolver getViewResolver() {
		        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		        resolver.setPrefix("/WEB-INF/");
		        resolver.setSuffix(".jsp");
		        System.out.println("View Resolver active");
		        return resolver;
		    }
		 */

}
