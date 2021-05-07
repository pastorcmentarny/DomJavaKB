package dms.pastor.spring.model;

import java.util.ArrayList;
import java.util.List;

import static dms.pastor.spring.model.TractionType.DMU;
import static dms.pastor.spring.model.TractionType.EMU;

public class BritishTrainsList {
    private static List<Train> britishTrains;

    static {
        britishTrains = new ArrayList<>();
        britishTrains.add(Train.builder().britishClass("221").maxSpeed(200).tilting(true).name("Super Voyager").type(DMU).build());
        britishTrains.add(Train.builder().britishClass("390").maxSpeed(225).tilting(true).name("Pendolino").type(EMU).build());
    }

    public static Train getSuperVoyager() {
        return britishTrains.stream().filter(train -> train.getBritishClass().equals("221")).findFirst().orElseThrow();
    }

    public static Train getPendolino() {
        return britishTrains.stream().filter(train -> train.getBritishClass().equals("390")).findFirst().orElseThrow();
    }
}
