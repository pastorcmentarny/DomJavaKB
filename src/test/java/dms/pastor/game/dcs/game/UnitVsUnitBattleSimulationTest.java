package dms.pastor.game.dcs.game;

import dms.pastor.game.dcs.units.enemies.*;
import org.junit.Test;

//TODO generator for all possible 1 vs 1
public final class UnitVsUnitBattleSimulationTest {

    @Test
    public void dummyVsGenieBattleSimulationTest() {
        // setup
        Dummy dummy = new Dummy("Dummy");
        Genie genie = new Genie();
        Battle battle = new Battle(dummy, genie);

        // battle
        battle.isInFight();
    }

    @Test
    public void dummyVsDragonBattleSimulationTest() {
        // setup
        Dummy dummy = new Dummy("Dummy");
        Genie genie = new Genie();
        Battle battle = new Battle(dummy, genie);

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
        Clairvoyant clairvoyant = new Clairvoyant();
        Battle battle = new Battle(dummy, clairvoyant);

        // battle
        battle.isInFight();
    }

    @Test
    public void dummyVsMummyBattleSimulationTest() {
        // setup
        Dummy dummy = new Dummy("Dummy");
        Daemon daemon = new Daemon();
        Battle battle = new Battle(dummy, daemon);

        // battle
        battle.isInFight();
    }

    @Test
    public void dummyVsTrollBattleSimulationTest() {
        // setup
        Dummy dummy = new Dummy("Dummy");
        Cleric cleric = new Cleric();
        Battle battle = new Battle(dummy, cleric);

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
    public void afreetVsDragonBattleSimulationTest() {
        // setup
        Genie genie = new Genie();
        Dragon dragon = new Dragon();
        Battle battle = new Battle(genie, dragon);

        // battle
        battle.isInFight();
    }

    @Test
    public void afreetVsFireElementBattleSimulationTest() {
        // setup
        Genie genie = new Genie();
        FireElement fireElement = new FireElement();
        Battle battle = new Battle(genie, fireElement);

        // battle
        battle.isInFight();
    }

    @Test
    public void afreetVsGolemBattleSimulationTest() {
        // setup
        Genie genie = new Genie();
        Clairvoyant clairvoyant = new Clairvoyant();
        Battle battle = new Battle(genie, clairvoyant);

        // battle
        battle.isInFight();
    }

    @Test
    public void afreetVsMummyBattleSimulationTest() {
        // setup
        Genie genie = new Genie();
        Daemon daemon = new Daemon();
        Battle battle = new Battle(genie, daemon);

        // battle
        battle.isInFight();
    }

    @Test
    public void afreetVsTrollBattleSimulationTest() {
        // setup
        Genie genie = new Genie();
        Daemon daemon = new Daemon();
        Battle battle = new Battle(genie, daemon);

        // battle
        battle.isInFight();
    }

    @Test
    public void afreetVsVampireBattleSimulationTest() {
        // setup
        Genie genie = new Genie();
        Vampire vampire = new Vampire();
        Battle battle = new Battle(genie, vampire);

        // battle
        battle.isInFight();
    }

    @Test
    public void dragonVsFireElementBattleSimulationTest() {
        // setup
        Dragon dragon = new Dragon();
        FireElement fireElement = new FireElement();
        Battle battle = new Battle(dragon, fireElement);

        // battle
        battle.isInFight();
    }

    @Test
    public void dragonVsGolemBattleSimulationTest() {
        // setup
        Dragon dragon = new Dragon();
        Clairvoyant clairvoyant = new Clairvoyant();
        Battle battle = new Battle(dragon, clairvoyant);

        // battle
        battle.isInFight();
    }

    @Test
    public void dragonVsMummyBattleSimulationTest() {
        // setup
        Dragon dragon = new Dragon();
        Daemon daemon = new Daemon();
        Battle battle = new Battle(dragon, daemon);

        // battle
        battle.isInFight();
    }

    @Test
    public void dragonVsTrollBattleSimulationTest() {
        // setup
        Dragon dragon = new Dragon();
        Cleric cleric = new Cleric();
        Battle battle = new Battle(dragon, cleric);

        // battle
        battle.isInFight();
    }

    @Test
    public void dragonVsVampireBattleSimulationTest() {
        // setup
        Dragon dragon = new Dragon();
        Vampire vampire = new Vampire();
        Battle battle = new Battle(dragon, vampire);

        // battle
        battle.isInFight();
    }

    @Test
    public void fireElementVsGolemBattleSimulationTest() {
        // setup
        FireElement fireElement = new FireElement();
        Clairvoyant clairvoyant = new Clairvoyant();
        Battle battle = new Battle(fireElement, clairvoyant);

        // battle
        battle.isInFight();
    }

    @Test
    public void fireElementVsMummyBattleSimulationTest() {
        // setup
        FireElement fireElement = new FireElement();
        Daemon daemon = new Daemon();
        Battle battle = new Battle(fireElement, daemon);

        // battle
        battle.isInFight();
    }

    @Test
    public void fireElementVsTrollBattleSimulationTest() {
        // setup
        FireElement fireElement = new FireElement();
        Cleric cleric = new Cleric();
        Battle battle = new Battle(fireElement, cleric);

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
        Clairvoyant clairvoyant = new Clairvoyant();
        Daemon daemon = new Daemon();
        Battle battle = new Battle(clairvoyant, daemon);

        // battle
        battle.isInFight();
    }

    @Test
    public void golemVsTrollBattleSimulationTest() {
        // setup
        Clairvoyant clairvoyant = new Clairvoyant();
        Cleric cleric = new Cleric();
        Battle battle = new Battle(clairvoyant, cleric);

        // battle
        battle.isInFight();
    }

    @Test
    public void golemVsVampireBattleSimulationTest() {
        // setup
        Clairvoyant clairvoyant = new Clairvoyant();
        Vampire vampire = new Vampire();
        Battle battle = new Battle(clairvoyant, vampire);

        // battle
        battle.isInFight();
    }

    @Test
    public void mummyVsTrollBattleSimulationTest() {
        // setup
        Daemon daemon = new Daemon();
        Cleric cleric = new Cleric();
        Battle battle = new Battle(daemon, cleric);

        // battle
        battle.isInFight();
    }

    @Test
    public void mummyVsVampireBattleSimulationTest() {
        // setup
        Daemon daemon = new Daemon();
        Vampire vampire = new Vampire();
        Battle battle = new Battle(daemon, vampire);

        // battle
        battle.isInFight();
    }

    @Test
    public void trollVsVampireBattleSimulationTest() {
        // setup
        Cleric cleric = new Cleric();
        Vampire vampire = new Vampire();
        Battle battle = new Battle(cleric, vampire);

        // battle
        battle.isInFight();
    }

}
