package dms.pastor.spring.tasks.calculator.services.impl;

import dms.pastor.spring.tasks.calculator.models.Result;
import dms.pastor.spring.tasks.calculator.services.CalculationServiceI;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class CalculationService implements CalculationServiceI {

    @Override
    public Result calcAddition(long id, String[] numbers) {
        int counter = 0;
        if (numbers == null) {
            throw new IllegalArgumentException("No numbers given.You need at least 1 number.");
        }
        for (String n : numbers) {
            try {
                counter += Integer.parseInt(n);
            } catch (NumberFormatException nfe) {
                //logger
            }
        }
        return new Result(id, counter);
    }


}
