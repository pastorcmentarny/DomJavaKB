package dms.pastor.rpg.game.units.npc;

import dms.pastor.rpg.game.units.Unit;
import dms.pastor.rpg.game.units.enemies.Enemy;


public class Tokar extends Enemy {

    public Tokar(int lvl) {
        super(lvl);
        //TODO implement Marta (she will be on 
    }

    @Override
    public void beforeBattle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void beforeTurn() {
        super.beforeTurn();
        //She has Dental Braces but they are not best quality ones as when she speak or swear then they works  as 'Irrigation sprinkler' and causes acid damage to you 1% of your max health
    }


    @Override
    public void afterBattle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean avoidFightDiplomacy(Unit unit) {
        return false;
    }


    @Override
    public void specialAttack(Unit unit) {
        //NOTHING
    }


}
