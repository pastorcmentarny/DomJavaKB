package dms.pastor.tasks.romanarabicconverter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static dms.pastor.tasks.romanarabicconverter.RomanNumerals.getArabicForRoman;
import static org.assertj.core.api.Assertions.assertThat;

public class RomanNumeralsTest {


    @Test
    public void getArabicForRomanShouldThrowIllegalArgumentExceptionIfCharacterIsInvalid() {
        // when
        Assertions.assertThrows(IllegalArgumentException.class, () -> getArabicForRoman('Q'));
    }

    @Test
    public void getArabicForRomanShouldThrowIllegalArgumentExceptionIfCharacterIsNotCapitalLetter() {
        // when
        Assertions.assertThrows(IllegalArgumentException.class, () -> getArabicForRoman('x'));

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