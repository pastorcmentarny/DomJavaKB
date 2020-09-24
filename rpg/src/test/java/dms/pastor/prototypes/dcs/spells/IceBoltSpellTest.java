package dms.pastor.prototypes.dcs.spells;

import dms.pastor.prototypes.dcs.units.Unit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static dms.pastor.prototypes.dcs.Config.ICE_BOLT_DMG;
import static dms.pastor.prototypes.dcs.conditions.ConditionType.WATER_IMMUNE;
import static dms.pastor.prototypes.dcs.units.enemies.builders.UnitBuilder.unitBuilder;
import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("resource") // auto closable not essential
public final class IceBoltSpellTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream original = System.out;

    private final IceBoltSpell iceBoltSpell = new IceBoltSpell();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
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