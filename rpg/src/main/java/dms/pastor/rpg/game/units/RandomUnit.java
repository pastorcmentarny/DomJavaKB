package dms.pastor.rpg.game.units;

import dms.pastor.rpg.game.cfg.Config;
import dms.pastor.rpg.game.characteristics.Skills;
import dms.pastor.rpg.game.characteristics.Stats;
import dms.pastor.rpg.game.units.enemies.*;
import dms.pastor.rpg.game.units.enemies.animals.Puffin;
import dms.pastor.rpg.game.units.enemies.animals.Seagull;
import dms.pastor.rpg.game.units.enemies.animals.Sheep;
import dms.pastor.rpg.game.units.enemies.animals.Unicorn;
import dms.pastor.rpg.game.units.enemies.undead.*;
import dms.pastor.rpg.game.units.nylonKnights.Dresiarz;
import dms.pastor.rpg.game.units.nylonKnights.NylonKnight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class RandomUnit {
    private static final Random random = new Random();
    private static final ArrayList<Units> undeads = new ArrayList<>(Arrays.asList(Units.BUNNY, Units.MUMMY, Units.WRAITH, Units.VAMPIRE, Units.ZOMBIE));

    public static Unit generateRandomUnit() {
        Units[] unit = Units.values();
        return getUnit(1, null, null, null, unit[new Random().nextInt(Units.values().length)]);
    }

    public static Enemy generateRandomUnit(int level) {
        Units[] unit = Units.values();
        return getUnit(level, null, null, null, unit[random.nextInt(Units.values().length)]);
    }

    public static Enemy generateZombieQuestUnit(int level) {
        return getUnit(level, null, null, null, undeads.get(new Random().nextInt(undeads.size())));
    }

    private static Enemy getUnit(int level, Skills skills, Skills bonus, Stats stats, Units unit) {
        if (skills == null) {
            skills = Skills.generateRandomSkills(Config.DEFAULT_POINTS_FOR_SKILLS, Config.DEFAULT_INIT_MAX_POINTS_FOR_SKILLS, false, null);
        }
        if (bonus == null) {
            bonus = Skills.generateZeroSkills();
        }
        if (stats == null) {
            stats = Stats.generateDefaultBonusStats(false);//change it
        }
        switch (unit) {
            case ONE:
                return new One(level);
            case SEAGULL:
                return new Seagull(level);
            case DUMMY:
                return new Dummy(level);
            case DUMMY_RANDOM:
                return new Dummy(-1);
            case AVERAGE_MAN:
                return new Peasant(random.nextInt());
            case ACOLYTE:
                return new JasAcolyte(level);
            case BUNNY:
                return new CuteBunny(level);
            case UNICORN:
                return new Unicorn();
            case MANNEQUIN:
                return new Mannequin(level);
            case PUFFIN:
                return new Puffin(level);
            case SHEEP:
                return new Sheep(level);
            case PEASANT:
                return new Peasant(level);
            case VAMPIRE:
                return new Vampire(level);
            case MUMMY:
                return new Mummy(level);
            case WRAITH:
                return new Wraith(level);
            case ZOMBIE:
                return new Zombie(level);
            case DRESIARZ:
                return new Dresiarz(level);
            case POLYESTER_KNIGHT:
                return new NylonKnight(level);
            default:
                System.err.println("Unknown selection (" + unit.name() + ") for Random Unit. Generating Dummy instead");
                return new Dummy(level);

        }
    }

    private enum Units {

        AVERAGE_MAN, ONE, DUMMY, DUMMY_RANDOM,// dummy units
        BUNNY, MUMMY, WRAITH, VAMPIRE, ZOMBIE, //undead
        DRESIARZ, POLYESTER_KNIGHT, // Ola army
        ACOLYTE, MANNEQUIN, PEASANT, PUFFIN, SEAGULL, SHEEP, UNICORN
    }

}
