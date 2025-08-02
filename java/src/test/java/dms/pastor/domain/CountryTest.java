package dms.pastor.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static dms.pastor.domain.Country.UNITED_KINGDOM;
import static dms.pastor.domain.Country.getName;
import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
public class CountryTest {


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