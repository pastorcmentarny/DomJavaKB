package dms.pastor.tools.job.salarycalc;

import lombok.*;
import lombok.Builder.Default;

/**
 * Author Dominik Symonowicz
 * Created 06/08/2018
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Vacancy {
    @Default
    private int salary = 60000;
    @Default
    private boolean inZone1 = true;
    @Default
    private boolean hatedStation = true;
    @Default
    private int annualLeaveDays = 25;
    @Default
    private int timeTravel = 45;
    @Default
    private boolean wfh = false;
    @Default
    private double hours = 37.5;
    @Default
    private int optionToBuyExtraDays = 0;


    public static Vacancy getTypicalVacancy() {
        return new Vacancy(60000, true, true, 25, 45, false, 37.5, 0);
    }

    public static Vacancy getIdealVacancy() {
        return new Vacancy(65000, false, false, 27, 21, true, 35d, 10);
    }

    public void inZoneOne() {
        inZone1 = true;
    }

    public void onHatedStation() {
        hatedStation = true;
    }
}
