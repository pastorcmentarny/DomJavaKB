package dom.coffirgar.transportmanager.services;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DataOperationsTest {

    @Test
    void loadFromFile() {
        // when
        final var stations = DataOperations.loadFromFile();

        // debug
        System.out.println(stations);

        // then
        assertThat(stations.size()).isEqualTo(271);


    }
}