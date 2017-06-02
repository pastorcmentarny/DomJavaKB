package dms.pastor.game.dcs.events;

import dms.pastor.game.dcs.units.Unit;
import dms.pastor.game.dcs.units.UnitBuilder;
import org.junit.Test;

import static dms.pastor.game.dcs.ElementsBuilder.elementsBuilder;

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