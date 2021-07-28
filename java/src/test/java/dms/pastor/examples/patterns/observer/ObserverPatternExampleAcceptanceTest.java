package dms.pastor.examples.patterns.observer;

import org.junit.jupiter.api.Test;

import static dms.pastor.examples.patterns.observer.Location.*;

class ObserverPatternExampleAcceptanceTest {

    @Test
    public void observerPatternExampleRunner() {
        // scenario
        AberystwythStation aber = new AberystwythStation();
        BathStation bath = new BathStation();
        ConwyStation conwy = new ConwyStation();
        YorkStation york = new YorkStation();
        TrainMovementPublisher trainMovementPublisher = new TrainMovementPublisher();
        final Train train = new Train(1, "Virgin Trains", ABERYSTWYTH, trainMovementPublisher);

        trainMovementPublisher.register(aber);
        trainMovementPublisher.register(bath);
        trainMovementPublisher.register(conwy);

        train.setLocation(BATH);
        trainMovementPublisher.unregister(bath);
        train.setLocation(CONWY);
        trainMovementPublisher.register(york);
        final Train eurostar = new Train(2, "Eurostar", YORK, trainMovementPublisher);
        eurostar.setLocation(BATH);
        train.setLocation(YORK);
        eurostar.setLocation(ABERYSTWYTH);

        // then no exception happen
    }
}