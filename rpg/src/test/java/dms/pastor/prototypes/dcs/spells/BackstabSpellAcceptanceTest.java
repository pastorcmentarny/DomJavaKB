package dms.pastor.prototypes.dcs.spells;

import dms.pastor.prototypes.dcs.Config;
import dms.pastor.prototypes.dcs.units.Unit;
import org.junit.jupiter.api.Test;

import static dms.pastor.prototypes.dcs.units.enemies.builders.UnitBuilder.unitBuilder;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 27/05/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class BackstabSpellAcceptanceTest {

    @Test
    public void castBacktabSpellShouldReduceHpBy2EvenIfHasShield() {
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
    public void castBacktabSpellShouldReduceHpBy2() {
        // given
        final BackstabSpell backstabSpell = new BackstabSpell();
        final Unit unit = unitBuilder()
            .build();
        final int initialHp = 10;
        final Unit unit2 = unitBuilder()
            .hp(initialHp)
            .withoutShield()
            .sp(0)
            .build();
        // when
        backstabSpell.castSpell(unit, unit2);
        // then
        assertThat(unit2.getHp()).isEqualTo(initialHp - Config.BACKSTABBING_DMG);
    }
}