package dms.pastor.tools.trips.tube;

import dms.pastor.tools.trips.tube.data.DataUploader;
import dms.pastor.tools.trips.tube.data.DataWriter;
import dms.pastor.tools.trips.tube.station.TubeStation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static dms.pastor.tools.trips.common.options.Status.VISITED;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 03/11/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class DataWriterTest {


    @Test
    public void saveShouldThrowIllegalArgumentExceptionIfPathIsNull() {

        // given
        DataWriter writer = new DataWriter();
        final TubeStation amershamTubeStation = new TubeStation("Amersham", null, null, null, null, true);
        List<TubeStation> tubeStations = Collections.singletonList(amershamTubeStation);
        // when
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        writer.save(null, tubeStations);
        });

    }

    @Test
    public void shouldSaveStationToFile() throws Exception {
        // given
        DataWriter writer = new DataWriter();

        // delete if exists
        final File file = File.createTempFile("station", ".txt");

        final TubeStation amershamTubeStation = new TubeStation("Amersham", VISITED, LocalDate.now(), LocalDate.now(), LocalDate.now(), true);
        final TubeStation cheshamTubeStation = TubeStation.passed("Pinner", LocalDate.now());
        List<TubeStation> tubeStations = new ArrayList<>();
        tubeStations.add(amershamTubeStation);
        tubeStations.add(cheshamTubeStation);
        // when
        writer.save(file.toPath(), tubeStations);

        // then
        final var size = new DataUploader().load(file.toPath()).size();
        assertThat(size).isEqualTo(2);
    }

}
