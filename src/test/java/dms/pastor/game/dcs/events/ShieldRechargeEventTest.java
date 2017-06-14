package dms.pastor.game.dcs.events;

import dms.pastor.game.dcs.units.Unit;
import dms.pastor.game.dcs.units.UnitBuilder;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 29/05/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class ShieldRechargeEventTest {

    private static final int DEFAULT_SHIELD_POINTS = 24;
    private final ShieldRechargeEvent shieldRechargeEvent = new ShieldRechargeEvent();

    @Test
    public void shieldRechargeEventShouldStartShieldRegenationIfUnitHasShield() throws Exception {
        // given
        final Unit unitOne = UnitBuilder.unitBuilder()
                .sp(DEFAULT_SHIELD_POINTS)
                .build();
        final Unit unitTwo = UnitBuilder.unitBuilder()
                .sp(DEFAULT_SHIELD_POINTS)
                .build();

        // when
        shieldRechargeEvent.makeItHappen(unitOne, unitTwo);

        // then
        assertThat(unitOne.getSp() > DEFAULT_SHIELD_POINTS || unitTwo.getSp() > DEFAULT_SHIELD_POINTS).isTrue();
    }
}
