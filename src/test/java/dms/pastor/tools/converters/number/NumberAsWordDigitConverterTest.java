package dms.pastor.tools.converters.number;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static dms.pastor.tools.converters.number.NumberAsWordDigitConverter.toDigit;
import static org.assertj.core.api.Assertions.assertThat;

public final class NumberAsWordDigitConverterTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void toDigitShouldReturn0ForZero() {
        // given
        final String numberAsString = "zero";
        final int numberAsInteger = 0;

        // when
        final int digit = toDigit(numberAsString);

        // then
        assertThat(digit).isEqualTo(numberAsInteger);
    }

    @Test
    public void toDigitShouldReturn1ForOne() {
        // given
        final String numberAsString = "One";
        final int numberAsInteger = 1;

        // when
        final int digit = toDigit(numberAsString);

        // then
        assertThat(digit).isEqualTo(numberAsInteger);
    }

    @Test
    public void toDigitShouldReturn2ForTwo() {
        // given
        final String numberAsString = "Two";
        final int numberAsInteger = 2;

        // when
        final int digit = toDigit(numberAsString);

        // then
        assertThat(digit).isEqualTo(numberAsInteger);
    }

    @Test
    public void toDigitShouldReturn3ForThree() {
        // given
        final String numberAsString = "Three";
        final int numberAsInteger = 3;

        // when
        final int digit = toDigit(numberAsString);

        // then
        assertThat(digit).isEqualTo(numberAsInteger);
    }

    @Test
    public void toDigitShouldReturn4ForFour() {
        // given
        final String numberAsString = "Four";
        final int numberAsInteger = 4;

        // when
        final int digit = toDigit(numberAsString);

        // then
        assertThat(digit).isEqualTo(numberAsInteger);
    }

    @Test
    public void toDigitShouldReturn5ForFive() {
        // given
        final String numberAsString = "Five";
        final int numberAsInteger = 5;

        // when
        final int digit = toDigit(numberAsString);

        // then
        assertThat(digit).isEqualTo(numberAsInteger);
    }

    @Test
    public void toDigitShouldReturn6ForSix() {
        // given
        final String numberAsString = "Six";
        final int numberAsInteger = 6;

        // when
        final int digit = toDigit(numberAsString);

        // then
        assertThat(digit).isEqualTo(numberAsInteger);
    }

    @Test
    public void toDigitShouldReturn7ForSeven() {
        // given
        final String numberAsString = "Seven";
        final int numberAsInteger = 7;

        // when
        final int digit = toDigit(numberAsString);

        // then
        assertThat(digit).isEqualTo(numberAsInteger);
    }

    @Test
    public void toDigitShouldReturn8ForEight() {
        // given
        final String numberAsString = "Eight";
        final int numberAsInteger = 8;

        // when
        final int digit = toDigit(numberAsString);

        // then
        assertThat(digit).isEqualTo(numberAsInteger);
    }

    @Test
    public void toDigitShouldReturn9ForNine() {
        // given
        final String numberAsString = "Nine";
        final int numberAsInteger = 9;

        // when
        final int digit = toDigit(numberAsString);

        // then
        assertThat(digit).isEqualTo(numberAsInteger);
    }

    @Test
    public void toDigitShouldReturn10ForTen() {
        // given
        final String numberAsString = "Ten";
        final int numberAsInteger = 10;

        // when
        final int digit = toDigit(numberAsString);

        // then
        assertThat(digit).isEqualTo(numberAsInteger);
    }

    @Test
    public void toDigitShouldReturn11ForEleven() {
        // given
        final String numberAsString = "Eleven";
        final int numberAsInteger = 11;

        // when
        final int digit = toDigit(numberAsString);

        // then
        assertThat(digit).isEqualTo(numberAsInteger);
    }

    @Test
    public void toDigitShouldReturn12ForTwelve() {
        // given
        final String numberAsString = "Twelve";
        final int numberAsInteger = 12;

        // when
        final int digit = toDigit(numberAsString);

        // then
        assertThat(digit).isEqualTo(numberAsInteger);
    }

    @Test
    public void toDigitShouldReturn13ForThirteen() {
        // given
        final String numberAsString = "Thirteen";
        final int numberAsInteger = 13;

        // when
        final int digit = toDigit(numberAsString);

        // then
        assertThat(digit).isEqualTo(numberAsInteger);
    }

    @Test
    public void toDigitShouldReturn14ForFourteen() {
        // given
        final String numberAsString = "Fourteen";
        final int numberAsInteger = 14;

        // when
        final int digit = toDigit(numberAsString);

        // then
        assertThat(digit).isEqualTo(numberAsInteger);
    }

    @Test
    public void toDigitShouldReturn15ForFifteen() {
        // given
        final String numberAsString = "Fifteen";
        final int numberAsInteger = 15;

        // when
        final int digit = toDigit(numberAsString);

        // then
        assertThat(digit).isEqualTo(numberAsInteger);
    }

    @Test
    public void toDigitShouldReturn16ForSixteen() {
        // given
        final String numberAsString = "Sixteen";
        final int numberAsInteger = 16;

        // when
        final int digit = toDigit(numberAsString);

        // then
        assertThat(digit).isEqualTo(numberAsInteger);
    }

    @Test
    public void toDigitShouldReturn16ForSeventeen() {
        // given
        final String numberAsString = "Seventeen";
        final int numberAsInteger = 17;

        // when
        final int digit = toDigit(numberAsString);

        // then
        assertThat(digit).isEqualTo(numberAsInteger);
    }

    @Test
    public void toDigitShouldReturn18ForEighteen() {
        // given
        final String numberAsString = "Eighteen";
        final int numberAsInteger = 18;

        // when
        final int digit = toDigit(numberAsString);

        // then
        assertThat(digit).isEqualTo(numberAsInteger);
    }

    @Test
    public void toDigitShouldReturn16ForNineteen() {
        // given
        final String numberAsString = "Nineteen";
        final int numberAsInteger = 19;

        // when
        final int digit = toDigit(numberAsString);

        // then
        assertThat(digit).isEqualTo(numberAsInteger);
    }

    @Test
    public void toDigitShouldReturn20ForTwenty() {
        // given
        final String numberAsString = "twenty";
        final int numberAsInteger = 20;

        // when
        final int digit = toDigit(numberAsString);

        // then
        assertThat(digit).isEqualTo(numberAsInteger);
    }

    @Test
    public void toDigitShouldReturn22ForTwentyTwo() {
        // given
        final String numberAsString = "twenty two";
        final int numberAsInteger = 22;

        // when
        final int digit = toDigit(numberAsString);

        // then
        assertThat(digit).isEqualTo(numberAsInteger);
    }

    @Test
    public void toDigitShouldReturn23ForTwentyThree() {
        // given
        final String numberAsString = "twenty three";
        final int numberAsInteger = 23;

        // when
        final int digit = toDigit(numberAsString);

        // then
        assertThat(digit).isEqualTo(numberAsInteger);
    }

    @Test
    public void toDigitShouldReturn24ForTwentyFour() {
        // given
        final String numberAsString = "twenty four";
        final int numberAsInteger = 24;

        // when
        final int digit = toDigit(numberAsString);

        // then
        assertThat(digit).isEqualTo(numberAsInteger);
    }

    @Test
    public void toDigitShouldReturn25ForTwentyFive() {
        // given
        final String numberAsString = "twenty five";
        final int numberAsInteger = 25;

        // when
        final int digit = toDigit(numberAsString);

        // then
        assertThat(digit).isEqualTo(numberAsInteger);
    }

    @Test
    public void toDigitShouldReturn26ForTwentySix() {
        // given
        final String numberAsString = "twenty six";
        final int numberAsInteger = 26;

        // when
        final int digit = toDigit(numberAsString);

        // then
        assertThat(digit).isEqualTo(numberAsInteger);
    }

    @Test
    public void toDigitShouldReturn28ForTwentyEight() {
        // given
        final String numberAsString = "twenty eight";
        final int numberAsInteger = 28;

        // when
        final int digit = toDigit(numberAsString);

        // then
        assertThat(digit).isEqualTo(numberAsInteger);
    }

    @Test
    public void toDigitShouldReturn29ForTwentyNine() {
        // given
        final String numberAsString = "twenty nine";
        final int numberAsInteger = 29;

        // when
        final int digit = toDigit(numberAsString);

        // then
        assertThat(digit).isEqualTo(numberAsInteger);
    }

    @Test
    public void toDigitShouldReturn30ForThirsty() {
        // given
        final String numberAsString = "thirty";
        final int numberAsInteger = 30;

        // when
        final int digit = toDigit(numberAsString);

        // then
        assertThat(digit).isEqualTo(numberAsInteger);
    }

    @Test
    public void toDigitShouldReturn33ForThirstyThree() {
        // given
        final String numberAsString = "thirty three";
        final int numberAsInteger = 33;

        // when
        final int digit = toDigit(numberAsString);

        // then
        assertThat(digit).isEqualTo(numberAsInteger);
    }

    @Test
    public void toDigitShouldReturn40ForForty() {
        // given
        final String numberAsString = "forty";
        final int numberAsInteger = 40;

        // when
        final int digit = toDigit(numberAsString);

        // then
        assertThat(digit).isEqualTo(numberAsInteger);
    }

    @Test
    public void toDigitShouldReturn44ForFortyFour() {
        // given
        final String numberAsString = "forty four";
        final int numberAsInteger = 44;

        // when
        final int digit = toDigit(numberAsString);

        // then
        assertThat(digit).isEqualTo(numberAsInteger);
    }

    @Test
    public void toDigitShouldReturn50ForFifty() {
        // given
        final String numberAsString = "fifty";
        final int numberAsInteger = 50;

        // when
        final int digit = toDigit(numberAsString);

        // then
        assertThat(digit).isEqualTo(numberAsInteger);
    }

    @Test
    public void toDigitShouldReturn60ForSixty() {
        // given
        final String numberAsString = "sixty";
        final int numberAsInteger = 60;

        // when
        final int digit = toDigit(numberAsString);

        // then
        assertThat(digit).isEqualTo(numberAsInteger);
    }

    @Test
    public void toDigitShouldReturn70ForSeventy() {
        // given
        final String numberAsString = "seventy";
        final int numberAsInteger = 70;

        // when
        final int digit = toDigit(numberAsString);

        // then
        assertThat(digit).isEqualTo(numberAsInteger);
    }

    @Test
    public void toDigitShouldReturn80ForEighty() {
        // given
        final String numberAsString = "eighty";
        final int numberAsInteger = 80;

        // when
        final int digit = toDigit(numberAsString);

        // then
        assertThat(digit).isEqualTo(numberAsInteger);
    }

    @Test
    public void toDigitShouldReturn90ForNinety() {
        // given
        final String numberAsString = "ninety";
        final int numberAsInteger = 90;

        // when
        final int digit = toDigit(numberAsString);

        // then
        assertThat(digit).isEqualTo(numberAsInteger);
    }

    @Test
    public void toDigitShouldReturn100ForHundred() {
        // given
        final String numberAsString = "hundred";
        final int numberAsInteger = 100;

        // when
        final int digit = toDigit(numberAsString);

        // then
        assertThat(digit).isEqualTo(numberAsInteger);
    }

    @Test
    public void toDigitShouldReturnIllegalArgumentExceptionIfNumberAsStringIsNull() {
        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("number as text cannot be null or empty.");

        // when
        toDigit(null);
    }

    @Test
    public void toDigitShouldReturnIllegalArgumentExceptionIfNumberAsStringIsEmpty() {
        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("number as text cannot be null or empty.");

        // when
        toDigit("");
    }

    @Test
    public void toDigitShouldReturnNumberWhenStringIsInLowerCaseOnly() {
        // given
        final String stringInLowerCaseOnly = "seventeen";

        final int digit = 17;

        // when
        final int digitFromStringInLowerCaseOnly = toDigit(stringInLowerCaseOnly);

        // then
        assertThat(digitFromStringInLowerCaseOnly).isEqualTo(digit);
    }

    @Test
    public void toDigitShouldReturnNumberWhenStringIsInUpperCaseOnly() {
        final String stringInUpperCaseOnly = "SEVENTEEN";
        final int digit = 17;

        // when
        final int digitFromStringInUpperCaseOnly = toDigit(stringInUpperCaseOnly);

        // then
        assertThat(digitFromStringInUpperCaseOnly).isEqualTo(digit);
    }

    @Test
    public void toDigitShouldReturnNumberWhenStringIsInCamelCaseOnly() {
        // given
        final String stringInCamelCase = "Seventeen";
        final int digit = 17;

        // when
        final int digitFromStringInCamelCase = toDigit(stringInCamelCase);

        // then
        assertThat(digitFromStringInCamelCase).isEqualTo(digit);
    }

    @Test
    public void toDigitShouldReturnNumberWhenStringIsInHipsterCaseOnly() {
        // given
        final String stringInHipsterCase = "SeVeNTeEn";
        final int digit = 17;

        // when

        final int digitFromStringInHipsterCase = toDigit(stringInHipsterCase);

        // then
        assertThat(digitFromStringInHipsterCase).isEqualTo(digit);
    }
}