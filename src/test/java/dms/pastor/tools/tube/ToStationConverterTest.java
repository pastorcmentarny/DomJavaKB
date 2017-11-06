package dms.pastor.tools.tube;

import org.junit.Test;

import static dms.pastor.tools.tube.Status.NOT_VISITED;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 02/11/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class ToStationConverterTest {

    @Test
    public void convertShouldConvertStationAsStringToObject() {
        // given
        final String stationAsString = "Chesham";
        final Station expectedStation = new Station(stationAsString, NOT_VISITED, null);

        // when
        final Station station = ToStationConverter.convert(stationAsString);

        // then
        assertThat(station).isEqualTo(expectedStation);
    }

}
