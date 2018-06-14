package dms.pastor.tools.trips.tube.station;

import dms.pastor.domain.exception.SomethingWentWrongException;

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

    public static TubeStation convert(String stationAsString) {
        final String[] validatedLine = StationLineValidator.validate(stationAsString);
        return new TubeStation(validatedLine[0], Status.fromValue(validatedLine[1]), Line.noLine(), setDateFor(validatedLine[3]), setDateFor(validatedLine[4]), setDateFor(validatedLine[5]), wasBlogged(validatedLine[6]));
    }

    private static boolean wasBlogged(String value) {
        if (value == null || !value.equals("Y")) {
            return false;
        } else if (value.equalsIgnoreCase("Y")) {
            return true;
        } else {
            throw new SomethingWentWrongException("Eee... what's that? " + value + " ??? It should be Y or N.");
        }
    }

    private static LocalDate setDateFor(String date) {
        return Objects.isNull(date) || "none".equalsIgnoreCase(date) ? null : LocalDate.parse(date);
    }
}
