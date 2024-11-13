package dms.pastor.spring.exercises.interestrates;

import dms.pastor.spring.exercises.interestrates.services.IndividualSavingInterestRatesService;
import dms.pastor.spring.exercises.interestrates.services.SavingInterestRatesService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author Dominik Symonowicz
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@Configuration
public class SavingInterestRatesAutoConfiguration {

    @Bean
    public SavingInterestRatesService savingInterestRatesService() {
        return new IndividualSavingInterestRatesService();
    }
}
