package dms.pastor.prototype.dcs.events;

import dms.pastor.prototype.dcs.units.Unit;
import dms.pastor.prototype.dcs.units.enemies.builders.UnitBuilder;
import org.junit.Test;

import static dms.pastor.prototype.dcs.ElementsBuilder.elementsBuilder;

public final class ElementStolenEventTest {

    @Test
    public void makeItHappenShouldReduceSomeElementsFromUnit() {
        // given
        ElementStolenEvent elementStolenEvent = new ElementStolenEvent();
        final Unit unit = UnitBuilder.unitBuilder()
            .elements(elementsBuilder()
                .setToOneForAllElements()
                .build()
            ).build();
        // when
        elementStolenEvent.makeItHappen(unit, unit);

        // then
        System.out.println(unit.toString());
    }
}