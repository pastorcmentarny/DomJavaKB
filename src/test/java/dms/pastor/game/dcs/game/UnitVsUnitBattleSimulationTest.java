package dms.pastor.game.dcs.game;

import dms.pastor.game.dcs.units.enemies.Afreet;
import dms.pastor.game.dcs.units.enemies.Dummy;
import dms.pastor.game.dcs.units.enemies.FireElement;
import dms.pastor.game.dcs.units.enemies.Golem;
import dms.pastor.game.dcs.units.enemies.Mummy;
import dms.pastor.game.dcs.units.enemies.Troll;
import dms.pastor.game.dcs.units.enemies.Vampire;
import org.junit.Test;

//TODO generator for all possible 1 vs 1
public final class UnitVsUnitBattleSimulationTest {

    @Test
    public void dummyVsAfreetBattleSimulationTest() {
        // setup
        Dummy dummy = new Dummy("Dummy");
        Afreet afreet = new Afreet();
        Battle battle = new Battle(dummy, afreet);

        // battle
        battle.isInFight();
    }

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
    public void dummyVsMummyBattleSimulationTest() {
        // setup
        Dummy dummy = new Dummy("Dummy");
        Mummy mummy = new Mummy();
        Battle battle = new Battle(dummy, mummy);

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
    public void afreetVsFireElementBattleSimulationTest() {
        // setup
        Afreet afreet = new Afreet();
        FireElement fireElement = new FireElement();
        Battle battle = new Battle(afreet, fireElement);

        // battle
        battle.isInFight();
    }

    @Test
    public void afreetVsGolemBattleSimulationTest() {
        // setup
        Afreet afreet = new Afreet();
        Golem golem = new Golem();
        Battle battle = new Battle(afreet, golem);

        // battle
        battle.isInFight();
    }

    @Test
    public void afreetVsMummyBattleSimulationTest() {
        // setup
        Afreet afreet = new Afreet();
        Mummy mummy = new Mummy();
        Battle battle = new Battle(afreet, mummy);

        // battle
        battle.isInFight();
    }

    @Test
    public void afreetVsTrollBattleSimulationTest() {
        // setup
        Afreet afreet = new Afreet();
        Mummy mummy = new Mummy();
        Battle battle = new Battle(afreet, mummy);

        // battle
        battle.isInFight();
    }

    @Test
    public void afreetVsVampireBattleSimulationTest() {
        // setup
        Afreet afreet = new Afreet();
        Vampire vampire = new Vampire();
        Battle battle = new Battle(afreet, vampire);

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
    public void fireElementVsMummyBattleSimulationTest() {
        // setup
        FireElement fireElement = new FireElement();
        Mummy mummy = new Mummy();
        Battle battle = new Battle(fireElement, mummy);

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
    public void golemVsMummyBattleSimulationTest() {
        // setup
        Golem golem = new Golem();
        Mummy mummy = new Mummy();
        Battle battle = new Battle(golem, mummy);

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
    public void mummyVsTrollBattleSimulationTest() {
        // setup
        Mummy mummy = new Mummy();
        Troll troll = new Troll();
        Battle battle = new Battle(mummy, troll);

        // battle
        battle.isInFight();
    }

    @Test
    public void mummyVsVampireBattleSimulationTest() {
        // setup
        Mummy mummy = new Mummy();
        Vampire vampire = new Vampire();
        Battle battle = new Battle(mummy, vampire);

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
