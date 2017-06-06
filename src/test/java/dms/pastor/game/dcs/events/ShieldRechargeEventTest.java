package dms.pastor.game.dcs.events;

import dms.pastor.game.dcs.units.Unit;
import dms.pastor.game.dcs.units.UnitBuilder;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 29/05/2017
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
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