package dms.pastor.examples.patterns.observer;

public class YorkStation implements StationObserver {
    @Override
    public void update(Train train) {
        System.out.println("York station :: Next train :: " + train.getInfo());
    }
}
