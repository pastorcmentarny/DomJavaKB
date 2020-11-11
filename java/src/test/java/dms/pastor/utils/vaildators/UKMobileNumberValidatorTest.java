package dms.pastor.utils.vaildators;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

public class UKMobileNumberValidatorTest {

    @ParameterizedTest
    @MethodSource("data")
    public void shouldVerifyIsNumberIsValidUKPhoneNumber(boolean expectedResult, String number) {
        System.out.println("Verify is number: " + number + " is valid");
        // when
        final var result = UKMobileNumberValidator.validate(number);

        // then
        assertThat(result).isEqualTo(expectedResult);

    }

    @ValueSource
    private static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(FALSE, null), Arguments.of(FALSE, EMPTY_STRING),
                Arguments.of(FALSE, "+4871351123456"), Arguments.of(FALSE, "-447912345678"),
                Arguments.of(FALSE, "+4871351123456"), Arguments.of(FALSE, "-447912345678"),
                Arguments.of(TRUE, "+447912345678"), Arguments.of(TRUE, "07912345678"), Arguments.of(TRUE, "7912345678"), Arguments.of(TRUE, "0791 2345678"),
                Arguments.of(FALSE, "+4479"), Arguments.of(FALSE, "07"), Arguments.of(FALSE, "791"), Arguments.of(FALSE, "0791 2345  8"),
                Arguments.of(FALSE, "01545 570881"), Arguments.of(FALSE, "02012345678"), Arguments.of(FALSE, "03450774224"),
                Arguments.of(FALSE, "0800 0123456"));
    }

}
