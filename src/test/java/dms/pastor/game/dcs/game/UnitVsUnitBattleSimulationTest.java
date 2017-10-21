package dms.pastor.game.dcs.game;

import dms.pastor.game.dcs.units.enemies.*;
import org.junit.Test;

//TODO generator for all possible 1 vs 1
public final class UnitVsUnitBattleSimulationTest {

    @Test
    public void dummyUnitVsGenieBattleSimulationTest() {
        // setup
        Dummy dummyUnitUnit = new Dummy("Dummy");
        Genie genie = new Genie();
        Battle battle = new Battle(dummyUnitUnit, genie);

        // battle
        battle.isInFight();
    }

    @Test
    public void dummyUnitVsDragonBattleSimulationTest() {
        // setup
        Dummy dummyUnit = new Dummy("Dummy");
        Genie genie = new Genie();
        Battle battle = new Battle(dummyUnit, genie);

        // battle
        battle.isInFight();
    }

    @Test
    public void dummyUnitVsFireElementBattleSimulationTest() {
        // setup
        Dummy dummyUnit = new Dummy("Dummy");
        FireElement fireElement = new FireElement();
        Battle battle = new Battle(dummyUnit, fireElement);

        // battle
        battle.isInFight();
    }

    @Test
    public void dummyUnitVsMageBattleSimulationTest() {
        // setup
        Dummy dummyUnitUnit = new Dummy("Dummy");
        Mage mage = new Mage();
        Battle battle = new Battle(dummyUnitUnit, mage);

        // battle
        battle.isInFight();
    }

    @Test
    public void dummyUnitVsClairvoyantBattleSimulationTest() {
        // setup
        Dummy dummyUnit = new Dummy("Dummy");
        Clairvoyant clairvoyant = new Clairvoyant();
        Battle battle = new Battle(dummyUnit, clairvoyant);

        // battle
        battle.isInFight();
    }

    @Test
    public void dummyUnitVsWitchBattleSimulationTest() {
        // setup
        Dummy dummyUnit = new Dummy("Dummy");
        Witch witch = new Witch();
        Battle battle = new Battle(dummyUnit, witch);

        // battle
        battle.isInFight();
    }

    @Test
    public void dummyUnitVsTrollBattleSimulationTest() {
        // setup
        Dummy dummyUnit = new Dummy("Dummy");
        Cleric cleric = new Cleric();
        Battle battle = new Battle(dummyUnit, cleric);

        // battle
        battle.isInFight();
    }

    @Test
    public void dummyUnitVsVampireBattleSimulationTest() {
        // setup
        Dummy dummyUnit = new Dummy("Dummy");
        Vampire vampire = new Vampire();
        Battle battle = new Battle(dummyUnit, vampire);

        // battle
        battle.isInFight();
    }

    @Test
    public void clericVsFireElementBattleSimulationTest() {
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
    public void conjurorVsMageBattleSimulationTest() {
        // setup
        Conjuror conjuror = new Conjuror();
        Mage mage = new Mage();
        Battle battle = new Battle(conjuror, mage);

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
    public void dragonVsMageBattleSimulationTest() {
        // setup
        Dragon dragon = new Dragon();
        Mage mage = new Mage();
        Battle battle = new Battle(dragon, mage);

        // battle
        battle.isInFight();
    }

    @Test
    public void fireElementVsMageBattleSimulationTest() {
        // setup
        FireElement fireElement = new FireElement();
        Mage mage = new Mage();
        Battle battle = new Battle(fireElement, mage);

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
    public void genieVsClairvoyantBattleSimulationTest() {
        // setup
        Genie genie = new Genie();
        Clairvoyant clairvoyant = new Clairvoyant();
        Battle battle = new Battle(genie, clairvoyant);

        // battle
        battle.isInFight();
    }

    @Test
    public void genieVsMageBattleSimulationTest() {
        // setup
        Genie genie = new Genie();
        Mage mage = new Mage();
        Battle battle = new Battle(genie, mage);

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
    public void genieVsWitchBattleSimulationTest() {
        // setup
        Genie genie = new Genie();
        Witch witch = new Witch();
        Battle battle = new Battle(genie, witch);

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
    public void mageVsVampireBattleSimulationTest() {
        // setup
        Mage mage = new Mage();
        Vampire vampire = new Vampire();
        Battle battle = new Battle(mage, vampire);

        // battle
        battle.isInFight();
    }

    @Test
    public void mageVsWitchBattleSimulationTest() {
        // setup
        Mage mage = new Mage();
        Witch witch = new Witch();
        Battle battle = new Battle(mage, witch);

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
