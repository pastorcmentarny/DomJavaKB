package dms.pastor.tools.salarycalc;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class VacancyTest {

    @Test
    public void getIdealVacancySalaryAcceptanceTest() {
        // given
        Vacancy expectedIdealVacancy = new Vacancy();

        // when
        final var idealVacancySalary = Vacancy.getTypicalVacancy();

        // then
        assertThat(idealVacancySalary).isEqualTo(expectedIdealVacancy);
    }
}