package dms.pastor.spring.exercises.interestrates.services;

import java.math.BigDecimal;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class IndividualSavingsProfitCalculatorService implements SavingsProfitCalculatorService {

    @Override
    public BigDecimal calculateAnnualProfitFor(BigDecimal savings, BigDecimal interestRate) {
        //validatePositiveBigDecimal(savings);
        return null;
    }
}
