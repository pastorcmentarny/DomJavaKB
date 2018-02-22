package dms.pastor.tools.lotto.common;

import dms.pastor.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

import static dms.pastor.tools.lotto.LottoConstants.DASH;
import static java.lang.String.format;

/**
 * Author Dominik Symonowicz
 * Created 22/02/2018
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public final class LottoValidator {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerFactory.class);

    private LottoValidator() {
    }

    public static void validateDate(String drawDate) {

        if (drawDate == null || drawDate.isEmpty() || drawDate.split(DASH).length != 3) {
            throw new IllegalArgumentException(format("Date format is not valid.It should be dd-MMM-YYYY (for example 01-JAN-2016) but it was %s", drawDate));
        }
        final String[] date = drawDate.split(DASH);
        try {
            LocalDate.of(Integer.parseInt(date[2]), DateUtils.getMonthNumberFromShortedName(date[1]), Integer.parseInt(date[0]));
        } catch (Exception e) {
            LOGGER.warn(format("validation failed due %s", e.getMessage()), e);
            throw new IllegalArgumentException(e);
        }
    }

}
