package dms.pastor.utils.vaildators;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class UKMobileNumberValidatorTest {

    private Boolean expectedResult;
    private String number;

    public UKMobileNumberValidatorTest(boolean expectedResult, String number) {
        this.expectedResult = expectedResult;
        this.number = number;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {FALSE, null}, {FALSE, EMPTY_STRING},
            {FALSE, "+4871351123456"}, {FALSE, "-447912345678"},
            {FALSE, "+4871351123456"}, {FALSE, "-447912345678"},
            {TRUE, "+447912345678"}, {TRUE, "07912345678"}, {TRUE, "7912345678"},{TRUE, "0791 2345678"},
            {FALSE, "+4479"}, {FALSE, "07"}, {FALSE, "791"},{FALSE, "0791 2345  8"},
            {FALSE, "01545 570881"}, {FALSE, "02012345678"}, {FALSE, "03450774224"},
            {FALSE, "0800 0123456"}
        });
    }

    @Test
    public void shouldVerifyIsNumberIsValidUKPhoneNumber() {
        System.out.println("Verify is number: " + number + " is valid") ;

        // when
        final var result = UKMobileNumberValidator.validate(number);

        // then
        assertThat(result).isEqualTo(expectedResult);

    }
}