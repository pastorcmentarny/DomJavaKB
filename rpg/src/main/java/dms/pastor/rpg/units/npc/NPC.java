package dms.pastor.rpg.units.npc;

import dms.pastor.rpg.characteristics.Location;
import dms.pastor.rpg.units.Hero;
import dms.pastor.rpg.units.Unit;


public abstract class NPC extends Unit {
    public Hero hero = Hero.getHero();
    Location location;

    public abstract void talk();

    public abstract String getRandomPreTalk();

    public abstract void smallTalk();
}
