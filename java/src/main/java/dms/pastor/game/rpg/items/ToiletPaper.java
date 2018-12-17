package dms.pastor.game.rpg.items;

import dms.pastor.game.rpg.characteristics.Attribute;
import dms.pastor.game.rpg.commons.Result;
import dms.pastor.game.rpg.units.Hero;


public class ToiletPaper extends Item {
    int useLeft = 3;

    public ToiletPaper() {
        name = "Toilet Paper";
        description = "Luxurious paper for wiping yourself clean after urination or defecation";
        value = 24;
    }

    @Override
    public Result use() {
        Hero hero = Hero.getHero();
        hero.currentAttributes.remove(Attribute.POISONED);
        hero.plainStats.addHealth(hero.plainStats.getMaxHP() / 10);
        return new Result(true, "Using toilet paper after do your 'chat with shell' makes you cleaner as result your restore some health and get rid of poison ");
    }

    @Override
    public int getValue() {
        return super.getValue(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

}
