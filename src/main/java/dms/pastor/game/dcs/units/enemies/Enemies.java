package dms.pastor.game.dcs.units.enemies;

import dms.pastor.game.dcs.units.Unit;

import java.util.ArrayList;
import java.util.List;

public class Enemies {

    private static final List<Unit> allEnemies = new ArrayList<>();

    static {
        allEnemies.add(new Dummy());
        allEnemies.add(new FireElement());
        allEnemies.add(new Golem());
        allEnemies.add(new Mummy());
        allEnemies.add(new Troll());
        allEnemies.add(new Vampire());
        allEnemies.add(new Dragon());
    }

    public static List<Unit> getAllEnemies() {
        return allEnemies;
    }
}
