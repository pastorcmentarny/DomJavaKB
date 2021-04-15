package dms.pastor.prototypes.dcs.events;

import dms.pastor.prototypes.dcs.units.Unit;
import dms.pastor.prototypes.dcs.units.enemies.builders.UnitBuilder;
import org.junit.jupiter.api.Test;

import static dms.pastor.prototypes.dcs.ElementsBuilder.elementsBuilder;

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
        System.out.println(unit);
    }
}