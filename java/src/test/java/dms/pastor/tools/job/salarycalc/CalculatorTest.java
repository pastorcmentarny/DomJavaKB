package dms.pastor.tools.job.salarycalc;

import org.junit.Test;

import static dms.pastor.utils.NumberUtils.toIntFromDouble;
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
    protected static final int BASIC_SALARY = 52500;
    final Calculator calculator = new Calculator();
    final Calculator calculatorWithIdealVacancy = new Calculator(Vacancy.getIdealVacancy());

    @Test
    public void shouldGetIdealSalaryForIdealVacancy() {
        // given
        final int expectedSalary = 55000;

        // when
        final var idealSalary = calculatorWithIdealVacancy.calculateSalary();

        // then
        assertThat(idealSalary).isEqualTo(expectedSalary);

    }

    @Test
    public void shouldGetMinimumSalaryIsCalculatedSalaryIsBelow() {

        // when
        final var idealSalary = calculatorWithIdealVacancy.calculateSalary();

        // then
        assertThat(idealSalary).isEqualTo(Calculator.MINIMUM_SALARY);

    }

    @Test
    public void salaryShouldBe20PercentHigherIfInCrapStation() {
        // given
        final Vacancy vacancy = Vacancy.getTypicalVacancy();
        vacancy.inZoneOne();
        vacancy.onHatedStation();
        final var calculatorWithCustomVacancy = new Calculator(vacancy);
        final int expectedSalary = BASIC_SALARY + 10500;
        // when
        final var salary = calculatorWithCustomVacancy.calculateSalary();

        // then
        assertThat(salary).isGreaterThanOrEqualTo(expectedSalary);

        // debug
        System.out.println("In zone 1 on crap station: " + salary);
    }

    @SuppressWarnings("IntegerDivisionInFloatingPointContext") //as accuracy do not matter
    @Test
    public void salaryShouldDecreaseIfWorkFromHomeOptionAvailable() {
        // given
        final Vacancy vacancy = Vacancy.getTypicalVacancy();
        vacancy.inZoneOne();
        vacancy.onHatedStation();
        vacancy.setWfh(true);
        final var calculatorWithCustomVacancy = new Calculator(vacancy);
        final int expectedSalary = BASIC_SALARY + toIntFromDouble(BASIC_SALARY / 100 * 18);
        // when
        final var salary = calculatorWithCustomVacancy.calculateSalary();

        // then
        assertThat(salary).isGreaterThanOrEqualTo(expectedSalary);

        // debug
        System.out.println("With work from home option: " + salary);
    }

    @Test
    public void salaryShouldIncreaseIfAnnualLeaveIsLowerThan25() {
        // given
        final Vacancy vacancy = Vacancy.builder().hours(37.5).timeTravel(45).annualLeaveDays(22).build();
        final var calculatorWithCustomVacancy = new Calculator(vacancy);
        final int expectedSalary = BASIC_SALARY + 6000;
        // when
        final var salary = calculatorWithCustomVacancy.calculateSalary();

        // then
        assertThat(salary).isGreaterThanOrEqualTo(expectedSalary);

        // debug
        System.out.println("AnnualLeaveIsLowerThan25: " + salary);
    }

    @Test
    public void salaryShouldIncreaseIfTravelTimeIsLongerThanMaximum() {
        // given
        final Vacancy vacancy = Vacancy.getTypicalVacancy();
        vacancy.setTimeTravel(50);
        final var calculatorWithCustomVacancy = new Calculator(vacancy);
        final int expectedSalary = 56250;
        // when
        final var salary = calculatorWithCustomVacancy.calculateSalary();

        // then
        assertThat(salary).isGreaterThanOrEqualTo(expectedSalary);

        // debug
        System.out.println("Long travel: " + salary);
    }

    @Test
    public void salaryShouldIncreaseIfHasLongerHour() {
        // given
        Vacancy vacancy = Vacancy.getTypicalVacancy();
        vacancy.setHours(40);
        final var calculatorWithCustomVacancy = new Calculator(vacancy);
        final int expectedSalary = 75000;

        // when
        final var salary = calculatorWithCustomVacancy.calculateSalary();

        // then
        assertThat(salary).isGreaterThanOrEqualTo(expectedSalary);

        // debug
        System.out.println("Long work hours: " + salary);
    }

    @Test
    public void shouldGetBasicSalary() throws Exception {

        // when
        final int result = calculator.getBasicSalary();

        // debug
        System.out.println(result);

        // then
        assertThat(result).isGreaterThanOrEqualTo(50000);
    }

    @Test
    public void shouldZoneOneAddonAcceptanceTest() {

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

    @Test
    public void shouldDecreaseSalaryIfYouCanBuyDayOffs() {
        // given
        final Vacancy vacancy = Vacancy.getTypicalVacancy();
        vacancy.inZoneOne();
        vacancy.onHatedStation();
        vacancy.setOptionToBuyExtraDays(10);
        final var calculatorWithCustomVacancy = new Calculator(vacancy);
        final int expectedSalary = BASIC_SALARY + BASIC_SALARY / 10;
        // when
        final var salary = calculatorWithCustomVacancy.calculateSalary();

        // then
        assertThat(salary).isGreaterThanOrEqualTo(expectedSalary);

        // debug
        System.out.println("Ability to buy extra days: " + salary);
    }
}