package dms.pastor.spring.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class BritishTrainsListTest {

    @Test
    void getSuperVoyagerAcceptanceTest() {
        // when
        final var superVoyager = BritishTrainsList.getSuperVoyager();

        // then
        assertThat(superVoyager.getBritishClass()).isEqualTo("221");
        assertThat(superVoyager.isTilting()).isTrue();
    }

    @Test
    void getPendolinoAcceptanceTest() {
        // when
        final var pendolino = BritishTrainsList.getPendolino();

        // then
        assertThat(pendolino.getBritishClass()).isEqualTo("390");
        assertThat(pendolino.isTilting()).isTrue();
    }
}