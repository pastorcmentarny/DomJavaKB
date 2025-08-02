package dms.pastor.domain;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class TrainsTest {

    @Test
    void getAllTrains() {
        // given, when and then
        assertEquals(7, Trains.getAllTrains().size());
    }


    @Test
    void findTrainByIdShouldReturnFalseForNullTest() {
        // given & when
        final Optional<Train> result = Trains.findTrainById(null);

        // then
        assertFalse(result.isPresent());
    }

    @Test
    void findTrainByIdShouldReturnFalseForEmptyTest() {
        // given & when
        final Optional<Train> result = Trains.findTrainById("");

        // then
        assertFalse(result.isPresent());
    }

    @Test
    void findTrainByIdShouldReturnFalseForNonExistingTrainIdTest() {
        // given & when
        final Optional<Train> result = Trains.findTrainById("NonExistingTrainId");

        // then
        assertFalse(result.isPresent());
    }

    @Test
    void findTrainByIdShouldReturnTrueForValidTrainIdTest() {
        // given & when
        final Optional<Train> result = Trains.findTrainById("BritishClass395");

        // then
        assertTrue(result.isPresent());
        var train = result.orElseThrow();

        //debug
        System.out.println(train);

        // and then
        assertEquals("BritishClass395", train.getTrainId());
        assertEquals(TrainType.EMU, train.getTrainType() );
        assertEquals(225, train.getMaxSpeed());
    }
}