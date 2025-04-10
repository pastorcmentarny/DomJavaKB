package dms.pastor.learn.basics;

import dms.pastor.examples.StringFormatExamples;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * <p>
 * WARNING! Edge case tests omitted as this is just example
 */
public class StringFormatExamplesTest {
    private final StringFormatExamples stringFormatExamples = new StringFormatExamples(5);
    private final int number = 168;

    @Test
    public void shouldPrintTextAlignedToTheRightWithSpecificWidth() {
        // when
        final String result = stringFormatExamples.displayNumberAlignedToRightWithWidth20(number);

        // then
        assertThat(result).isEqualTo("|  " + number + "|");
    }

    @Test
    public void shouldPrintTextAlignedToTheLeftWithSpecificWidth() {
        // when
        final String result = stringFormatExamples.displayNumberAlignedToLeftWithWidth20(number);

        // then
        assertThat(result).isEqualTo("|" + number + "  |");
    }

    @Test
    public void shouldPrintTextAlignedToTheRightWithSpecificWidthAndPadWithZeros() {
        // when
        final String result = stringFormatExamples.displayNumberAlignedToRightWithWidth20AndPadWithZeros(number);

        // then
        assertThat(result).isEqualTo("|00" + number + "|");
    }

    @Test
    public void shouldDisplayNumberWithPlusForPositiveNumber() {
        // when
        final String result = stringFormatExamples.displayPlusForPositiveNumber(number);

        // then
        assertThat(result).isEqualTo("| +" + number + "|");
    }

    @Test
    public void shouldDisplayNumberWithoutPlusForNegativeNumber() {
        // when
        final String result = stringFormatExamples.displayPlusForPositiveNumber(-number);

        // then
        assertThat(result).isEqualTo("| -" + number + "|");
    }

    @Test
    @Disabled
    public void shouldDisplayNumberWithCustomSeparator() {
        // given
        final int thousandOne = 1001;

        // when
        final String result = stringFormatExamples.displayNumberWithAmericanSeparator(thousandOne);

        // then
        assertThat(result).isEqualTo("|1,001|");
    }

    @Test
    public void shouldDisplayFirstFiveCharactersOfText() {
        // given
        final String text = "Warm Welcome To YOU";
        final int length = 4;
        // when
        final String result = stringFormatExamples.displayFirstFewCharactersFor(text, length);

        // then
        assertThat(result).isEqualTo("|Warm|");
    }
}
