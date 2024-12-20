package dms.pastor.prototypes.dcs.spells;

import dms.pastor.prototypes.dcs.units.Unit;
import org.junit.jupiter.api.Test;

import static dms.pastor.prototypes.dcs.units.enemies.builders.UnitBuilder.unitBuilder;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 28/05/2017
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class ChainLightingSpellAcceptanceTest {

    @Test
    public void chainLightingSpellShouldCauseFullDamageToHp() {
        // given
        final Unit unit = unitBuilder().build();
        final Unit enemy = unitBuilder()
                .name("enemy")
                .hp(10)
                .withoutShield()
                .build();
        ChainLightingSpell spell = new ChainLightingSpell();
        // when
        spell.castSpell(unit, enemy);

        // then
        assertThat(enemy.getHp()).isEqualTo(2);
    }

    @Test
    public void chainLightingSpellShouldDoesDamageToSpAndHp() {
        // given
        final Unit unit = unitBuilder().build();
        final Unit enemy = unitBuilder()
                .name("enemy")
                .hp(10)
                .sp(3)
                .build();
        ChainLightingSpell spell = new ChainLightingSpell();
        // when
        spell.castSpell(unit, enemy);

        // then
        assertThat(enemy.getHp()).isEqualTo(5);
    }

}