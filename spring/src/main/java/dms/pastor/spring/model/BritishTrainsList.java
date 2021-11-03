package dms.pastor.spring.model;

import java.util.ArrayList;
import java.util.List;

import static dms.pastor.spring.model.TractionType.*;

public class BritishTrainsList {
    private static List<Train> britishTrains;

    static {
        britishTrains = new ArrayList<>();
        britishTrains.add(Train.builder().britishClass("158").maxSpeed(200).tilting(true).name("Express Sprinter").type(DMU).build());
        britishTrains.add(Train.builder().britishClass("220").maxSpeed(200).tilting(true).name("Super Voyager").type(DEMU).build());
        britishTrains.add(Train.builder().britishClass("221").maxSpeed(200).tilting(true).name("Super Voyager").type(DEMU).build());
        britishTrains.add(Train.builder().britishClass("222").maxSpeed(200).tilting(true).name("Meridian").type(DMU).build());
        britishTrains.add(Train.builder().britishClass("390").maxSpeed(225).tilting(true).name("Pendolino").type(EMU).build());
    }

    public static Train getSuperVoyager() {
        return britishTrains.stream().filter(train -> train.getBritishClass().equals("221")).findFirst().orElseThrow();
    }

    public static Train getPendolino() {
        return britishTrains.stream().filter(train -> train.getBritishClass().equals("390")).findFirst().orElseThrow();
    }

    public static List<Train> getAllBritishTrains(){
        return List.copyOf(britishTrains);
    }
}
