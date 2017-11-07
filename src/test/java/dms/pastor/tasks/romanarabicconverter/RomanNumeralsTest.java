package dms.pastor.tasks.romanarabicconverter;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static dms.pastor.tasks.romanarabicconverter.RomanNumerals.getArabicForRoman;
import static org.assertj.core.api.Assertions.assertThat;

public class RomanNumeralsTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void getArabicForRomanShouldThrowIllegalArgumentExceptionIfCharacterIsInvalid() {
        // expect
        exception.expect(IllegalArgumentException.class);

        // when
        getArabicForRoman('Q');
    }

    @Test
    public void getArabicForRomanShouldThrowIllegalArgumentExceptionIfCharacterIsNotCapitalLetter() {
        // expect
        exception.expect(IllegalArgumentException.class);

        // when
        getArabicForRoman('x');
    }

    @Test
    public void getArabicForRomanShouldReturnTenForX() {
        // given
        final char ten = 'X';

        // when
        final int arabic = getArabicForRoman(ten);

        // then
        assertThat(arabic).isEqualTo(10);
    }

}