package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.units.Unit;
import dms.pastor.game.dcs.units.enemies.builders.UnitBuilder;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public final class DeathRaySpellTest {

    @Test
    public void castDeathRayShouldDoesDirectDamageToUnit() {
        // given
        DeathRaySpell deathRaySpell = new DeathRaySpell();
        final Unit unit = UnitBuilder.unitBuilder().sp(10).hp(20).build();

        // when
        deathRaySpell.castSpell(unit, unit);

        // then
        assertThat(unit.isShielded()).isTrue();
        assertThat(unit.getHp()).isEqualTo(2);
    }
}