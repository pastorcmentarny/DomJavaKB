package dms.pastor.utils;

import org.junit.jupiter.api.Test;

import static dms.pastor.utils.html.HtmlUtils.HTML_SPACE;
import static dms.pastor.utils.html.HtmlUtils.getNbsp;
import static dms.pastor.utils.randoms.RandomDataGenerator.randomNegativeInteger;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HtmlUtilsTest {


    @Test
    public void getNbspShouldReturnThrowExceptionIfValueIsZeroOrLess() {
        // when
        assertThrows(IllegalArgumentException.class, () -> getNbsp(randomNegativeInteger()));

    }

    @Test
    public void shouldReturn1Nsbp() {
        // when
        final String result = getNbsp(1);

        // then
        assertThat(result).isEqualTo("&nbsp;");
    }

    @Test
    public void getNbspShouldReturn3Times() {
        // given
        final int times = 3;
        final String expectedResult = HTML_SPACE + HTML_SPACE + HTML_SPACE;

        // when
        final String result = getNbsp(times);

        // then
        assertThat(result).isEqualTo(expectedResult);

    }
}