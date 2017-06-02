package dms.pastor.game.dcs.units;

import org.junit.Test;

import static dms.pastor.game.dcs.units.Unit.DEFAULT_SHIELD_POINTS;
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
public class UnitTest {

    @Test
    public void recreateShieldShouldCreateShield() throws Exception {
        // given
        final Unit unit = unitBuilder()
                .shielded(false)
                .sp(0)
                .build();
        // when
        unit.recreateShield();

        // then
        assertThat(unit.isShielded());
        assertThat(unit.getSp()).isEqualTo(DEFAULT_SHIELD_POINTS);

    }

    @Test
    public void addHPBy5ShouldIncreaseHpBy5() throws Exception {
        // given
        final int initialHp = 20;
        final int healBy = 5;
        final int maxHp = initialHp + healBy + 1;
        final Unit unit = unitBuilder()
                .hp(initialHp)
                .maxHp(maxHp)
                .build();

        // when
        unit.addHP(healBy);

        // then
        assertThat(unit.getHp()).isEqualTo(initialHp + healBy);
    }

    @Test
    public void addHPToHpMoreThanMaxHpShouldGivesMaxHp() throws Exception {
        // given
        final int initialHp = 20;
        final int healBy = 5;
        final Unit unit = unitBuilder()
                .hp(initialHp)
                .maxHp(initialHp)
                .build();

        // when
        unit.addHP(healBy);

        // then
        assertThat(unit.getHp()).isEqualTo(initialHp);
    }


    @Test
    public void createShieldShouldEmableShieldAndSetInitialSPValue() throws Exception {
        // given
        final Unit unit = unitBuilder()
                .shielded(false)
                .sp(0)
                .build();
        final int initialShieldPoints = 20;

        // when
        unit.createShield(initialShieldPoints);

        // then
        assertThat(unit.isShielded()).isTrue();
        assertThat(unit.getSp()).isEqualTo(initialShieldPoints);

    }

    @Test
    public void increaseShieldByShouldIncreaseSpBy5() throws Exception {
        // given
        final Unit unit = unitBuilder()
                .sp(10)
                .build();

        // when
        unit.increaseShieldBy(5);

        // then
        assertThat(unit.getSp()).isEqualTo(15);

    }
}