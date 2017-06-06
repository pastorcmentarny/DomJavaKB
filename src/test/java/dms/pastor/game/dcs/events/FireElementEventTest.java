package dms.pastor.game.dcs.events;

import dms.pastor.game.dcs.conditions.Condition;
import dms.pastor.game.dcs.conditions.ConditionType;
import dms.pastor.game.dcs.units.Unit;
import org.junit.Test;

import static dms.pastor.game.dcs.units.UnitBuilder.unitBuilder;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 29/05/2017
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class FireElementEventTest {

    @Test
    public void performFireEventShouldCauseUnitToHasDamage() throws Exception {
        // given
        final Condition conditions = new Condition();
        conditions.add(ConditionType.FIRE_SENSITIVE, 1);

        final Unit unit = unitBuilder()
                .condition(conditions)
                .build();

        FireElementEvent fireElementEvent = new FireElementEvent();

        // when
        final String result = fireElementEvent.makeItHappen(unit, unit);

        // then
        assertThat(result).isEqualTo("Unstable fire element causes minor damage 3 to " + unit.getName());
    }

    @Test
    public void performFireEventShouldGivesFireElement() throws Exception {
        // given
        final Condition conditions = new Condition();
        conditions.add(ConditionType.FIRE_IMMUNE, 1);

        final Unit unit = unitBuilder()
                .condition(conditions)
                .build();

        FireElementEvent fireElementEvent = new FireElementEvent();

        // when
        fireElementEvent.makeItHappen(unit, unit);

        // then
        assertThat(unit.getElements().getFire()).isEqualTo(1);
    }
}