package dms.pastor.rpg.game.units.npc;

import dms.pastor.rpg.game.characteristics.Location;
import dms.pastor.rpg.game.units.Hero;
import dms.pastor.rpg.game.units.Unit;


public abstract class NPC extends Unit {
    public Hero hero = Hero.getHero();
    Location location;

    public abstract void talk();

    public abstract String getRandomPreTalk();

    public abstract void smallTalk();
}
