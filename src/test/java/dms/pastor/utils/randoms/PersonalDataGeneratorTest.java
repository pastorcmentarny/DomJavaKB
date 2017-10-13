package dms.pastor.utils.randoms;

import dms.pastor.domain.Country;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static dms.pastor.utils.randoms.PersonalDataGenerator.*;
import static java.lang.String.valueOf;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 16/04/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class PersonalDataGeneratorTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonalDataGeneratorTest.class);

    @Rule
    public final ExpectedException exception = ExpectedException.none();

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

    @Test
    public void generatePhoneFromPatternShouldReturnPhoneNumberAcceptanceCriteria() throws Exception {
        // given
        final String pattern = "(+44)XXX-XX-XX";

        // when
        final String phone = generatePhoneNumberForPattern(pattern);

        // then
        assertThat(phone).contains("(+");
        assertThat(phone).contains(")");
        assertThat(phone).contains("-");
        assertThat(phone.charAt(2)).isEqualTo('4');
        assertThat(phone.charAt(3)).isEqualTo('4');
        asList(5, 6, 7, 9, 10, 12, 13).forEach(place -> assertThat(valueOf(phone.charAt(place))).containsOnlyDigits());

        // debug info
        LOGGER.info(phone);

    }

    @Test
    public void generatePhoneNumberForPatternShouldThrowIllegalArgumentExceptionForNull() throws Exception {
        // expect
        exception.expect(IllegalArgumentException.class);

        // when
        generatePhoneNumberForPattern(null);
    }

    @Test
    public void generatePhoneNumberForPatternShouldThrowIllegalArgumentExceptionIfStringContainsInvalidCharacter() throws Exception {
        // expect
        exception.expect(IllegalArgumentException.class);

        // when
        final String output = generatePhoneNumberForPattern("3s100");

        System.out.println(output);
    }

    @Test
    public void generatePhoneNumberForPatternShouldReturnEmptyStringForEmptyInput() throws Exception {
        // given
        final String empty = "";

        // when
        final String result = generatePhoneNumberForPattern(empty);

        // then
        assertThat(result).isEmpty();

    }

    @Test
    public void generatePhoneNumberForPatternShouldReplaceCapitalXWithRandomNumber() throws Exception {
        // given
        final String x = "X";

        // when
        final String result = generatePhoneNumberForPattern(x);

        // then
        assertThat(result).containsOnlyDigits();

        // debug info
        LOGGER.debug(result);
    }

    @Test
    public void generatePhoneNumberForPatternShouldReturnTheSameNumberForGivenNumber() throws Exception {
        // given
        final String x = "732";

        // when
        final String result = generatePhoneNumberForPattern(x);

        // then
        assertThat(result).containsOnlyDigits();

        // debug info
        LOGGER.debug(result);
    }
}
