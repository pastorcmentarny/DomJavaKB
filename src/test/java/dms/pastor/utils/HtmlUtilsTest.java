package dms.pastor.utils;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static dms.pastor.utils.HtmlUtils.getNbsp;
import static dms.pastor.utils.randoms.RandomDataGenerator.randomNegativeInteger;
import static org.assertj.core.api.Assertions.assertThat;

public class HtmlUtilsTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void getNbspShouldReturnThrowExceptionIfValueIsZeroOrLess() {
        // expect
        exception.expect(IllegalArgumentException.class);

        // when
        getNbsp(randomNegativeInteger());
    }

    @Test
    public void shouldReturn1Nsbp() throws Exception {
        // when
        final String result = getNbsp(1);

        // then
        AssertionsForClassTypes.assertThat(result).isEqualTo("&nbsp;");
    }

    @Test
    public void getNbspShouldReturn3Times() {
        // given
        final int times = 3;
        final String expectedResult = "&nbsp;&nbsp;&nbsp;";

        // when
        final String result = getNbsp(times);

        // then
        assertThat(result).isEqualTo(expectedResult);

    }
}