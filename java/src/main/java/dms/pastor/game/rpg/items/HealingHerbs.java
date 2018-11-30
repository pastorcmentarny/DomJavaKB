package dms.pastor.game.rpg.items;

import dms.pastor.game.rpg.characteristics.Attribute;
import dms.pastor.game.rpg.commons.Result;
import dms.pastor.game.rpg.units.Hero;

import java.util.Random;


public class HealingHerbs extends Item {
    int poisonChance = 20;
    Hero hero = Hero.getHero();

    public HealingHerbs() {
        setName("Healing Herbs");
        setDescription("This tasting like grass with sand herbs heals many of your wounds as long as you have some experience in being herbalist.If not there is a" + poisonChance + " that herbs can cause damage .Use with care");//TODO add footnote as medics has in ads
    }

    @Override
    public Result use() {

        int heal = hero.skills.getIntelligence() * hero.lvl;
        if (hero.currentAttributes.contains(Attribute.HERBALIST)) {
            heal *= 5;
        } else {
            int chance = new Random().nextInt(101);
            if (chance <= poisonChance) {
                hero.plainStats.doesDirectDMGtoHP(heal);
                return new Result(false, "Woops. This was a posioned herbs.");
            }
        }

        hero.plainStats.addHealth(heal);
        return new Result(true, "You was healed by" + heal + " hp.");
    }


}