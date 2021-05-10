package dms.pastor.spring.examples.crud;

import dms.pastor.spring.commons.exceptions.NotFoundException;
import dms.pastor.spring.model.Train;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class DummyTrainRepository {
    private final List<Train> trains = new ArrayList<>();


    public void save(Train newTrain) {
        validateIfTrainIsNotNull(newTrain);
        if (trains.stream()
                .anyMatch(train -> train.getBritishClass().equals(newTrain.getBritishClass()))) {
            throw new IllegalArgumentException("Train already exists");
        } else {
            trains.add(newTrain);
        }

    }

    public int getTrainsCountInRepository() {
        return trains.size();
    }

    public void reboot() {
        trains.clear();
    }

    public Train load(String britishClass) {
        validateIfBritishClassIsNotNull(britishClass);
        return trains.stream()
                .filter(train -> train.getBritishClass().equals(britishClass))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("British class type", britishClass));
    }

    public void delete(String britishClass) {
        validateIfBritishClassIsNotNull(britishClass);

        Train trainToDelete = trains.stream()
                .filter(train -> train.getBritishClass().equals(britishClass))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("British class type", britishClass));
        trains.remove(trainToDelete);
    }

    public void update(Train updatedTrain) {
        validateIfTrainIsNotNull(updatedTrain);

        Train trainToUpdate = trains.stream()
                .filter(train -> train.getBritishClass().equals(updatedTrain.getBritishClass()))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("British class type", updatedTrain.getBritishClass()));

        trains.remove(trainToUpdate);
        trains.add(updatedTrain);
    }

    private static void validateIfTrainIsNotNull(Train updatedTrain) {
        if (Objects.isNull(updatedTrain)) {
            throw new IllegalArgumentException("Train is null");
        }
    }

    private static void validateIfBritishClassIsNotNull(String britishClass) {
        if (Objects.isNull(britishClass) || britishClass.isBlank()) {
            throw new IllegalArgumentException("Train is null");
        }
    }
}
