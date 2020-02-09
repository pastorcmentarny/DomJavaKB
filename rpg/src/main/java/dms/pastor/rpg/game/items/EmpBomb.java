package dms.pastor.rpg.game.items;

import dms.pastor.domain.Result;
import dms.pastor.rpg.game.events.BattleManual;
import dms.pastor.rpg.game.units.Hero;
import dms.pastor.rpg.game.units.Unit;

import java.util.Random;

/**
 * @author dominiksymonowicz
 */
public class EmpBomb extends Item {

    public EmpBomb() {
        name = "Emp Bomb";
        description = " When this bomb exploded it drains magic energy from surrounded area";
        isUsableInBattle = true;
        value = 10000;
    }

    @Override
    public boolean isIsUsableInBattle() {
        return super.isIsUsableInBattle(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Result useInBattle(Unit unit) {
        if (BattleManual.getChance(Hero.getHero(), unit) > new Random().nextInt()) {
            unit.battleStats.setMana(0);
            unit.battleStats.setSP(unit.battleStats.getSP() / 2);
            return new Result(true, "Bomb hits" + unit.getName() + " and drains all his mana" + (unit.psycho ? " and lost half of shield." : "."));
        } else {
            unit.battleStats.setMana(unit.battleStats.getMana() * 4 / 5);
            unit.battleStats.setSP(unit.battleStats.getSP() * 4 / 5);
            return new Result(false, Hero.getHero().getName() + " missed and exploded near " + unit.getName() + " and drains 20% of  mana " + (unit.psycho ? " and 20% of shield." : "."));
        }

    }

    @Override
    public Result use() {
        return super.use(); //To change body of generated methods, choose Tools | Templates.
    }

}
