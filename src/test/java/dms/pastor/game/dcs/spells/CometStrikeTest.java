package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.units.Unit;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static dms.pastor.game.dcs.conditions.ConditionType.FROZEN;
import static dms.pastor.game.dcs.conditions.ConditionType.POISONED;
import static dms.pastor.game.dcs.units.UnitBuilder.unitBuilder;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 12/06/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz-9817065a/
 */
public final class CometStrikeTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(CometStrikeTest.class);
    private static final int MAX_ATTEMPTS = 50;

    @Test
    public void castSpellShouldDoesDamage() {
        // given
        CometStrike cometStrike = new CometStrike();

        final int initHp = 25;
        final Unit unit = unitBuilder()
                .hp(initHp)
                .withoutShield()
                .build();

        // when
        cometStrike.castSpell(unit, unit);

        // then
        assertThat(unit.getHp()).isLessThan(initHp);

        //debug
        LOGGER.debug("Player's HP: " + unit.getHp());
    }

    @Test
    public void castSpellShouldDoesDamageAndFrozeAndPoison() {
        // given
        CometStrike cometStrike = new CometStrike();
        final Unit unit = unitBuilder()
                .hp(2500)
                .withoutShield()
                .build();

        boolean wasPoisonAtLeastOnce = false;
        boolean wasFrozenAtLeastOnce = false;

        // when
        for (int round = 1; round < MAX_ATTEMPTS; round++) {

            cometStrike.castSpell(unit, unit);
            if (unit.getConditions().has(POISONED)) {
                wasPoisonAtLeastOnce = true;
            }

            if (unit.getConditions().has(FROZEN)) {
                wasFrozenAtLeastOnce = true;
            }

            if (wasFrozenAtLeastOnce && wasPoisonAtLeastOnce) {
                LOGGER.debug("Poisoned and Frozen happen on attempt no. " + round);
                break;
            }
        }

        // then
        assertThat(wasPoisonAtLeastOnce).isTrue();
        assertThat(wasFrozenAtLeastOnce).isTrue();

    }
}
