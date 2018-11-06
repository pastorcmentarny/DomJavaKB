package dms.pastor.spring.examples.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Random;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@RestController
public class RestExamplesController {
    private static final Logger LOGGER = LoggerFactory.getLogger(RestExamplesController.class);

    @GetMapping("/rest")
    public CuteDomainObject restExample() {
        return new CuteDomainObject("Metropolitan Line", randomBigDecimal().intValue());
    }

    private BigDecimal randomBigDecimal() {
        return new BigDecimal(new Random().nextInt(1000));
    }

    @GetMapping("/rest/with-args")
    public CuteDomainObject restExampleWithVariables(@RequestParam Integer number) {
        LOGGER.info("Number:" + number);
        if (number == null) {
            number = Integer.MIN_VALUE;
        }
        return new CuteDomainObject("Number", number);
    }


}
