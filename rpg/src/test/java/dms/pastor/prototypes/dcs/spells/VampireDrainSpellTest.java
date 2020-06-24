package dms.pastor.prototypes.dcs.spells;

import dms.pastor.prototypes.dcs.Config;
import dms.pastor.prototypes.dcs.units.Unit;
import dms.pastor.prototypes.dcs.units.enemies.Vampire;
import dms.pastor.prototypes.dcs.units.enemies.builders.UnitBuilder;
import org.junit.jupiter.api.Test;

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