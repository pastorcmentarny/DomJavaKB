package dms.pastor.prototypes.dcs.events;

import dms.pastor.prototypes.dcs.conditions.Condition;
import dms.pastor.prototypes.dcs.units.Unit;
import org.junit.jupiter.api.Test;

import static dms.pastor.prototypes.dcs.conditions.ConditionEntry.createTemporaryCondition;
import static dms.pastor.prototypes.dcs.conditions.ConditionType.FIRE_IMMUNE;
import static dms.pastor.prototypes.dcs.conditions.ConditionType.FIRE_SENSITIVE;
import static dms.pastor.prototypes.dcs.units.enemies.builders.UnitBuilder.unitBuilder;
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
public class FireElementEventTest {

    @Test
    public void performFireEventShouldCauseUnitToHasDamage() {
        // given
        final Condition conditions = new Condition();
        conditions.add(createTemporaryCondition(FIRE_SENSITIVE, 1));

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
    public void performFireEventShouldGivesFireElement() {
        // given
        final Condition conditions = new Condition();
        conditions.add(createTemporaryCondition(FIRE_IMMUNE, 1));

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