package dom.coffirgar.transportmanager.controllers;

import dom.coffirgar.transportmanager.AbstractFunctionalTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class TubeLinesControllerFunctionalTest extends AbstractFunctionalTest {
    @Autowired
    private TubeLinesController tubeLinesController;

    @Test
    public void shouldWiredStationController() {
        // test if controller is set up
        assertThat(tubeLinesController).isNotNull();
    }
}