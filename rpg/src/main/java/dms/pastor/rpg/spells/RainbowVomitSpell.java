package dms.pastor.rpg.spells;

import dms.pastor.rpg.commons.Result;
import dms.pastor.rpg.units.Hero;
import dms.pastor.rpg.units.Unit;

import java.util.Random;


public class RainbowVomitSpell extends Spell {
    private final Unit unit;

    public RainbowVomitSpell(Unit unit) {
        name = "Rainbow Vomit";
        description = "Rainbow Vomit is magical spell cast by Unicorn..";
        this.unit = unit;
    }

    @Override
    public Result cast(Hero hero) {
        int dmg = new Random().nextInt(256);
        if (dmg == 8 || dmg == 16 || dmg == 32 || dmg == 64) {
            System.out.println("!double bits color damage!");
            dmg *= 2;
        }
        hero.battleStats.doesDMG(dmg, hero.battleStats.getARM());
        return new Result(true, unit.getName() + " does " + dmg + " dmg to " + hero.getName());
    }

    @Override
    public Result cast(Unit unit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Result cast(Hero hero, Unit[] units) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
