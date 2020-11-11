package dms.pastor.utils.randoms;

import dms.pastor.domain.Country;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;
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


    @Test
    public void shouldGenerateFirstNameAcceptanceTest() {
        // when
        final String result = generateFirstName();

        // debug info
        LOGGER.info(result);

        // then
        assertThat(result).isNotEmpty();

    }

    @Test
    public void shouldGenerateSurnameAcceptanceTest() {
        // when
        final String result = generateSurname();

        // debug info
        LOGGER.info(result);

        // then
        assertThat(result).isNotEmpty();
    }

    @Test
    public void shouldGenerateRandomEmailTest() {
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
    public void shouldReturnRandomCountryTest() {
        // when
        Country country = getRandomCountry();

        // then
        assertThat(country).isNotNull();

        // debug info
        LOGGER.info(country.toString());
    }

    @Test
    public void generatePhoneFromPatternShouldReturnPhoneNumberAcceptanceCriteria() {
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
    public void generatePhoneNumberForPatternShouldThrowIllegalArgumentExceptionForNull() {
        // when
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            generatePhoneNumberForPattern(null);
        });

    }

    @Test
    public void generatePhoneNumberForPatternShouldThrowIllegalArgumentExceptionIfStringContainsInvalidCharacter() {
        // when
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            final String output = generatePhoneNumberForPattern("3s100");

            System.out.println(output);
        });

    }

    @Test
    public void generatePhoneNumberForPatternShouldReturnEmptyStringForEmptyInput() {
        // when
        final String result = generatePhoneNumberForPattern(EMPTY_STRING);

        // then
        assertThat(result).isEmpty();

    }

    @Test
    public void generatePhoneNumberForPatternShouldReplaceCapitalXWithRandomNumber() {
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
    public void generatePhoneNumberForPatternShouldReturnTheSameNumberForGivenNumber() {
        // given
        final String x = "732";
        // when
        final String result = generatePhoneNumberForPattern(x);

        // then
        assertThat(result).containsOnlyDigits();

        // debug info
        LOGGER.debug(result);
    }

    @Test
    public void generateNameShouldReturnName() {
        // given
        final String name = generateName();
        // when
        assertThat(name).isNotBlank();
        assertThat(name.length()).isGreaterThan(3);

        // debug
        System.out.println(name);

    }
}
