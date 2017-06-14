package dms.pastor.domain;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static dms.pastor.domain.Country.UNITED_KINGDOM;
import static dms.pastor.domain.Country.getName;
import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class CountryTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @SuppressWarnings("ConstantConditions") //because this is purpose of test
    @Test
    public void shouldReturnNullIfCountryIsNullTest() throws Exception {
        // expect
        exception.expect(IllegalArgumentException.class);

        // when
        getName(null);
    }

    @Test
    public void shouldReturnNullIfCountryIsInvalidTest() throws Exception {
        // expect
        exception.expect(IllegalArgumentException.class);

        // when
        getName(Country.valueOf(generateString()));
    }

    @Test
    public void shouldReturnUnitedKingdomTest() throws Exception {
        // when
        final String country = getName(UNITED_KINGDOM);

        // then
        assertThat("United Kingdom").isEqualTo(country);
    }
}