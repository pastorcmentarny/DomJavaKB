package dms.pastor.spring.exercises.interestrates.services;

import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class IndividualSavingInterestRatesService implements SavingInterestRatesService {

    private static final BigDecimal LOW_INTEREST_RATE = new BigDecimal("0.50");
    private static final BigDecimal MEDIUM_INTEREST_RATE = new BigDecimal("1.75");
    private static final BigDecimal HIGH_INTEREST_RATE = new BigDecimal("5.00");

    private static final BigDecimal HIGH_SAVINGS = new BigDecimal("250000.00");
    private static final BigDecimal MEDIUM_SAVINGS = new BigDecimal("75000.00");

    @Override
    public BigDecimal calculateSavingInterestRates(BigDecimal saving) {
        //validatePositiveBigDecimal(saving);
        return getSavingInterestFor(saving);
    }

    private BigDecimal getSavingInterestFor(BigDecimal saving) {
        if (saving.compareTo(HIGH_SAVINGS) >= 0) {
            return HIGH_INTEREST_RATE;
        } else if (saving.compareTo(MEDIUM_SAVINGS) >= 0) {
            return MEDIUM_INTEREST_RATE;
        } else if (saving.compareTo(ZERO) > 0) {
            return LOW_INTEREST_RATE;
        } else {
            return ZERO;
        }
    }

}
