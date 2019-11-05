package dms.pastor.prototypes.dcs.events;

import dms.pastor.prototypes.dcs.units.Unit;
import org.junit.Test;

import static dms.pastor.prototypes.dcs.units.enemies.builders.UnitBuilder.unitBuilder;
import static org.assertj.core.api.Assertions.assertThat;

public final class AirElementEventTest {

    @Test
    public void performFireEventShouldGivesFireElement() {
        // given
        final Unit unit = unitBuilder()
            .build();
        AirElementEvent airElementEvent = new AirElementEvent();
        // when
        airElementEvent.makeItHappen(unit, unit);

        // then
        assertThat(unit.getElements().getAir()).isEqualTo(1);
    }
}