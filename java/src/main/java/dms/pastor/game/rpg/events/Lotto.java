package dms.pastor.game.rpg.events;

import dms.pastor.game.rpg.commons.Result;

public class Lotto implements EventInterface {

    @Override
    public void doEvent() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void help() {
        System.out.println("Just in case. Gambing problem ? Go to http://www.gambleaware.co.uk/ .Althrough this game will not cause any lost of real money.");
    }

    @Override
    public Result getReward() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /*
     * Generate 10000 fields (*10)
     * 40% wygrane 40000
     * 10000,2000*4,1000*5,50*4,,10*10
     */


}
