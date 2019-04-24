package dms.pastor.tools.salarycalc;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Author Dominik Symonowicz
 * Created 08/01/2019
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class CalculatorTest {
    final Calculator calculator = new Calculator(0,0);

    @Test //TODO do proper test
    public void shouldGetBasicSalary() throws Exception {

        // when
        final int result = calculator.getBasicSalary();

        // debug
        System.out.println(result);

        // then
        assertThat(result).isGreaterThanOrEqualTo(50000);
    }

    @Test
    public void shouldZoneOneAddonAcceptanceTest(){

        // when
        final int result = calculator.zoneOneAddon();

        // debug
        System.out.println(result);

        // then
        assertThat(result).isGreaterThan(2000);
    }

    @Test
    public void shouldIncreaseSalaryIfAnnualLeaveIsLessThan25() {
        // given

        // when
        final int adjustment = calculator.getHolidayAdjustment(23);
        final int salary = calculator.getBasicSalary() + adjustment;

        // then
        assertThat(salary).isGreaterThan(calculator.getBasicSalary());

        // debug
        System.out.println(salary);
    }

    @Test
    public void shouldDecreaseSalaryIfAnnualLeaveIsMoreThan25() {
        // given

        // when
        final int adjustment = calculator.getHolidayAdjustment(27);
        final int salary = calculator.getBasicSalary() + adjustment;

        // then
        assertThat(salary).isLessThan(calculator.getBasicSalary());

        // debug
        System.out.println(salary);
    }

    @Test
    public void shouldSalaryRemainsSameIfAnnualLeaveIs25() {
        // given

        // when
        final int adjustment = calculator.getHolidayAdjustment(25);
        final int salary = calculator.getBasicSalary() + adjustment;

        // then
        assertThat(salary).isEqualTo(calculator.getBasicSalary());

        // debug
        System.out.println(salary);
    }


    @Test
    public void getTravelTimeSalaryAdjustmentShouldDecreaseSalaryIfTravelTimeIsLowerThanOptimal() {
        // given

        // when
        final int adjustment = calculator.getTravelTimeSalaryAdjustment(40);
        final int salary = calculator.getBasicSalary() + adjustment;

        // then
        assertThat(salary).isLessThan(calculator.getBasicSalary());

        // debug
        System.out.println(salary);

    }

    @Test
    public void getTravelTimeSalaryAdjustmentShouldDoNotChangeSalaryIfTravelTimeIsHigherIsMaxAllowed() {
        // given

        // when
        final int adjustment = calculator.getTravelTimeSalaryAdjustment(45);
        final int salary = calculator.getBasicSalary() + adjustment;

        // then
        assertThat(salary).isEqualTo(calculator.getBasicSalary());

        // debug
        System.out.println(salary);

    }

    @Test
    public void getTravelTimeSalaryAdjustmentShouldIncreaseSalaryIfTravelTimeIsHigherThanOptimal() {
        // given

        // when
        final int adjustment = calculator.getTravelTimeSalaryAdjustment(50);
        final int salary = calculator.getBasicSalary() + adjustment;

        // then
        assertThat(salary).isGreaterThan(calculator.getBasicSalary());

        // debug
        System.out.println(salary);

    }


    @Test
    public void getSeniorPenaltyShouldIncreaseSalaryBy50Percent() {
        // given

        // when
        final int seniorPenalty = calculator.getSeniorPenalty();

        // then
        assertThat(seniorPenalty).isGreaterThan(calculator.getBasicSalary());
    }
}