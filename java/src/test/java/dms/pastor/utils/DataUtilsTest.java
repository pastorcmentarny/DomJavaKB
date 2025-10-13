package dms.pastor.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DataUtilsTest {
    private static Stream<Arguments> provideTokenTestData() {
        return Stream.of(
                Arguments.of("1234567890", "12****7890"),
                Arguments.of("5909cdce-f92e-4230-b8a4-d7db1dfcb912", "59******************************b912"));
    }

    private static Stream<Arguments> provideToSmallTokenTestData() {
        return Stream.of(
                Arguments.of("1", "*"),
                Arguments.of("12", "**"),
                Arguments.of("123", "***"),
                Arguments.of("1234", "****"),
                Arguments.of("12345", "*****"),
                Arguments.of("123456", "******"),
                Arguments.of("1234567", "*******"),
                Arguments.of("12345678", "12****5678"));
    }

    @Test
    void maskTokenReturnEmptyForNullTokenTest() {
        // given & when
        final String result = DataUtils.maskToken(null);

        // then
        assertEquals("", result);
    }

    @Test
    void maskTokenReturnEmptyForEmptyTokenTest() {
        // given & when
        final String result = DataUtils.maskToken(null);

        // then
        assertEquals("", result);
    }

    @ParameterizedTest
    @MethodSource("provideToSmallTokenTestData")
    void maskTokenReturnStarsOnlyForSmallTokenTest(String input, String expectedResult) {
        // given & when
        final String result = DataUtils.maskToken(input);

        // then
        assertEquals(expectedResult, result);
    }

    @ParameterizedTest
    @MethodSource("provideTokenTestData")
    void maskTokenAcceptanceTest() {

        // given & when
        final String result = DataUtils.maskToken("1234567890");

        // then
        assertEquals("12****7890", result);
    }
}