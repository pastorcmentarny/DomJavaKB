package dms.pastor.spring.examples.crud;

import dms.pastor.spring.commons.exceptions.NotFoundException;
import dms.pastor.spring.model.Train;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static dms.pastor.spring.model.TractionType.DEMU;
import static dms.pastor.spring.model.TractionType.DMU;
import static org.assertj.core.api.Assertions.assertThat;

class DummyTrainRepositoryTest {
    private DummyTrainRepository dummyTrainRepository = new DummyTrainRepository();

    @BeforeEach
    public void setup() {
        dummyTrainRepository.reboot();
    }

    @Test
    public void trainCountShouldReturnOne() {
        // given
        final Train example = Train.builder().britishClass("221").maxSpeed(200).tilting(true).name("Super Voyager").type(DMU).build();
        dummyTrainRepository.save(example);

        // when
        final var result = dummyTrainRepository.getTrainsCountInRepository();

        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void addShouldThrowExceptionIfTrainExistsInRepository() {
        // given
        final Train example1 = Train.builder().britishClass("221").maxSpeed(200).tilting(true).name("Super Voyager").type(DMU).build();
        dummyTrainRepository.save(example1);

        // when & then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            dummyTrainRepository.save(example1);
        });

        // then
        assertThat(dummyTrainRepository.getTrainsCountInRepository()).isEqualTo(1);
    }

    @Test
    public void addShouldThrowExceptionIfNewTrainIsNullInRepository() {
        // given
        final Train example1 = Train.builder().britishClass("221").maxSpeed(200).tilting(true).name("Super Voyager").type(DMU).build();
        dummyTrainRepository.save(example1);

        // when & then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            dummyTrainRepository.save(null);
        });

        // then
        assertThat(dummyTrainRepository.getTrainsCountInRepository()).isEqualTo(1);
    }

    @Test
    public void shouldAddTrainToRepository() {
        // given
        final Train example1 = Train.builder().britishClass("221").maxSpeed(200).tilting(true).name("Super Voyager").type(DMU).build();
        final Train example2 = Train.builder().britishClass("220").maxSpeed(200).tilting(false).name("Voyager").type(DMU).build();
        dummyTrainRepository.save(example1);

        // when
        var result = dummyTrainRepository.getTrainsCountInRepository();

        // then
        assertThat(result).isEqualTo(1);

        dummyTrainRepository.save(example2);

        // when
        result = dummyTrainRepository.getTrainsCountInRepository();

        // then
        assertThat(result).isEqualTo(2);
    }


    @Test
    public void rebootShouldMakeTrainRepositoryEmpty() {
        // given
        final Train example1 = Train.builder().britishClass("221").maxSpeed(200).tilting(true).name("Super Voyager").type(DMU).build();
        final Train example2 = Train.builder().britishClass("220").maxSpeed(200).tilting(false).name("Voyager").type(DMU).build();
        dummyTrainRepository.save(example1);
        dummyTrainRepository.save(example2);

        // verify
        var result = dummyTrainRepository.getTrainsCountInRepository();
        assertThat(result).isEqualTo(2);

        // when
        dummyTrainRepository.reboot();

        // then
        result = dummyTrainRepository.getTrainsCountInRepository();
        assertThat(result).isZero();
    }

    @Test
    public void deleteShouldDeleteRecordFromTrainRepository() {
        // given
        final Train example1 = Train.builder().britishClass("221").maxSpeed(200).tilting(true).name("Super Voyager").type(DMU).build();
        final Train example2 = Train.builder().britishClass("220").maxSpeed(200).tilting(false).name("Voyager").type(DMU).build();
        dummyTrainRepository.save(example1);
        dummyTrainRepository.save(example2);

        // verify
        var trainListSize = dummyTrainRepository.getTrainsCountInRepository();
        assertThat(trainListSize).isEqualTo(2);

        // when
        dummyTrainRepository.delete("221");

        // then
        final int sizeAfterDelete = dummyTrainRepository.getTrainsCountInRepository();
        assertThat(sizeAfterDelete).isOne();
        final Train result = dummyTrainRepository.load("220");
        assertThat(result).isEqualTo(example2);
    }

    @Test
    public void deleteShouldThrowExceptionIfTrainDoNotExistsInRepository() {
        // given
        final Train example1 = Train.builder().britishClass("221").maxSpeed(200).tilting(true).name("Super Voyager").type(DMU).build();
        final Train example2 = Train.builder().britishClass("220").maxSpeed(200).tilting(false).name("Voyager").type(DMU).build();
        dummyTrainRepository.save(example1);
        dummyTrainRepository.save(example2);


        // when
        Assertions.assertThrows(NotFoundException.class, () -> {
            dummyTrainRepository.delete("390");
        });

    }

    @Test
    public void deleteShouldThrowExceptionIfTrainIsNull() {
        // given
        final Train example1 = Train.builder().britishClass("221").maxSpeed(200).tilting(true).name("Super Voyager").type(DMU).build();
        final Train example2 = Train.builder().britishClass("220").maxSpeed(200).tilting(false).name("Voyager").type(DMU).build();
        dummyTrainRepository.save(example1);
        dummyTrainRepository.save(example2);


        // when
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            dummyTrainRepository.delete(null);
        });

    }

    @Test
    public void shouldUpdateTrainInRepository() {
        // given
        final Train example1 = Train.builder().britishClass("221").maxSpeed(200).tilting(true).name("Super Voyager").type(DMU).build();
        final Train example2 = Train.builder().britishClass("220").maxSpeed(200).tilting(false).name("Voyager").type(DMU).build();
        final Train updatedExample2 = Train.builder().britishClass("220").maxSpeed(200).tilting(false).name("Voyager").type(DEMU).build();
        dummyTrainRepository.save(example1);
        dummyTrainRepository.save(example2);

        // when
        dummyTrainRepository.update(updatedExample2);

        // then
        assertThat(dummyTrainRepository.getTrainsCountInRepository()).isEqualTo(2);

        // and when
        final var result = dummyTrainRepository.load("220");

        // then
        assertThat(result).isEqualTo(updatedExample2);
        assertThat(result).isNotEqualTo(example2);

    }

    @Test
    public void updateShouldThrowExceptionIfTrainDoNotExistsInRepository() {
        // given
        final Train example1 = Train.builder().britishClass("221").maxSpeed(200).tilting(true).name("Super Voyager").type(DMU).build();
        dummyTrainRepository.save(example1);
        final Train example2 = Train.builder().britishClass("220").maxSpeed(200).tilting(false).name("Voyager").type(DMU).build();

        // when
        Assertions.assertThrows(NotFoundException.class, () -> {
            dummyTrainRepository.update(example2);
        });

    }

    @Test
    public void updateShouldThrowExceptionIfTrainIsNull() {
        // given
        final Train example1 = Train.builder().britishClass("221").maxSpeed(200).tilting(true).name("Super Voyager").type(DMU).build();
        dummyTrainRepository.save(example1);

        // when
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            dummyTrainRepository.update(null);
        });

    }
}