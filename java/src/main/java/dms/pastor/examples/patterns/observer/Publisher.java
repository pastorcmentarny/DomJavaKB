package dms.pastor.examples.patterns.observer;

public interface Publisher {
    void register(StationObserver stationObserver);

    void unregister(StationObserver stationObserver);

    void notifyObserver(Train train);
}
