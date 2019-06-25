package dms.pastor.rpg.game.events;

import dms.pastor.rpg.game.commons.Result;

/**
 * @author dominiksymonowicz
 * <p>
 * //somebody trying to still a item from inventory (or itemst)
 * You have chance to detecte depends on your dexterity
 */
public class ThiefEvent implements EventInterface {

    @Override
    public void doEvent() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void help() {
        System.out.println("HELP! Somebody trying to rob me!");
    }

    @Override
    public Result getReward() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
