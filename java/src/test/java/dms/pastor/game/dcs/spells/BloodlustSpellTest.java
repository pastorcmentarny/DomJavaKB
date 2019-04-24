package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.units.Unit;
import org.junit.Test;

import static dms.pastor.game.dcs.conditions.ConditionType.BLOODLUST;
import static dms.pastor.game.dcs.units.enemies.builders.UnitBuilder.unitBuilder;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 28/05/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class BloodlustSpellTest {

    private static final Unit UNUSED_UNIT = null;

    @Test
    public void castBloodlustShouldAddBloodlustToPlayer() {
        // given
        final BloodlustSpell bloodlustSpell = new BloodlustSpell();
        final Unit unit = unitBuilder()
            .build();

        // when
        bloodlustSpell.castSpell(unit, UNUSED_UNIT);

        // then
        assertThat(unit.getConditions().has(BLOODLUST)).isTrue();
    }
}