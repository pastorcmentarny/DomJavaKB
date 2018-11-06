package dms.pastor.game.rpg.units.enemies.monsters;

import dms.pastor.game.rpg.units.Unit;
import dms.pastor.game.rpg.units.enemies.Enemy;

/**
 * @author domhome
 * <p>
 * http://en.wikipedia.org/wiki/Cyhyraeth
 */
public class Cyhyraeth extends Enemy {

    @Override
    public boolean avoidFightDiplomacy(Unit unit) {
        return false;
    }

    @Override
    public void beforeBattle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void afterBattle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void specialAttack(Unit unit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean canAttack() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean canCastSpell() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean canUseItem() {
        return false;
    }

}
