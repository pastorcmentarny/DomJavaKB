package dms.pastor.game.dcs.events;

import dms.pastor.game.dcs.units.Unit;
import org.junit.Test;

import static dms.pastor.game.dcs.units.enemies.builders.UnitBuilder.unitBuilder;
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