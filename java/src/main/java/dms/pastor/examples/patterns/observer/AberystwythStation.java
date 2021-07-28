package dms.pastor.examples.patterns.observer;

public class AberystwythStation implements StationObserver {

    @Override
    public void update(Train train) {
        System.out.println("Aberystwyth station :: Next train is currently at " + train.getInfo());
    }
}
