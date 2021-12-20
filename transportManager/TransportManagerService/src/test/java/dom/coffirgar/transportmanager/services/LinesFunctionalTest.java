package dom.coffirgar.transportmanager.services;

import dom.coffirgar.transportmanager.AbstractFunctionalTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class LinesFunctionalTest extends AbstractFunctionalTest {

    @Autowired
    private StationsService stationsService;

    @Test
    public void shouldWiredStationServiceTest() {
        // test if controller is set up
        assertThat(stationsService).isNotNull();
    }
}