package dom.coffirgar.transportmanager.mappers;


import dom.coffirgar.transportmanager.domain.stations.Station;
import dom.coffirgar.transportmanager.domain.stations.Status;
import dom.coffirgar.transportmanager.validators.StationLineValidator;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public final class ToStationConverter {

    private ToStationConverter() {
    }

    public static Station convert(String stationAsString) {
        final String[] validatedLine = StationLineValidator.validate(stationAsString);
        return new Station(validatedLine[0], Status.fromValue(validatedLine[1]), setDateFor(validatedLine[2]), setDateFor(validatedLine[3]), setDateFor(validatedLine[4]));
    }


    private static LocalDate setDateFor(String date) {
        return Objects.isNull(date) || "none".equalsIgnoreCase(date) ? null : LocalDate.parse(date);
    }
}
