package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.units.Unit;
import dms.pastor.game.dcs.units.UnitBuilder;
import org.junit.Test;

import static dms.pastor.game.dcs.conditions.ConditionType.WEAKNESS;
import static org.assertj.core.api.Assertions.assertThat;

public final class WeaknessSpellTest {

    private static final int MAX_ATTEMPT_TO_GET_WEAKNESS = 25;

    @Test
    public void castWeaknessSpellShouldAddWeaknessCondition() {
        // given
        final WeaknessSpell weaknessSpell = new WeaknessSpell();
        final Unit unit = UnitBuilder.unitBuilder().build();

        // when
        for (int i = 0; i < MAX_ATTEMPT_TO_GET_WEAKNESS; i++) {
            weaknessSpell.castSpell(unit, unit);
            if (unit.getConditions().has(WEAKNESS)) {
                break;
            }
        }

        // then
        assertThat(unit.getConditions().has(WEAKNESS)).isTrue();
    }
}
