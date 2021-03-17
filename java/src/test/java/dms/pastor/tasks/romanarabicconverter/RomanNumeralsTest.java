package dms.pastor.tasks.romanarabicconverter;

import org.junit.jupiter.api.Test;

import static dms.pastor.tasks.romanarabicconverter.RomanNumerals.getArabicForRoman;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RomanNumeralsTest {


    @Test
    public void getArabicForRomanShouldThrowIllegalArgumentExceptionIfCharacterIsInvalid() {
        // when
        assertThrows(IllegalArgumentException.class, () -> getArabicForRoman('Q'));
    }

    @Test
    public void getArabicForRomanShouldThrowIllegalArgumentExceptionIfCharacterIsNotCapitalLetter() {
        // when
        assertThrows(IllegalArgumentException.class, () -> getArabicForRoman('x'));

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