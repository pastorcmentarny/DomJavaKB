package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.units.Unit;
import dms.pastor.game.dcs.units.UnitBuilder;
import dms.pastor.game.dcs.units.enemies.Vampire;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public final class VampireDrainSpellTest {

    @Test
    public void castVampireDrainSpellShouldDrainSomeHpFromEnemyAndGivesToVampire() {
        // given
        VampireDrainSpell vampireDrainSpell = new VampireDrainSpell();
        Vampire vampire = new Vampire();
        final int initialHp = 10;
        final Unit enemy = UnitBuilder.unitBuilder()
                .hp(initialHp)
                .withoutShield()
                .build();

        // when
        vampireDrainSpell.castSpell(vampire, enemy);

        // then
        assertThat(vampire.getHp()).isGreaterThan(Unit.DEFAULT_HEALTH_POINTS);
        assertThat(enemy.getHp()).isLessThan(initialHp);
    }
}