package dms.pastor.game.rpg.units.npc;

import dms.pastor.game.rpg.characteristics.Location;
import dms.pastor.game.rpg.units.Hero;
import dms.pastor.game.rpg.units.Unit;


public abstract class NPC extends Unit {
    public Hero hero = Hero.getHero();
    public Location location;

    public abstract void talk();

    public abstract String getRandomPreTalk();

    public abstract void smallTalk();
}
