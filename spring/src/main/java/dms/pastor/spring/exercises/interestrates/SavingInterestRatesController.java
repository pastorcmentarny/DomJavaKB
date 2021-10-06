package dms.pastor.spring.exercises.interestrates;

import dms.pastor.spring.exercises.interestrates.services.SavingInterestRatesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

import static dms.pastor.spring.examples.Paths.SAVINGS;
import static dms.pastor.spring.examples.TemplatePaths.SAVING_INTEREST_RATES_TEMPLATE;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@Controller
public class SavingInterestRatesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SavingInterestRatesController.class);

    private final SavingInterestRatesService savingInterestRatesService;

    public SavingInterestRatesController(SavingInterestRatesService savingInterestRatesService) {
        this.savingInterestRatesService = savingInterestRatesService;
    }

    @GetMapping(SAVINGS)
    public String getSavingInterestRates(@RequestParam BigDecimal savings, Model model) {
        LOGGER.info("Getting Saving Interest Rates for savings {}", savings);
        final BigDecimal interestRates = savingInterestRatesService.calculateSavingInterestRates(savings);
        model.addAttribute("savings", savings);
        model.addAttribute("rate", interestRates);
        LOGGER.info("Returning Saving Interest Rates {} for savings {}", interestRates, savings);
        return SAVING_INTEREST_RATES_TEMPLATE;
    }

}
