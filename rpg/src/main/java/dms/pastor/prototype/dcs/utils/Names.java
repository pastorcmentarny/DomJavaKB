package dms.pastor.prototype.dcs.utils;

import dms.pastor.utils.randoms.PersonalDataGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class Names {

    private static final List<String> ANCIENT_EGYPT_TITLES;
    private static final List<String> PLACES;
    private static final Random RANDOM = new Random();

    static {
        ANCIENT_EGYPT_TITLES = new ArrayList<>();
        ANCIENT_EGYPT_TITLES.add(" High Priest of ");
        ANCIENT_EGYPT_TITLES.add(" High steward of ");
        ANCIENT_EGYPT_TITLES.add(" Overseer of the ");
        ANCIENT_EGYPT_TITLES.add(" Servant of ");

        PLACES = new ArrayList<>();
        PLACES.add("Wroclaw");
        PLACES.add("treasuries");
        PLACES.add("shoe shop"); //Al Bundy ;P

    }

    private Names() {
    }

    public static String getRandomMummyName() {
        return PersonalDataGenerator.generateFirstName() + ANCIENT_EGYPT_TITLES.get(RANDOM.nextInt(ANCIENT_EGYPT_TITLES.size())) + PLACES.get(RANDOM.nextInt(PLACES.size()));
    }
}
