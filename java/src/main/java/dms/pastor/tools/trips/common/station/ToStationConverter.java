package dms.pastor.tools.trips.common.station;

import dms.pastor.tools.trips.common.options.Status;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public final class ToStationConverter {

    private ToStationConverter() {
    }

    public static Station convert(String stationAsString) {
        final String[] validatedLine = StationLineValidator.validate(stationAsString);
        return new Station(validatedLine[0], Status.fromValue(validatedLine[1]), setDateFor(validatedLine[2]), setDateFor(validatedLine[3]), setDateFor(validatedLine[4]), wasBlogged(validatedLine[5]));
    }

    private static boolean wasBlogged(String value) {
        return value != null && value.equals("Y");
    }

    private static LocalDate setDateFor(String date) {
        return Objects.isNull(date) || "none".equalsIgnoreCase(date) ? null : LocalDate.parse(date);
    }
}
