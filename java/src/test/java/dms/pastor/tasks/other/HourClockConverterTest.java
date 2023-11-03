package dms.pastor.tasks.other;

import dms.pastor.domain.exception.SomethingWentWrongException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/*
    12/24 Hour Time converter = TDD mechanical practise only
    from    12:00 AM    <=>	00:00 to 11:00 PM  <=>   23:00
 */
class HourClockConverterTest {


    @Test
    public void to24HourShouldThrowExceptionIfInputNullTest() {
        // when & then
        assertThrows(SomethingWentWrongException.class, () -> HourClockConverter.to24Hour(null));
    }

    @Test
    public void to24HourShouldThrowExceptionIfInputEmptyTest() {
        // when & then
        assertThrows(SomethingWentWrongException.class, () -> HourClockConverter.to24Hour(""));
    }

    @ParameterizedTest
    @CsvSource(value = {"12:00 AM;00:00", "01:00 AM;01:00", "02:00 AM;02:00", "03:00 AM;03:00", "04:00 AM;04:00", "05:00 AM;05:00", "06:00 AM;06:00", "07:00 AM;07:00", "08:00 AM;08:00", "09:00 AM;09:00", "10:00 AM;10:00", "11:00 AM;11:00", "12:00 PM;12:00", "01:00 PM;13:00", "02:00 PM;14:00", "03:00 PM;15:00", "04:00 PM;16:00", "05:00 PM;17:00", "06:00 PM;18:00", "07:00 PM;19:00", "08:00 PM;20:00", "09:00 PM;21:00", "10:00 PM;22:00", "11:00 PM;23:00"}, delimiter = ';')
    public void to24HourShouldReturn24For12AMTest(String input, String expectedResult) {

        // when
        var result = HourClockConverter.to24Hour(input);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }


    @Test
    public void to12HourShouldThrowExceptionIfInputNullTest() {
        // when & then
        assertThrows(SomethingWentWrongException.class, () -> HourClockConverter.to12Hour(null));
    }

    @Test
    public void to12HourShouldThrowExceptionIfInputEmptyTest() {
        // when & then
        assertThrows(SomethingWentWrongException.class, () -> HourClockConverter.to12Hour(""));
    }

    @ParameterizedTest
    @CsvSource(value = {"00:00;12:00 AM", "01:00;01:00 AM", "02:00;02:00 AM", "03:00;03:00 AM", "04:00;04:00 AM", "05:00;05:00 AM", "06:00;06:00 AM", "07:00;07:00 AM", "08:00;08:00 AM", "09:00;09:00 AM", "10:00;10:00 AM", "11:00;11:00 AM", "12:00;12:00 PM", "13:00;01:00 PM", "14:00;02:00 PM", "15:00;03:00 PM", "16:00;04:00 PM", "17:00;05:00 PM", "18:00;06:00 PM", "19:00;07:00 PM", "20:00;08:00 PM", "21:00;09:00 PM", "22:00;10:00 PM", "23:00;11:00 PM"}, delimiter = ';')
    public void to12HourShouldMidnightFor12AMTest(String input, String expectedResult) {
        // when
        var result = HourClockConverter.to12Hour(input);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

}