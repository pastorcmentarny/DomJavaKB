package dms.pastor.examples.patterns.observer;

import java.util.ArrayList;
import java.util.List;

public class TrainMovementPublisher implements Publisher {
    private final List<StationObserver> trains = new ArrayList<>();

    @Override
    public void register(StationObserver train) {
        trains.add(train);
    }

    @Override
    public void unregister(StationObserver stationObserver) {
        trains.remove(stationObserver);
    }

    @Override
    public void notifyObserver(Train train) {
        trains.forEach(trainItem -> trainItem.update(train));
    }
}
