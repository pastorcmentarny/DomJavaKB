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
    public void dummyVsClairvoyantBattleSimulationTest() {
        // setup
        Dummy dummy = new Dummy("Dummy");
        Clairvoyant clairvoyant = new Clairvoyant();
        Battle battle = new Battle(dummy, clairvoyant);

        // battle
        battle.isInFight();
    }

    @Test
    public void dummyVsWitchBattleSimulationTest() {
        // setup
        Dummy dummy = new Dummy("Dummy");
        Witch witch = new Witch();
        Battle battle = new Battle(dummy, witch);

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
    public void clearicVsFireElementBattleSimulationTest() {
        // setup
        Cleric cleric = new Cleric();
        FireElement fireElement = new FireElement();
        Battle battle = new Battle(fireElement, cleric);

        // battle
        battle.isInFight();
    }

    @Test
    public void conjurorVsClairvoyantBattleSimulationTest() {
        // setup
        Conjuror conjuror = new Conjuror();
        Clairvoyant clairvoyant = new Clairvoyant();
        Battle battle = new Battle(conjuror, clairvoyant);

        // battle
        battle.isInFight();
    }

    @Test
    public void conjurorVsClericBattleSimulationTest() {
        // setup
        Conjuror conjuror = new Conjuror();
        Cleric cleric = new Cleric();
        Battle battle = new Battle(conjuror, cleric);

        // battle
        battle.isInFight();
    }

    @Test
    public void conjurorVsWitchBattleSimulationTest() {
        // setup
        Conjuror conjuror = new Conjuror();
        Witch witch = new Witch();
        Battle battle = new Battle(conjuror, witch);

        // battle
        battle.isInFight();
    }

    @Test
    public void conjurorVsDragonBattleSimulationTest() {
        // setup
        Conjuror conjuror = new Conjuror();
        Dragon dragon = new Dragon();
        Battle battle = new Battle(conjuror, dragon);

        // battle
        battle.isInFight();
    }

    @Test
    public void conjurorVsFireElementBattleSimulationTest() {
        // setup
        Conjuror conjuror = new Conjuror();
        FireElement fireElement = new FireElement();
        Battle battle = new Battle(conjuror, fireElement);

        // battle
        battle.isInFight();
    }

    @Test
    public void conjurorVsGenieBattleSimulationTest() {
        // setup
        Conjuror conjuror = new Conjuror();
        Genie genie = new Genie();
        Battle battle = new Battle(conjuror, genie);

        // battle
        battle.isInFight();
    }

    @Test
    public void conjurorVsVampireBattleSimulationTest() {
        // setup
        Conjuror conjuror = new Conjuror();
        Vampire vampire = new Vampire();
        Battle battle = new Battle(conjuror, vampire);

        // battle
        battle.isInFight();
    }

    @Test
    public void genieVsDragonBattleSimulationTest() {
        // setup
        Genie genie = new Genie();
        Dragon dragon = new Dragon();
        Battle battle = new Battle(genie, dragon);

        // battle
        battle.isInFight();
    }

    @Test
    public void genieVsFireElementBattleSimulationTest() {
        // setup
        Genie genie = new Genie();
        FireElement fireElement = new FireElement();
        Battle battle = new Battle(genie, fireElement);

        // battle
        battle.isInFight();
    }

    @Test
    public void genieVsCalirvoyantBattleSimulationTest() {
        // setup
        Genie genie = new Genie();
        Clairvoyant clairvoyant = new Clairvoyant();
        Battle battle = new Battle(genie, clairvoyant);

        // battle
        battle.isInFight();
    }

    @Test
    public void genieVsWitchBattleSimulationTest() {
        // setup
        Genie genie = new Genie();
        Witch witch = new Witch();
        Battle battle = new Battle(genie, witch);

        // battle
        battle.isInFight();
    }

    @Test
    public void genieVsVampireBattleSimulationTest() {
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
    public void dragonVsClairvoyantBattleSimulationTest() {
        // setup
        Dragon dragon = new Dragon();
        Clairvoyant clairvoyant = new Clairvoyant();
        Battle battle = new Battle(dragon, clairvoyant);

        // battle
        battle.isInFight();
    }

    @Test
    public void dragonVsWitchBattleSimulationTest() {
        // setup
        Dragon dragon = new Dragon();
        Witch witch = new Witch();
        Battle battle = new Battle(dragon, witch);

        // battle
        battle.isInFight();
    }

    @Test
    public void clericVsDragonBattleSimulationTest() {
        // setup
        Cleric cleric = new Cleric();
        Dragon dragon = new Dragon();
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
    public void fireElementVsClairvoyantBattleSimulationTest() {
        // setup
        FireElement fireElement = new FireElement();
        Clairvoyant clairvoyant = new Clairvoyant();
        Battle battle = new Battle(fireElement, clairvoyant);

        // battle
        battle.isInFight();
    }

    @Test
    public void fireElementVsWitchBattleSimulationTest() {
        // setup
        FireElement fireElement = new FireElement();
        Witch witch = new Witch();
        Battle battle = new Battle(fireElement, witch);

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
    public void clairvoyantVsWitchBattleSimulationTest() {
        // setup
        Clairvoyant clairvoyant = new Clairvoyant();
        Witch witch = new Witch();
        Battle battle = new Battle(clairvoyant, witch);

        // battle
        battle.isInFight();
    }

    @Test
    public void clairvoyantVsClericBattleSimulationTest() {
        // setup
        Clairvoyant clairvoyant = new Clairvoyant();
        Cleric cleric = new Cleric();
        Battle battle = new Battle(clairvoyant, cleric);

        // battle
        battle.isInFight();
    }

    @Test
    public void clairvoyantVsVampireBattleSimulationTest() {
        // setup
        Clairvoyant clairvoyant = new Clairvoyant();
        Vampire vampire = new Vampire();
        Battle battle = new Battle(clairvoyant, vampire);

        // battle
        battle.isInFight();
    }

    @Test
    public void clericVsWitchBattleSimulationTest() {
        // setup
        Cleric cleric = new Cleric();
        Witch witch = new Witch();
        Battle battle = new Battle(cleric, witch);

        // battle
        battle.isInFight();
    }

    @Test
    public void witchVsVampireBattleSimulationTest() {
        // setup
        Witch witch = new Witch();
        Vampire vampire = new Vampire();
        Battle battle = new Battle(witch, vampire);

        // battle
        battle.isInFight();
    }

    @Test
    public void clericVsVampireBattleSimulationTest() {
        // setup
        Cleric cleric = new Cleric();
        Vampire vampire = new Vampire();
        Battle battle = new Battle(cleric, vampire);

        // battle
        battle.isInFight();
    }

}
