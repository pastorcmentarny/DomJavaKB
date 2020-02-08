package dms.pastor.tools.salarycalc;

import lombok.*;

/**
 * Author Dominik Symonowicz
 * Created 06/08/2018
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Vacancy {
    private int salary = 60000;
    private boolean inZone1 = true;
    private boolean hatedStation = true;
    private int annualLeaveDays = 25;
    private int timeTravel = 45;
    private boolean wfh = false;
    private double hours = 37.5;
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
