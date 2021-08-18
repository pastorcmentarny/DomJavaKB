package dms.pastor.spring;

import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.Repeat;

import static dms.pastor.spring.DomUtils.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DomUtilsTest {

    private static final int REPEAT_AMOUNT = 100;

    @Test //TODO finish it
    void getRandomCharacterFromAlphabet() {
    }

    @Test
    void generateStringAcceptanceTest() {
        // when
        final var result = generateString();

        // then
        assertThat(result).isNotBlank();
    }

    @Repeat(REPEAT_AMOUNT)
    @Test
    void testGenerateStringWithMaxParameterAcceptanceTest() {
        // given
        final var maxStringSize = 20;

        // when
        final var result = generateString(maxStringSize);

        // then
        assertThat(result).isNotBlank();
        assertThat(result.length()).isLessThanOrEqualTo(maxStringSize);
    }

    @Repeat(REPEAT_AMOUNT)
    @Test
    void testGenerateStringWithMinAndMaxAcceptanceTest() {
        // given
        final var minStringSize = 10;
        final var maxStringSize = 20;

        // when
        final var result = generateString(minStringSize, maxStringSize);

        // then
        assertThat(result).isNotBlank();
        assertThat(result.length()).isGreaterThanOrEqualTo(minStringSize);
        assertThat(result.length()).isLessThanOrEqualTo(maxStringSize);
    }

    @Test
    void testGenerateStringWithMinAndMaxThrowsExceptionForInvalidInput() {
        // when and then no exception throws
        assertThrows(IllegalArgumentException.class, () -> generateString(-1, -2));

    }

    @Repeat(REPEAT_AMOUNT)
    @Test
    void randomPositiveIntegerAcceptanceTest() {
        // when
        final var result = randomPositiveInteger();

        // then
        assertThat(result).isGreaterThan(0);
    }

    @Test
    void validateIfPositiveNumberPassedForPositiveNumberAcceptanceTest() {
        // when
        DomUtils.validateIfPositiveNumber(10);

        // no exception thrown
    }

    @Test
    void validateIfPositiveNumberThrowsExceptionForNegativeNumberAcceptanceTest() {
        // when & then
        assertThrows(IllegalArgumentException.class, () -> DomUtils.validateIfPositiveNumber(-10));

    }

    @Test
    void isStopWordAcceptanceTestReturnTrueForStopWord() {
        // when
        final var result = DomUtils.isStopWord("an");

        // then
        assertThat(result).isTrue();
    }

    @Test
    void isStopWordAcceptanceTestReturnFalseForNonStopWord() {
        // when
        final var result = DomUtils.isStopWord("garlic");

        // then
        assertThat(result).isFalse();
    }

    @Test
    void isStopWordAcceptanceTestReturnFalseForEmpty() {
        // when
        final var result = DomUtils.isStopWord("");

        // then
        assertThat(result).isFalse();
    }

    @Test
    void isNotStopWordAcceptanceTestReturnTrueForNonStopWord() {
        // when
        final var result = isNotStopWord("garlic");

        // then
        assertThat(result).isTrue();
    }

    @Test
    void isNotStopWordAcceptanceTestReturnFalseForStopWord() {
        // when
        final var result = isNotStopWord("an");

        // then
        assertThat(result).isFalse();
    }

    @Test
    void isValueInRangeIsTrueIfInRange() {
        // when
        final var result = isValueInRange(1, 3, 2);

        // then
        assertThat(result).isTrue();
    }

    @Test
    void isValueInRangeIsFalseIfTooLow() {
        // when
        final var result = isValueInRange(5, 6, 4);

        // then
        assertThat(result).isFalse();
    }

    @Test
    void isValueInRangeIsFalseIfTooHigh() {
        // when
        final var result = isValueInRange(7, 8, 9);

        // then
        assertThat(result).isFalse();
    }

    @Test
    void validateMinValueIsSmallerThanMaxValueAcceptanceTest() {
        // when and then no exception throws
        validateMinValueIsSmallerThanMaxValue(1, 10);
    }

    @Test
    void validateMinValueIsSmallerThanMaxValueThrowsExceptionAcceptanceTest() {
        // when and then throw exception
        assertThrows(IllegalArgumentException.class, () -> validateMinValueIsSmallerThanMaxValue(10, 1));
    }

    @Test
    void validateValueIsSmallerOrEqualsThatOtherValueAcceptanceTest() {
        // when and then no exception throws
        assertThrows(IllegalArgumentException.class, () -> validateValueIsSmallerOrEqualsThatOtherValue(1, -1));
    }

    @Test
    void validateValueIsSmallerOrEqualsThatOtherValueThrowsException() {
        // when and then no exception throws
        assertThrows(IllegalArgumentException.class, () -> validateValueIsSmallerOrEqualsThatOtherValue(2, 1));
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    void isStringBlankShouldReturnTrueForNull() {
        // when
        final var result = isStringBlank(null);

        // then
        assertThat(result).isTrue();
    }

    @Test
    void isStringBlankShouldReturnTrueForEmpty() {
        // when
        final var result = isStringBlank("");

        // then
        assertThat(result).isTrue();
    }

    @Test
    void isStringBlankShouldReturnTrueForWhiteSpacesOnly() {
        // when
        final var result = isStringBlank("        ");

        // then
        assertThat(result).isTrue();
    }

    @Test
    void isStringBlankShouldReturnFalseForNonBlankString() {
        // when
        final var result = isStringBlank("Ufo");

        // then
        assertThat(result).isFalse();
    }

}