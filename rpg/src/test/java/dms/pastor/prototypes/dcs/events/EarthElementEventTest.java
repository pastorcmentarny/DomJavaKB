package dms.pastor.prototypes.dcs.events;

import dms.pastor.prototypes.dcs.units.Unit;
import org.junit.jupiter.api.Test;

import static dms.pastor.prototypes.dcs.units.enemies.builders.UnitBuilder.unitBuilder;
import static org.assertj.core.api.Assertions.assertThat;

public final class EarthElementEventTest {

    @Test
    public void performFireEventShouldGivesFireElement() {
        // given
        final Unit unit = unitBuilder()
            .build();
        // when
        EarthElementEvent earthElementEvent = new EarthElementEvent();
        earthElementEvent.makeItHappen(unit, unit);

        // then
        assertThat(unit.getElements().getEarth()).isEqualTo(1);
    }
}