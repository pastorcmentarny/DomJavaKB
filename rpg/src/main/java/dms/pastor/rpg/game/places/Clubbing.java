package dms.pastor.rpg.game.places;

import dms.pastor.rpg.game.units.Hero;


public class Clubbing extends Place {

    Clubbing(Hero hero) {
        setName("UniClub");
        setDescription("Aging Mature people believes that current generations sucks as they only drinking ,procreating and waste they precious time when they go club,which is not true,because they are many cultures events like Comedy Works, Biggest burger challenge and other intellectual events.");
    }

    @Override
    public void goToPlace() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void description() {
        System.out.println(getDescription());
    }


}
