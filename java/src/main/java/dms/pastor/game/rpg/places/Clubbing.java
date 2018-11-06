package dms.pastor.game.rpg.places;

import dms.pastor.game.rpg.units.Hero;


public class Clubbing extends Place {

    Clubbing(Hero hero) {
        setName("Uniclub");
        setDescription("Aging Mature people belives that current generations sucks as they only drinking ,procreating and waste they precious time when they go club,which is not true,because they are many culturar events like Comedy Works, Biggest burger challende and other intelectual events.");
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
