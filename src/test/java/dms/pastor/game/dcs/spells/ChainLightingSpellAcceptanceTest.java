package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.units.Unit;
import org.junit.Test;

import static dms.pastor.game.dcs.units.UnitBuilder.unitBuilder;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 28/05/2017
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class ChainLightingSpellAcceptanceTest {

    @Test
    public void chainLightingSpellShouldCauseFullDamageToHp() throws Exception {
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
        assertThat(enemy.getHp()).isEqualTo(3);
    }

    @Test
    public void chainLightingSpellShouldDoesDamageToSpAndHp() throws Exception {
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
        assertThat(enemy.getHp()).isEqualTo(6);
    }

}