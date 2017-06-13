package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.Config;
import dms.pastor.game.dcs.units.Unit;
import org.junit.Test;

import static dms.pastor.game.dcs.units.UnitBuilder.unitBuilder;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 27/05/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class BackstabSpellAcceptanceTest {

    @Test
    public void castBacktabSpellShouldReduceHpBy2EvenIfHasShield() throws Exception {
        // given
        final BackstabSpell backstabSpell = new BackstabSpell();
        final Unit unit = unitBuilder()
                .build();
        final int initialHp = 10;
        final Unit unit2 = unitBuilder()
                .hp(initialHp)
                .sp(10)
                .build();
        // when
        backstabSpell.castSpell(unit, unit2);
        // then
        assertThat(unit2.getHp()).isEqualTo(initialHp - Config.BACKSTABBING_DMG);
    }

    @Test
    public void castBacktabSpellShouldReduceHpBy2() throws Exception {
        // given
        final BackstabSpell backstabSpell = new BackstabSpell();
        final Unit unit = unitBuilder()
                .build();
        final int initialHp = 10;
        final Unit unit2 = unitBuilder()
                .hp(initialHp)
                .shielded(false)
                .sp(0)
                .build();
        // when
        backstabSpell.castSpell(unit, unit2);
        // then
        assertThat(unit2.getHp()).isEqualTo(initialHp - Config.BACKSTABBING_DMG);
    }
}