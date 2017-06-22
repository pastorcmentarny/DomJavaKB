package dms.pastor.game.dcs.game;

import dms.pastor.game.dcs.units.enemies.Dummy;
import dms.pastor.game.dcs.units.enemies.FireElement;
import dms.pastor.game.dcs.units.enemies.Golem;
import dms.pastor.game.dcs.units.enemies.Troll;
import dms.pastor.game.dcs.units.enemies.Vampire;
import org.junit.Test;

//TODO generator for all possible 1 vs 1
public final class UnitVsUnitBattleSimulationTest {

    @Test
    public void dummyVsFireElementBattleSimulationTest() {
        // setup
        Dummy dummy = new Dummy("Dummy");
        FireElement fireElement = new FireElement();
        Battle battle = new Battle(dummy, fireElement);

        // battle
        battle.isInFight();
    }

    @Test
    public void dummyVsGolemBattleSimulationTest() {
        // setup
        Dummy dummy = new Dummy("Dummy");
        Golem golem = new Golem();
        Battle battle = new Battle(dummy, golem);

        // battle
        battle.isInFight();
    }

    @Test
    public void dummyVsTrollBattleSimulationTest() {
        // setup
        Dummy dummy = new Dummy("Dummy");
        Troll troll = new Troll();
        Battle battle = new Battle(dummy, troll);

        // battle
        battle.isInFight();
    }

    @Test
    public void dummyVsVampireBattleSimulationTest() {
        // setup
        Dummy dummy = new Dummy("Dummy");
        Vampire vampire = new Vampire();
        Battle battle = new Battle(dummy, vampire);

        // battle
        battle.isInFight();
    }

    @Test
    public void fireElementVsGolemBattleSimulationTest() {
        // setup
        FireElement fireElement = new FireElement();
        Golem golem = new Golem();
        Battle battle = new Battle(fireElement, golem);

        // battle
        battle.isInFight();
    }

    @Test
    public void fireElementVsTrollBattleSimulationTest() {
        // setup
        FireElement fireElement = new FireElement();
        Troll troll = new Troll();
        Battle battle = new Battle(fireElement, troll);

        // battle
        battle.isInFight();
    }

    @Test
    public void fireElementVsVampireBattleSimulationTest() {
        // setup
        FireElement fireElement = new FireElement();
        Vampire vampire = new Vampire();
        Battle battle = new Battle(fireElement, vampire);

        // battle
        battle.isInFight();
    }

    @Test
    public void golemVsTrollBattleSimulationTest() {
        // setup
        Golem golem = new Golem();
        Troll troll = new Troll();
        Battle battle = new Battle(golem, troll);

        // battle
        battle.isInFight();
    }

    @Test
    public void golemVsVampireBattleSimulationTest() {
        // setup
        Golem golem = new Golem();
        Vampire vampire = new Vampire();
        Battle battle = new Battle(golem, vampire);

        // battle
        battle.isInFight();
    }

    @Test
    public void trollVsVampireBattleSimulationTest() {
        // setup
        Troll troll = new Troll();
        Vampire vampire = new Vampire();
        Battle battle = new Battle(troll, vampire);

        // battle
        battle.isInFight();
    }

}
