package dms.pastor.game.rpg.units.enemies;

import dms.pastor.game.rpg.actions.BattleAction;
import dms.pastor.game.rpg.units.Unit;
import dms.pastor.game.rpg.Money;
import dms.pastor.game.rpg.characteristics.Skills;


public abstract class Enemy extends Unit implements BattleAction {
    public Money money = new Money(0);

    public Enemy() {
        super();
    }

    public Enemy(int lvl) {
        super(lvl);
    }

    public Enemy(String name, Skills skills, boolean psycho, int lvl) {
        super(name, skills, psycho, lvl);
    }

    @Override
    public void beforeTurn() {
        if (state.isPoisoned) {
            int dmg = battleStats.getMaxDMG() / 35;
            if (battleStats.getHP() - dmg <= 0) {
                battleStats.setHP(1);
            } else {
                battleStats.doesDirectDMGtoHP(dmg);
            }
        }
    }

    @Override
    public void afterTurn() {
        state.afterTurn();
    }

    public abstract boolean avoidFightDiplomacy(Unit unit);


    public void specialAttack() {
        //No special attack
    }


}
