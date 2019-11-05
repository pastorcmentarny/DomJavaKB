package dms.pastor.prototypes.dcs.units.enemies;

import dms.pastor.prototypes.dcs.spells.IceBoltSpell;
import dms.pastor.prototypes.dcs.spells.VampireDrainSpell;
import dms.pastor.prototypes.dcs.units.Unit;
import dms.pastor.prototypes.dcs.units.enemies.builders.UnitBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static dms.pastor.prototypes.dcs.Config.VAMPIRE_DRAIN_HEAL_HP;
import static dms.pastor.prototypes.dcs.conditions.ElementType.*;
import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("resource") // auto closable not essential
public final class VampireTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream original = System.out;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @After
    public void cleanUp() throws IOException {
        outputStream.close();
        System.setOut(original);
    }

    @Test
    public void shouldPerformAllActionInTurn() {
        // given
        Vampire vampire = new Vampire();

        vampire.getElements().setElementsFor(AIR, 6);
        vampire.getElements().setElementsFor(EARTH, 6);
        vampire.getElements().setElementsFor(FIRE, 6);
        vampire.getElements().setElementsFor(WATER, 3);

        Unit enemy = UnitBuilder.unitBuilder()
            .withoutShield()
            .build();
        String vampireDrainSpellName = new VampireDrainSpell().getName();
        final String iceBoltSpellName = new IceBoltSpell().getName();

        // when
        vampire.turn(enemy);

        // then
        assertThat(outputStream.toString()).contains(vampire.getName() + " trying to drain energy from " + enemy.getName());
        assertThat(outputStream.toString().contains(vampire.getName() + " casting " + vampireDrainSpellName + " on " + enemy.getName()));
        assertThat(outputStream.toString()).contains("Vampire drain does 5 dmg to " + enemy.getName() + " and " + vampire.getName() + " drain " + VAMPIRE_DRAIN_HEAL_HP + " dmg.");
        assertThat(outputStream.toString().contains(vampire.getName() + " casting " + iceBoltSpellName + " on " + enemy.getName()));

    }
}