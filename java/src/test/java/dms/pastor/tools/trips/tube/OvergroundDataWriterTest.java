package dms.pastor.tools.trips.tube;

import dms.pastor.tools.trips.common.data.DataUploader;
import dms.pastor.tools.trips.common.data.DataWriter;
import dms.pastor.tools.trips.common.station.Station;
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
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
public class OvergroundDataWriterTest {


    @Test
    public void saveShouldThrowIllegalArgumentExceptionIfPathIsNull() {

        // given
        DataWriter writer = new DataWriter();
        final Station amershamStation = new Station("Amersham", null, null, null, null, true);
        List<Station> stations = Collections.singletonList(amershamStation);

        // when
        Assertions.assertThrows(IllegalArgumentException.class, () -> writer.save(null, stations));

    }

    @Test
    public void shouldSaveStationToFile() throws Exception {
        // given
        DataWriter writer = new DataWriter();

        // delete if exists
        final File file = File.createTempFile("station", ".txt");

        final Station amershamStation = new Station("Amersham", VISITED, LocalDate.now(), LocalDate.now(), LocalDate.now(), true);
        final Station cheshamStation = Station.passed("Pinner", LocalDate.now());
        List<Station> stations = new ArrayList<>();
        stations.add(amershamStation);
        stations.add(cheshamStation);

        // when
        writer.save(file.toPath(), stations);

        // then
        final var size = new DataUploader().load(file.toPath()).size();
        assertThat(size).isEqualTo(2);
    }

}
