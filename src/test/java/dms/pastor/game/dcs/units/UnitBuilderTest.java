package dms.pastor.game.dcs.units;

import org.junit.Test;

import static dms.pastor.utils.randoms.RandomDataGenerator.randomNegativeInteger;
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
public class UnitBuilderTest {

    @Test
    public void buildShouldReturnUnitThatIsShieldIfSpIsHigherThanZeroAndShieldedIsSetToFalse() throws Exception {

        // when
        final Unit unit = UnitBuilder.unitBuilder()
                .sp(10)
                .shielded(false)
                .build();

        // then
        assertThat(unit.isShielded()).isFalse();
        assertThat(unit.getSp()).isZero();
    }

    @Test
    public void buildShouldReturnUnitWithoutShieldIfSpIsEqualOrLessZeroEvenShieldedIsSetToTrue() throws Exception {

        // when
        final Unit unit = UnitBuilder.unitBuilder()
                .sp(randomNegativeInteger())
                .shielded(true)
                .build();

        // then
        assertThat(unit.isShielded()).isFalse();
        assertThat(unit.getSp()).isZero();
    }

}