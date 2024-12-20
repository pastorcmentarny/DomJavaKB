package dms.pastor.prototypes.dcs.conditions;

import dms.pastor.domain.exception.SomethingWentWrongException;
import dms.pastor.prototypes.xp.XPUtils;
import org.junit.jupiter.api.Test;

import static dms.pastor.prototypes.dcs.conditions.ConditionType.FIRE_RESISTANT;
import static dms.pastor.prototypes.dcs.conditions.ConditionType.FROZEN;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Author Dominik Symonowicz
 * Created 01/08/2017
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class ConditionTypeTest {

    @Test
    public void getTextShouldThrowSomethingWentWrongExceptionIfConditionTypeIsNull() {
        // expect
        assertThrows(SomethingWentWrongException.class, () ->
                // when
                ConditionType.getText(null)
        );

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