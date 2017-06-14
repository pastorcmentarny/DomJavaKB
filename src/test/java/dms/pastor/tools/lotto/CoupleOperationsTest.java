package dms.pastor.tools.lotto;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static dms.pastor.tools.lotto.CoupleBuilder.coupleBuilder;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 13/03/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class CoupleOperationsTest {

    @Test
    public void deleteDiscardedCouplesShouldDelete2Items() throws Exception {
        // given
        final Couple couple1 = coupleBuilder()
                .smallerNumber(1)
                .largerNumber(2)
                .build();
        final Couple couple2 = coupleBuilder()
                .smallerNumber(3)
                .largerNumber(4)
                .build();
        final Couple couple3 = coupleBuilder()
                .smallerNumber(5)
                .largerNumber(6)
                .build();
        final Couple couple4 = coupleBuilder()
                .smallerNumber(7)
                .largerNumber(8)
                .build();

        final Set<Couple> coupleSet = new HashSet<>(asList(couple1, couple2, couple3, couple4));

        final Set<Couple> coupleToDeleteSet = new HashSet<>(asList(couple3, couple4));

        Set<Couple> expectedCoupleSet = new HashSet<>(asList(couple1, couple2));

        // when
        final Set<Couple> resultCouplesSet = CoupleOperations.deleteDiscardedCouples(coupleSet, coupleToDeleteSet);

        // then
        assertThat(resultCouplesSet).isEqualTo(expectedCoupleSet);
    }
}