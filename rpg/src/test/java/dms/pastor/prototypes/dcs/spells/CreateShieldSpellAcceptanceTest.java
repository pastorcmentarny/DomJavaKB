package dms.pastor.prototypes.dcs.spells;

import dms.pastor.prototypes.dcs.Config;
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
public class CreateShieldSpellAcceptanceTest {

    private static final Unit UNUSED_UNIT = null;

    @Test
    public void createShieldSpellShouldNotCreateAShieldIfUnitAlreadyHasIt() {
        // given
        final int shieldPoints = 10;
        final Unit unit = unitBuilder()
                .sp(shieldPoints)
                .build();

        final CreateShieldSpell createShieldSpell = new CreateShieldSpell();
        // when
        createShieldSpell.castSpell(unit, UNUSED_UNIT);

        // then
        assertThat(unit.isShielded()).isTrue();
        assertThat(unit.getSp()).isEqualTo(shieldPoints);
    }

    @Test
    public void createShieldSpellShouldCreateAShieldIfUnitDoNotHaveIt() {
        // given
        final Unit unit = unitBuilder()
                .withoutShield()
                .build();
        assertThat(unit.isShielded()).isFalse();

        final CreateShieldSpell createShieldSpell = new CreateShieldSpell();
        // when
        createShieldSpell.castSpell(unit, UNUSED_UNIT);

        // then
        assertThat(unit.isShielded()).isTrue();
        assertThat(unit.getSp()).isEqualTo(Config.INITIAL_SHIELD_POINTS);
    }
}