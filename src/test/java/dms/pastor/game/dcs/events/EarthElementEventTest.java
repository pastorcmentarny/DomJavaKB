package dms.pastor.game.dcs.events;

import dms.pastor.game.dcs.units.Unit;
import org.junit.Test;

import static dms.pastor.game.dcs.units.enemies.builders.UnitBuilder.unitBuilder;
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