package dms.pastor.prototype.dcs.spells;

import dms.pastor.prototype.dcs.Config;
import dms.pastor.prototype.dcs.units.Unit;
import dms.pastor.prototype.dcs.units.enemies.Vampire;
import dms.pastor.prototype.dcs.units.enemies.builders.UnitBuilder;
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
        assertThat(vampire.getHp()).isGreaterThan(Config.DEFAULT_HEALTH_POINTS);
        assertThat(enemy.getHp()).isLessThan(initialHp);
    }

}