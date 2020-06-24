package dms.pastor.prototypes.dcs.spells;

import dms.pastor.prototypes.dcs.units.enemies.builders.UnitBuilder;
import org.junit.jupiter.api.Test;

/**
 * Author Dominik Symonowicz
 * Created 28/05/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class CureSpellAcceptanceTest {

    @Test
    public void cureSpellShouldCurePoisonBlindAndWeaknessButNot() {
        // given
        UnitBuilder.unitBuilder()
            .condition(null)
            .build();

        // when

        // then

    }
}