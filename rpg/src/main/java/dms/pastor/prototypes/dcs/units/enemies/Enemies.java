package dms.pastor.prototypes.dcs.units.enemies;

import dms.pastor.prototypes.dcs.units.Unit;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;

public final class Enemies {

    private static final List<Unit> ALL_ENEMIES = new ArrayList<>();

    static {
        ALL_ENEMIES.add(new Conjuror());
        ALL_ENEMIES.add(new Dummy());
        ALL_ENEMIES.add(new FireElement());
        ALL_ENEMIES.add(new Clairvoyant());
        ALL_ENEMIES.add(new Witch());
        ALL_ENEMIES.add(new Cleric());
        ALL_ENEMIES.add(new Vampire());
        ALL_ENEMIES.add(new Dragon());
        ALL_ENEMIES.add(new Mage());
    }

    private Enemies() {
    }

    public static List<Unit> getAllEnemies() {
        return unmodifiableList(ALL_ENEMIES);
    }
}
