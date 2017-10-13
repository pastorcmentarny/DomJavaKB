package dms.pastor.game.dcs.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static dms.pastor.utils.randoms.PersonalDataGenerator.generateFirstName;

public final class Names {

    private static final Random random = new Random();
    private static final List<String> ancientEgyptTitles;
    private static final List<String> places;

    static {
        ancientEgyptTitles = new ArrayList<>();
        ancientEgyptTitles.add(" High Priest of ");
        ancientEgyptTitles.add(" High steward of ");
        ancientEgyptTitles.add(" Overseer of the ");
        ancientEgyptTitles.add(" Servant of ");

        places = new ArrayList<>();
        places.add("Wroclaw");
        places.add("treasuries");
        places.add("shoe shop"); //Al Bundy ;P

    }

    private Names() {
    }

    public static String getRandomMummyName() {
        return generateFirstName()  +  ancientEgyptTitles.get(random.nextInt(ancientEgyptTitles.size())) + places.get(random.nextInt(places.size()));
    }
}
