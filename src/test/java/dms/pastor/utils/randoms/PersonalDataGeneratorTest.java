package dms.pastor.utils.randoms;

import dms.pastor.domain.Country;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static dms.pastor.utils.randoms.PersonalDataGenerator.*;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 16/04/2017
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class PersonalDataGeneratorTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonalDataGeneratorTest.class);

    @Test
    public void shouldGenerateFirstNameAcceptanceTest() throws Exception {
        // when
        final String result = generateFirstName();

        // debug info
        LOGGER.info(result);

        // then
        assertThat(result).isNotEmpty();

    }

    @Test
    public void shouldGenerateSurnameAcceptanceTest() throws Exception {
        // when
        final String result = generateSurname();

        // debug info
        LOGGER.info(result);

        // then
        assertThat(result).isNotEmpty();
    }

    @Test
    public void shouldGenerateRandomEmailTest() throws Exception {
        // when
        final String email = generateEmail();

        // debug info
        LOGGER.info(email);

        // then
        assertThat(email).isNotEmpty();
        assertThat(email).contains("@");
        assertThat(email).contains(".");
    }

    @Test
    public void shouldReturnRandomCountryTest() throws Exception {
        // when
        Country country = getRandomCountry();

        // then
        assertThat(country).isNotNull();

        // debug info
        LOGGER.info(country.toString());

    }

}
