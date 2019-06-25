package dms.pastor.rpg.game.units.enemies.bosses;

import dms.pastor.rpg.game.units.Unit;
import dms.pastor.rpg.game.units.enemies.Enemy;


public class Boss extends Enemy {

    @Override
    public boolean avoidFightDiplomacy(Unit unit) {
        return false;//You can't avoid fight with boss
    }

    @Override
    public void beforeBattle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void beforeTurn() {
        super.beforeTurn();
    }

    @Override
    public void afterTurn() {
        //NOTHING
    }

    @Override
    public void afterBattle() {
        //NOTHING.
    }

    @Override
    public void specialAttack(Unit unit) {
        //NOTHING
    }

    @Override
    public boolean canAttack() {
        return !state.isStunned();
    }

    @Override
    public boolean canCastSpell() {
        return !state.isStunned();
    }

    @Override
    public boolean canUseItem() {
        return !state.isStunned();
    }

}
