package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.units.Unit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static dms.pastor.game.dcs.Config.ICE_BOLT_DMG;
import static dms.pastor.game.dcs.conditions.ConditionType.WATER_IMMUNE;
import static dms.pastor.game.dcs.units.UnitBuilder.unitBuilder;
import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("resource") // auto closable not essential
public final class IceBoltSpellTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream original = System.out;

    private final IceBoltSpell iceBoltSpell = new IceBoltSpell();

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
    public void castIceBoltShouldDoesDamageToUnit() {
        // given
        final int initHp = 100;
        final Unit unit = unitBuilder()
                .hp(initHp)
                .withoutShield()
                .build();
        // when
        iceBoltSpell.castSpell(unit, unit);

        // then
        assertThat(unit.getHp()).isEqualTo(initHp - ICE_BOLT_DMG);
    }

    @Test
    public void castIceBoltShouldResistSpellIfUnitIsImmuneToWater() {
        // given
        final int initHp = 100;
        final Unit unit = unitBuilder()
                .hp(initHp)
                .withoutShield()
                .withSingleCondition(WATER_IMMUNE)
                .build();
        // when
        iceBoltSpell.castSpell(unit, unit);

        // then
        assertThat(unit.getHp()).isEqualTo(initHp);
    }
}