package dms.pastor.examples.patterns.observer;

public class ConwyStation implements StationObserver {

    @Override
    public void update(Train train) {
        System.out.println("Conwy station :: Next train :: " + train.getInfo());
    }
}
