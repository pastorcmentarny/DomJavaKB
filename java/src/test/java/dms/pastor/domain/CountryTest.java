package dms.pastor.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static dms.pastor.domain.Country.UNITED_KINGDOM;
import static dms.pastor.domain.Country.getName;
import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class CountryTest {


    //because this is purpose of test
    @Test
    public void shouldReturnNullIfCountryIsNullTest() {
        // when
        Assertions.assertThrows(IllegalArgumentException.class, () -> getName(null));
    }

    @Test
    public void shouldReturnNullIfCountryIsInvalidTest() {
        // when
        Assertions.assertThrows(IllegalArgumentException.class, () -> getName(Country.valueOf(generateString())));
    }

    @Test
    public void shouldReturnUnitedKingdomTest() {
        // when
        final String country = getName(UNITED_KINGDOM);

        // then
        assertThat("United Kingdom").isEqualTo(country);
    }
}