package dms.pastor.utils;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.Date;

import static dms.pastor.utils.DateUtils.*;
import static java.time.LocalDate.now;
import static java.time.LocalDate.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Author Dominik Symonowicz
 * Created 19/06/2016
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class DateUtilsTest {


    @Test
    public void shouldReturnTimeZoneListExample() {
        // when
        final String displayTimeZoneList = displayTimeZoneList();

        // then
        assertThat(displayTimeZoneList).isNotNull();
        assertThat(displayTimeZoneList).contains("Europe/Warsaw");
    }

    //because this is purpose of test
    @Test
    public void shouldThrowExceptionWhenAcronymIsNull() {
        // when
        assertThrows(IllegalArgumentException.class, () -> DateUtils.getMonthNumberFromShortedName(null));

    }

    @Test
    public void shouldThrowExceptionWhenAcronymDoesNotMatchMonth() {
        // when
        assertThrows(IllegalArgumentException.class, () -> DateUtils.getMonthNumberFromShortedName("Dominik"));
    }

    @Test
    public void shouldReturn1WhenAcronymIsJan() {
        // when
        int monthNumber = DateUtils.getMonthNumberFromShortedName("Jan");

        // then
        assertThat(monthNumber).isEqualTo(1);
    }


    @SuppressWarnings("UseOfObsoleteDateTimeApi")
    @Test
    public void shouldConvertDateToLocalDate() {
        // given
        Date date = new Date();

        // when
        final java.time.LocalDate localDate = DateUtils.convertDateToLocalDate(date);

        // debug
        System.out.println("java.util.Date: " + date);
        System.out.println("java.time.LocalDate: " + localDate);

        // then
        assertThat(localDate).isNotNull();
    }

    @Test // TODO improve this test
    public void getDayOfTheYearShouldThrowIllegalArgumentExceptionForNull() {
        // when
        final var exception = assertThrows(IllegalArgumentException.class, () -> getDayOfTheYearFor(null));

        // then
        assertThat(exception.getMessage()).isEqualTo("Date cannot be null.");
    }

    @Test
    public void getDayOfTheYearForShouldGetOneForFirstJanuary() {
        // when
        final long days = getDayOfTheYearFor(of(2017, 1, 1));

        // then
        assertThat(days).isEqualTo(1);
    }

    @Test
    public void getDayOfTheYearForShouldGetOneForFirstFebruary() {
        // when
        final long days = getDayOfTheYearFor(of(2017, 2, 1));

        // then
        assertThat(days).isEqualTo(32);
    }

    @Test
    public void getDayOfTheYearForShouldGet365ForLeapYear() {
        // when
        final long days = getDayOfTheYearFor(of(2017, 12, 31));

        // then
        assertThat(days).isEqualTo(365);
    }

    @Test
    public void getDayOfTheYearForShouldGet366ForLeapYear() {
        // when
        final long days = getDayOfTheYearFor(of(2016, 12, 31));

        // then
        assertThat(days).isEqualTo(366);
    }

    @Test
    public void countLeapYearBetweenShouldIllegalArgumentExceptionIfStartDateIsNull() {
        // when
        final var exception = assertThrows(IllegalArgumentException.class, () -> countLeapYearBetween(null, now()));

        // then
        assertThat(exception.getMessage()).isEqualTo("Start date cannot be null.");
    }

    @Test
    public void countLeapYearBetweenShouldIllegalArgumentExceptionIfEndDateIsNull() {
        // when
        final var exception = assertThrows(IllegalArgumentException.class, () -> countLeapYearBetween(now(), null));

        // then
        assertThat(exception.getMessage()).isEqualTo("End date cannot be null.");
    }

    @Test
    public void countLeapYearBetweenShouldThrowIllegalArgumentExceptionWhenEndDateIsBeforeStartDate() {
        // given
        final java.time.LocalDate start = java.time.LocalDate.of(2017, 12, 31);
        final java.time.LocalDate end = java.time.LocalDate.of(2015, 1, 1);

        // when
        assertThrows(IllegalArgumentException.class, () -> countLeapYearBetween(start, end));
    }

    @Test
    public void countLeapYearBetweenShouldReturn1ForYearsBetween2016And2016() {
        // given
        final java.time.LocalDate leapYear = java.time.LocalDate.of(2016, 1, 1);

        // when
        final long leapYearsCounter = countLeapYearBetween(leapYear, leapYear);

        // then
        assertThat(leapYearsCounter).isEqualTo(1);
    }

    @Test
    public void countLeapYearBetweenShouldReturn1ForYearsBetween2015And2017() {
        // given
        final java.time.LocalDate start = java.time.LocalDate.of(2015, 1, 1);
        final java.time.LocalDate end = java.time.LocalDate.of(2017, 12, 31);

        // when
        final long leapYearsCounter = countLeapYearBetween(start, end);

        // then
        assertThat(leapYearsCounter).isEqualTo(1);
    }

    @Test
    public void countLeapYearBetweenShouldReturn5ForYearsBetween2000And2016() {
        // given
        final java.time.LocalDate start = java.time.LocalDate.of(2000, 1, 1);
        final java.time.LocalDate end = java.time.LocalDate.of(2016, 12, 31);

        // when
        final long leapYearsCounter = countLeapYearBetween(start, end);

        // then
        assertThat(leapYearsCounter).isEqualTo(5);
    }

    @Test
    public void monthBetweenNowAndShouldReturnOneForOneMonthDifference() {
        // given
        final java.time.LocalDate date = now().minusMonths(1);

        // when
        final long result = getMonthBetweenNowAnd(date);

        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void shouldReturnNullForNull12HourClockString() {
        // when
        final var result = getLocalTimeFrom12HourClockString(null);

        // then
        assertThat(result).isNull();
    }

    @Test
    @Disabled
    public void shouldReturn900For9amClockString() {
        // given
        final LocalTime expectedResult = LocalTime.of(9, 0);

        // when
        final var result = getLocalTimeFrom12HourClockString("9.00am");

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    @Disabled
    public void getLocalTimeFrom12HourClockStringShouldAcceptDotAsDivider() {
        // given
        final LocalTime expectedResult = LocalTime.of(10, 30);

        // when
        final var result = getLocalTimeFrom12HourClockString("10.30am");

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    @Disabled
    public void getLocalTimeFrom12HourClockStringShouldAcceptColonAsDivider() {
        // given
        final LocalTime expectedResult = LocalTime.of(10, 45);

        // when
        final var result = getLocalTimeFrom12HourClockString("10:45am");

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    @Disabled
    public void shouldReturn1800For6pmClockString() {
        // given
        final LocalTime expectedResult = LocalTime.of(18, 0);

        // when
        final var result = getLocalTimeFrom12HourClockString("6.00pm");

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void getDayOfTheWeekAsListAcceptanceTest() {
        // when
        final var result = getWeekDaysAsList();

        // then
        assertThat(result.stream()
                .filter(StringUtils::isStringNotEmpty)
                .count())
                .isEqualTo(7);

    }

    @Test
    public void shouldReturnForLeapYearFor2000() {
        // given
        int year = 2000;

        // when
        final var result = isLeapYear(year);

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void shouldReturnFalseForYearFor2021() {
        // given
        int year = 2021;

        // when
        final var result = isLeapYear(year);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void shouldReturnFalseForYearFor2022() {
        // given
        int year = 2022;

        // when
        final var result = isLeapYear(year);

        // then
        assertThat(result).isFalse();
    }


    @Test
    @Disabled
    public void shouldReturnFalseForYearFor2020() {
        // given
        int year = 2020;

        // when
        final var result = isLeapYear(year);

        // then
        assertThat(result).isFalse();
    }

    @Test //only div by 400 are leap
    public void shouldReturnFalseForYearFor2100() {
        // given
        int year = 2100;

        // when
        final var result = isLeapYear(year);

        // then
        assertThat(result).isFalse();
    }
}
