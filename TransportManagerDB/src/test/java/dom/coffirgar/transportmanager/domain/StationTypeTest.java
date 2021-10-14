package dom.coffirgar.transportmanager.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static dom.coffirgar.transportmanager.domain.StationType.*;
import static org.assertj.core.api.Assertions.assertThat;

class StationTypeTest {

    @ParameterizedTest
    @MethodSource("provideValidTypesForTube")
    void isTubeStationShouldReturnTrueForTypesContainsTube(StationType input) {
        // debug
        System.out.println("Type: " + input + " to check for isTubeType()");

        // when
        var result = StationType.isTubeType(input);

        // then
        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @MethodSource("provideInvalidTypesForTube")
    void isTubeStationShouldReturnFalseForTypesThatDoesNotContainsTube(StationType input) {
        // debug
        System.out.println("Type: " + input + " to check for isTubeType()");

        // when
        var result = StationType.isTubeType(input);

        // then
        assertThat(result).isFalse();
    }

    @ParameterizedTest
    @MethodSource("provideValidTypesForTrain")
    void isTrainStationShouldReturnTrueForTypesContainsTrain(StationType input) {
        // debug
        System.out.println("Type: " + input + " to check for isTrainType()");

        // when
        var result = StationType.isTrainType(input);

        // then
        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @MethodSource("provideInvalidTypesForTrain")
    void isTrainStationShouldReturnFalseForTypesThatDoesNotContainsTrain(StationType input) {
        // debug
        System.out.println("Type: " + input + " to check for isTrainType()");

        // when
        var result = StationType.isTrainType(input);

        // then
        assertThat(result).isFalse();
    }

    @ParameterizedTest
    @MethodSource("provideValidTypesForOverground")
    void isOvergroundStationShouldReturnTrueForTypesContainsOverground(StationType input) {
        // debug
        System.out.println("Type: " + input + " to check for isOvergroundType()");

        // when
        var result = StationType.isOvergroundType(input);

        // then
        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @MethodSource("provideInvalidTypesForOverground")
    void isOvergroundStationShouldReturnFalseForTypesThatDoesNotContainsOverground(StationType input) {
        // debug
        System.out.println("Type: " + input + " to check for isOvergroundType()");

        // when
        var result = StationType.isOvergroundType(input);

        // then
        assertThat(result).isFalse();
    }

    private static Stream<Arguments> provideValidTypesForTube() {
        return Stream.of(
                Arguments.of(TUBE),
                Arguments.of(TUBE_TRAIN),
                Arguments.of(TUBE_OVERGROUND),
                Arguments.of(TUBE_OVERGROUND_TRAIN)
        );
    }


    private static Stream<Arguments> provideInvalidTypesForTube() {
        return Stream.of(
                Arguments.of(OVERGROUND),
                Arguments.of(TRAIN),
                Arguments.of(TRAIN_OVERGROUND)
        );
    }

    private static Stream<Arguments> provideValidTypesForTrain() {
        return Stream.of(
                Arguments.of(TRAIN),
                Arguments.of(TUBE_TRAIN),
                Arguments.of(TRAIN_OVERGROUND),
                Arguments.of(TUBE_OVERGROUND_TRAIN)
        );
    }

    private static Stream<Arguments> provideInvalidTypesForTrain() {
        return Stream.of(
                Arguments.of(OVERGROUND),
                Arguments.of(TUBE),
                Arguments.of(TUBE_OVERGROUND)
        );
    }

    private static Stream<Arguments> provideValidTypesForOverground() {
        return Stream.of(
                Arguments.of(OVERGROUND),
                Arguments.of(TUBE_OVERGROUND),
                Arguments.of(TRAIN_OVERGROUND),
                Arguments.of(TUBE_OVERGROUND_TRAIN)
        );
    }

    private static Stream<Arguments> provideInvalidTypesForOverground() {
        return Stream.of(
                Arguments.of(TRAIN),
                Arguments.of(TUBE),
                Arguments.of(TUBE_TRAIN)
        );
    }
}