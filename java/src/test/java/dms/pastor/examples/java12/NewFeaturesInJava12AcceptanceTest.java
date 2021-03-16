package dms.pastor.examples.java12;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NewFeaturesInJava12AcceptanceTest {

    @Test
    void returnsClassForAnArrayTypeAcceptanceTest() {
        // given
        var expectedResult = "class [Ljava.lang.String;";
        // when
        var result = NewFeaturesInJava12.returnsClassForAnArrayType();

        // debug
        System.out.println(result);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void stringIntentMethodAcceptanceTest() {
        // given
        var expectedResult = "   Dominik\n";
        // when
        var result = NewFeaturesInJava12.stringIntentMethod();

        // debug
        System.out.println(result);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void compactNumberFormatAcceptanceTest() {
        // given
        var expectedResult = "short: 1K long: 1 thousand\n" +
                "short: 1M long: 1 million";
        // when
        var result = NewFeaturesInJava12.compactNumberFormat();

        // debug
        System.out.println(result);

        // then
        assertThat(result).startsWith(expectedResult);
    }
}