package dms.pastor.examples.patterns.observer;

public class BathStation implements StationObserver {

    @Override
    public void update(Train train) {
        System.out.println("Bath station :: Next train :: " + train.getInfo());
    }
}
