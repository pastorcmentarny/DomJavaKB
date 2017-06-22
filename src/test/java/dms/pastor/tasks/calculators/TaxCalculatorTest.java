package dms.pastor.tasks.calculators;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Random;

import static dms.pastor.tasks.calculators.TaxCalculator.FULL_PERSONAL_ALLOWANCE_LIMIT;
import static dms.pastor.tasks.calculators.TaxCalculator.getNetSalary;
import static dms.pastor.tasks.calculators.TaxCalculator.getPersonalAllowanceFor;
import static org.hamcrest.CoreMatchers.is;

/**
 * Author Dominik Symonowicz
 * Created 17/03/2016
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class TaxCalculatorTest {

    private static final int BOUND = 10000;
    private final Random random = new Random();
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldThrowExceptionWhenSalaryIsBelowZeroTest() throws Exception {
        // given
        final int salary = (random.nextInt(BOUND) + 1) * (-1);

        // except
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Salary cannot be negative.");

        // when
        getNetSalary(salary);
    }

    @Test
    public void shouldReturnSalaryTest() throws Exception {
        // given
        final int salary = random.nextInt(BOUND);

        // when
        final int netSalary = getNetSalary(salary);

        // then
        Assert.assertThat(netSalary, is(salary));
    }

    @Test
    public void shouldReturnNetSalaryReducedByBasicRateTest() throws Exception {
        // given
        final int salary = 30600;
        final int expectedNetSalary = 26600;

        // when
        final int netSalary = getNetSalary(salary);

        // then
        Assert.assertThat(netSalary, is(expectedNetSalary));
    }

    /*
        You have £35,000 of taxable income and you get the standard Personal Allowance of £10,600.
        You pay basic rate tax at 20% on £24,400 (£35,000 minus £10,600).
     */
    @Test
    public void shouldReturnNetSalaryBasedOnGovUkExample() throws Exception {
        // given
        final int salary = 35000;
        final int expectedNetSalary = 30120;

        // when
        final int netSalary = getNetSalary(salary);

        // then
        Assert.assertThat(netSalary, is(expectedNetSalary));
    }

    @Test
    public void shouldReturnNetSalaryForHighRateSalary() throws Exception {
        // given
        final int salary = 45000;
        final int expectedNetSalary = 37597;

        // when
        final int netSalary = getNetSalary(salary);

        // then
        Assert.assertThat(netSalary, is(expectedNetSalary));
    }

    @Test
    public void shouldReturnNetSalaryForHighRateSalaryWithoutPersonalAllowance() throws Exception {
        // given
        final int salary = 121200;
        final int expectedNetSalary = 79077;

        // when
        final int netSalary = getNetSalary(salary);

        // then
        Assert.assertThat(netSalary, is(expectedNetSalary));
    }

    @Test
    public void shouldReturnNetSalaryForTopRateSalary() throws Exception {
        // given
        final int salary = 200000;
        final int expectedNetSalary = 123857;

        // when
        final int netSalary = getNetSalary(salary);

        // then
        Assert.assertThat(netSalary, is(expectedNetSalary));
    }

    @Test
    public void shouldReturnAllPersonalAllowanceForSalaryLessThan100000() {
        // given
        final int salary = random.nextInt(100000);

        // when
        final int personalAllowance = getPersonalAllowanceFor(salary).intValue();

        // then
        Assert.assertThat(personalAllowance, is(TaxCalculator.DEFAULT_PERSONAL_ALLOWANCE_AMOUNT));
    }

    @Test
    public void shouldReturnZeroAllowanceWhenSalaryEqualPersonalAllowanceLimit() {
        // given
        final int salary = 121200;

        // when
        final int personalAllowance = getPersonalAllowanceFor(salary).intValue();

        // then
        Assert.assertThat(personalAllowance, is(0));
    }

    @Test
    public void shouldReturnReducedPersonalAllowanceTest() throws Exception {
        // given
        final int salary = 100002;
        final int salary2 = 110000;
        final int salary3 = 120000;

        // when
        final int personalAllowance = getPersonalAllowanceFor(salary).intValue();
        final int personalAllowance2 = getPersonalAllowanceFor(salary2).intValue();
        final int personalAllowance3 = getPersonalAllowanceFor(salary3).intValue();

        // then
        Assert.assertThat(personalAllowance, is(10599));
        Assert.assertThat(personalAllowance2, is(5600));
        Assert.assertThat(personalAllowance3, is(600));
    }

    @Test
    public void shouldReturnZeroAllowanceWhenSalaryAbovePersonalAllowanceLimit() {
        // given
        final int salary = FULL_PERSONAL_ALLOWANCE_LIMIT + random.nextInt(Integer.MAX_VALUE - FULL_PERSONAL_ALLOWANCE_LIMIT);

        // when
        final int personalAllowance = getPersonalAllowanceFor(salary).intValue();

        // then
        Assert.assertThat(personalAllowance, is(0));
    }
}