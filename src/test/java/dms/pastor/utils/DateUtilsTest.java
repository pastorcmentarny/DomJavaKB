package dms.pastor.utils;

import org.joda.time.LocalDate;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Date;

import static dms.pastor.utils.DateUtils.*;
import static java.time.LocalDate.now;
import static java.time.LocalDate.of;
import static org.assertj.core.api.Assertions.assertThat;

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

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @SuppressWarnings("SpellCheckingInspection")
    @Test
    public void shouldReturnTimeZoneListExample() throws Exception {
        // when
        final String displayTimeZoneList = displayTimeZoneList();

        // then
        assertThat(displayTimeZoneList).isNotNull();
        assertThat(displayTimeZoneList).contains("Europe/Warsaw");
    }

    @SuppressWarnings("ConstantConditions") //because this is purpose of test
    @Test
    public void shouldThrowExceptionWhenAcronymIsNull() throws Exception {
        // expect
        exception.expect(IllegalArgumentException.class);

        // when
        DateUtils.getMonthNumberFromShortedName(null);
    }

    @Test
    public void shouldThrowExceptionWhenAcronymDoesNotMatchMonth() throws Exception {
        // expect
        exception.expect(IllegalArgumentException.class);

        // when
        DateUtils.getMonthNumberFromShortedName("Dominik");
    }

    @Test
    public void shouldReturn1WhenAcronymIsJan() {
        // when
        int monthNumber = DateUtils.getMonthNumberFromShortedName("Jan");

        // then
        assertThat(monthNumber).isEqualTo(1);
    }

    @Test
    public void shouldConvertJodaDateToJava8Date() throws Exception {
        // given
        final String date = "2016-11-30";
        org.joda.time.LocalDate jodaDate = LocalDate.parse(date);

        // when
        java.time.LocalDate java8Date = DateUtils.toJavaDate(jodaDate);

        // then
        assertThat(java8Date.toString()).isEqualTo(date);
    }

    @SuppressWarnings("UseOfObsoleteDateTimeApi")
    @Test
    public void shouldConvertDateToLocalDate() throws Exception {
        // given
        Date date = new Date();

        // when
        final java.time.LocalDate localDate = DateUtils.convertDateToLocalDate(date);

        // then
        assertThat(localDate).isNotNull();
        System.out.println("java.util.Date: " + date);
        System.out.println("java.time.LocalDate: " + localDate);
    }

    @Test
    public void getDayOfTheYearShouldThrowIllegalArgumentExceptionForNull() throws Exception {
        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Date cannot be null.");
        // when
        final long days = getDayOfTheYearFor(null);

        // then
        assertThat(days).isEqualTo(1);
    }

    @Test
    public void getDayOfTheYearForShouldGetOneForFirstJanuary() throws Exception {
        // when
        final long days = getDayOfTheYearFor(of(2017, 1, 1));

        // then
        assertThat(days).isEqualTo(1);
    }

    @Test
    public void getDayOfTheYearForShouldGetOneForFirstFebruary() throws Exception {
        // when
        final long days = getDayOfTheYearFor(of(2017, 2, 1));

        // then
        assertThat(days).isEqualTo(32);
    }

    @Test
    public void getDayOfTheYearForShouldGet365ForLeapYear() throws Exception {
        // when
        final long days = getDayOfTheYearFor(of(2017, 12, 31));

        // then
        assertThat(days).isEqualTo(365);
    }

    @Test
    public void getDayOfTheYearForShouldGet366ForLeapYear() throws Exception {
        // given

        // when
        final long days = getDayOfTheYearFor(of(2016, 12, 31));

        // then
        assertThat(days).isEqualTo(366);
    }

    @Test
    public void countLeapYearBetweenShouldIllegalArgumentExceptionIfStartDateIsNull() throws Exception {
        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Start date cannot be null.");

        // when
        countLeapYearBetween(null, now());
    }

    @Test
    public void countLeapYearBetweenShouldIllegalArgumentExceptionIfEndDateIsNull() throws Exception {
        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("End date cannot be null.");

        // when
        countLeapYearBetween(now(), null);
    }

    @Test
    public void countLeapYearBetweenShouldThrowIllegalArgumentExceptionWhenEndDateIsBeforeStartDate() throws Exception {
        // expect
        exception.expect(IllegalArgumentException.class);

        // given
        final java.time.LocalDate start = java.time.LocalDate.of(2017, 12, 31);
        final java.time.LocalDate end = java.time.LocalDate.of(2015, 1, 1);

        // when
        countLeapYearBetween(start, end);
    }

    @Test
    public void countLeapYearBetweenShouldReturn1ForYearsBetween2016And2016() throws Exception {
        // given
        final java.time.LocalDate leapYear = java.time.LocalDate.of(2016, 1, 1);

        // when
        final long leapYearsCounter = countLeapYearBetween(leapYear, leapYear);

        // then
        assertThat(leapYearsCounter).isEqualTo(1);
    }

    @Test
    public void countLeapYearBetweenShouldReturn1ForYearsBetween2015And2017() throws Exception {
        // given
        final java.time.LocalDate start = java.time.LocalDate.of(2015, 1, 1);
        final java.time.LocalDate end = java.time.LocalDate.of(2017, 12, 31);

        // when
        final long leapYearsCounter = countLeapYearBetween(start, end);

        // then
        assertThat(leapYearsCounter).isEqualTo(1);
    }

    @Test
    public void countLeapYearBetweenShouldReturn5ForYearsBetween2000And2016() throws Exception {
        // given
        final java.time.LocalDate start = java.time.LocalDate.of(2000, 1, 1);
        final java.time.LocalDate end = java.time.LocalDate.of(2016, 12, 31);

        // when
        final long leapYearsCounter = countLeapYearBetween(start, end);

        // then
        assertThat(leapYearsCounter).isEqualTo(5);
    }

}
