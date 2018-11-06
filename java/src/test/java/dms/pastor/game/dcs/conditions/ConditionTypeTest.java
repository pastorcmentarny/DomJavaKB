package dms.pastor.game.dcs.conditions;

import dms.pastor.domain.exception.SomethingWentWrongException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static dms.pastor.game.dcs.conditions.ConditionType.FIRE_RESISTANT;
import static dms.pastor.game.dcs.conditions.ConditionType.FROZEN;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 01/08/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class ConditionTypeTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void getTextShouldThrowSomethingWentWrongExceptionIfConditionTypeIsNull() {

        // expect
        exception.expect(SomethingWentWrongException.class);

        // when
        ConditionType.getText(null);
    }

    @Test
    public void getTextShouldLowerCaseConditionTypeForSingleWordedType() {
        // given
        final String expectedResult = "frozen";

        // when
        final String result = ConditionType.getText(FROZEN);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void getTextShouldReturnConditionWithNameSeparatedWithSpace() {
        // given
        final String expectedResult = "fire resistant";

        // when
        final String result = ConditionType.getText(FIRE_RESISTANT);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }
}