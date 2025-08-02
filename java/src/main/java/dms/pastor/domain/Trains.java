package dms.pastor.domain;

import java.util.List;
import java.util.Optional;

public class Trains {
    private static final Train britishClass220 = Train.builder()
            .trainId("BritishClass220")
            .trainType(TrainType.DEMU)
            .inService(true)
            .maxSpeed(200)
            .description("The British Rail Class 220 Voyager is a diesel-electric high-speed multiple unit passenger train")
            .build();

    private static final Train britishClass221 = Train.builder()
            .trainId("BritishClass221")
            .trainType(TrainType.DEMU)
            .inService(true)
            .maxSpeed(200)
            .description("The British Rail Class 221 Super Voyager is a tilting diesel-electric high-speed multiple unit passenger train")
            .build();

    private static final Train britishClass222 = Train.builder()
            .trainId("BritishClass222")
            .trainType(TrainType.DEMU)
            .inService(true)
            .maxSpeed(200)
            .description("The British Rail Class 221 Meridian  is a diesel-electric high-speed multiple unit passenger train")
            .build();

    private static final Train britishClass373 = Train.builder()
            .trainId("BritishClass373")
            .trainType(TrainType.EMU)
            .inService(true)
            .maxSpeed(300)
            .description("British Rail Class 373 Eurostar e300 is a high-speed multiple unit passenger train")
            .build();

    private static final Train britishClass374 = Train.builder()
            .trainId("BritishClass374")
            .trainType(TrainType.EMU)
            .inService(true)
            .maxSpeed(320)
            .description("British Rail Class 374 Eurostar e320 is a high-speed multiple unit passenger train")
            .build();

    private static final Train britishClass390 = Train.builder()
            .trainId("BritishClass390")
            .trainType(TrainType.DEMU)
            .inService(true)
            .maxSpeed(200)
            .description("British Rail Class 390 Pendolino is a tilting electric high-speed multiple unit passenger train")
            .build();

    private static final Train britishClass395 = Train.builder()
            .trainId("BritishClass395")
            .trainType(TrainType.EMU)
            .inService(true)
            .maxSpeed(225)
            .description("The British Rail Class 395 Javelin is a dual-voltage electric high-speed multiple unit passenger train")
            .build();

    public static List<Train> getAllTrains() {
        return List.of(britishClass220, britishClass221, britishClass222, britishClass373, britishClass374, britishClass390, britishClass395);
    }

    public static Optional<Train> findTrainById(String trainId) {
        return getAllTrains().stream()
                .filter(train -> train.getTrainId().equals(trainId))
                .findFirst();
    }
}
