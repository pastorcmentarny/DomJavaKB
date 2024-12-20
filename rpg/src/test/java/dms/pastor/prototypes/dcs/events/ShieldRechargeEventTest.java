package dms.pastor.prototypes.dcs.events;

import dms.pastor.prototypes.dcs.units.Unit;
import dms.pastor.prototypes.dcs.units.enemies.builders.UnitBuilder;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 29/05/2017
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class ShieldRechargeEventTest {

    private static final int DEFAULT_SHIELD_POINTS = 24;
    private final ShieldRechargeEvent shieldRechargeEvent = new ShieldRechargeEvent();

    @Test
    public void shieldRechargeEventShouldStartShieldRegenerationIfUnitHasShield() {
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
