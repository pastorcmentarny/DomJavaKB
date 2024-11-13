package dms.pastor.tasks.calculators;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static dms.pastor.tasks.calculators.TaxCalculator.*;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 17/03/2016
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class TaxCalculatorTest {

    private static final int BOUND = 10000;

    private final Random random = new Random();

    @Test
    public void shouldThrowExceptionWhenSalaryIsBelowZeroTest() {
        // given
        final int salary = (random.nextInt(BOUND) + 1) * (-1);

        // when
        Assertions.assertThrows(IllegalArgumentException.class, () -> getNetSalary(salary));

    }

    @Test
    public void shouldReturnSalaryTest() {
        // given
        final int salary = random.nextInt(BOUND);

        // when
        final int netSalary = getNetSalary(salary);

        // then
        assertThat(netSalary).isEqualTo(salary);
    }

    @Test
    public void shouldReturnNetSalaryReducedByBasicRateTest() {
        // given
        final int salary = 30600;
        final int expectedNetSalary = 26600;

        // when
        final int netSalary = getNetSalary(salary);

        // then
        assertThat(netSalary).isEqualTo(expectedNetSalary);
    }

    /*
        You have £35,000 of taxable income and you get the standard Personal Allowance of £10,600.
        You pay basic rate tax at 20% on £24,400 (£35,000 minus £10,600).
     */
    @Test
    public void shouldReturnNetSalaryBasedOnGovUkExample() {
        // given
        final int salary = 35000;
        final int expectedNetSalary = 30120;

        // when
        final int netSalary = getNetSalary(salary);

        // then
        assertThat(netSalary).isEqualTo(expectedNetSalary);
    }

    @Test
    public void shouldReturnNetSalaryForHighRateSalary() {
        // given
        final int salary = 45000;
        final int expectedNetSalary = 37597;

        // when
        final int netSalary = getNetSalary(salary);

        // then
        assertThat(netSalary).isEqualTo(expectedNetSalary);
    }

    @Test
    public void shouldReturnNetSalaryForHighRateSalaryWithoutPersonalAllowance() {
        // given
        final int salary = 121200;
        final int expectedNetSalary = 79077;

        // when
        final int netSalary = getNetSalary(salary);

        // then
        assertThat(netSalary).isEqualTo(expectedNetSalary);
    }

    @Test
    public void shouldReturnNetSalaryForTopRateSalary() {
        // given
        final int salary = 200000;
        final int expectedNetSalary = 123857;

        // when
        final int netSalary = getNetSalary(salary);

        // then
        assertThat(netSalary).isEqualTo(expectedNetSalary);
    }

    @Test
    public void shouldReturnAllPersonalAllowanceForSalaryLessThan100000() {
        // given
        final int salary = random.nextInt(100000);

        // when
        final int personalAllowance = getPersonalAllowanceFor(salary).intValue();

        // then
        assertThat(personalAllowance).isEqualTo(TaxCalculator.DEFAULT_PERSONAL_ALLOWANCE_AMOUNT);
    }

    @Test
    public void shouldReturnZeroAllowanceWhenSalaryEqualPersonalAllowanceLimit() {
        // given
        final int salary = 121200;

        // when
        final int personalAllowance = getPersonalAllowanceFor(salary).intValue();

        // then
        assertThat(personalAllowance).isEqualTo(0);
    }

    @Test
    public void shouldReturnReducedPersonalAllowanceCase1Test() {
        // given
        final int salary = 100002;

        // when
        final int personalAllowance = getPersonalAllowanceFor(salary).intValue();

        // then
        assertThat(personalAllowance).isEqualTo(10599);

    }

    @Test
    public void shouldReturnReducedPersonalAllowanceCase2Test() {
        // given
        final int salary2 = 110000;

        // when
        final int personalAllowance2 = getPersonalAllowanceFor(salary2).intValue();

        // then
        assertThat(personalAllowance2).isEqualTo(5600);
    }

    @Test
    public void shouldReturnReducedPersonalAllowanceCase3Test() {
        // given
        final int salary3 = 120000;

        // when
        final int personalAllowance3 = getPersonalAllowanceFor(salary3).intValue();

        // then
        assertThat(personalAllowance3).isEqualTo(600);
    }


    @Test
    public void shouldReturnZeroAllowanceWhenSalaryAbovePersonalAllowanceLimit() {
        // given
        final int salary = FULL_PERSONAL_ALLOWANCE_LIMIT + random.nextInt(Integer.MAX_VALUE - FULL_PERSONAL_ALLOWANCE_LIMIT);

        // when
        final int personalAllowance = getPersonalAllowanceFor(salary).intValue();

        // then
        assertThat(personalAllowance).isEqualTo(0);
    }
}