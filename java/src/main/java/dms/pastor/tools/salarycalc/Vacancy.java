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
    private boolean inZone1 = false;
    private boolean hatedStation = false;
    private int annualLeaveDays = 27;
    private int timeTravel = 21;
    private boolean wfh = true;
    private double hours = 35;


    public static Vacancy getIdealVacancySalary() {
        return new Vacancy();
    }
}
