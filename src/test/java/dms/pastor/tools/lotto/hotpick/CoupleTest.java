package dms.pastor.tools.lotto.hotpick;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 10/03/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class CoupleTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void createCoupleShouldThrowExceptionIfBothNumbersAreEquals() throws Exception {
        // expect
        exception.expect(IllegalArgumentException.class);

        // given
        final int number = 1;

        // when
        Couple.createWithOrderedNumbers(number, number);

    }

    @Test
    public void shouldGenerateCouple() throws Exception {
        // given
        final int smallerNumber = 1;
        final int largerNumber = 2;

        // when
        final Couple couple = Couple.createWithOrderedNumbers(smallerNumber, largerNumber);

        // then
        assertThat(couple.getSmallerNumber()).isEqualTo(smallerNumber);
        assertThat(couple.getLargerNumber()).isEqualTo(largerNumber);
    }

    @Test // improve test name
    public void shouldGenerateCoupleAndSort() throws Exception {
        // given
        final int smallerNumber = 1;
        final int largerNumber = 2;

        // when
        final Couple couple = Couple.createWithOrderedNumbers(largerNumber, smallerNumber);

        // then
        assertThat(couple.getSmallerNumber()).isNotEqualTo(largerNumber);
        assertThat(couple.getLargerNumber()).isNotEqualTo(smallerNumber);
    }

}