package dms.pastor.tools.salarycalc;

import dms.pastor.utils.DateUtils;

import java.time.LocalDate;
import java.time.Month;

import static dms.pastor.utils.NumberUtils.toIntFromDouble;

/**
 * Author Dominik Symonowicz
 * Created 05/08/2018
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
class Calculator {

    private Vacancy data;

    public Calculator() {
        this.data = Vacancy.getIdealVacancySalary();
    }

    public Calculator(Vacancy data) {
        this.data = data;
    }


    public int calculateSalary() {
        int salary = SalaryConfig.BASIC_SALARY;
        return salary;
    }

/*
      Zone 1 + 3200

      WFH -2500

      25 Days 0  For 1 Day less +2000, For 1 Day more -750
      For ability to buy day -500 per day


      Oxford, Victoria, Piccadilly + 1000
      37.5hr is 0  ±1200 per 0.5h
     */

    public int getBasicSalary() {
        return 20000 + (300 * agingBonus());
    }

    private int agingBonus() {
        return DateUtils.getMonthBetweenNowAnd(LocalDate.of(2010, Month.SEPTEMBER, 6));
    }

    // 45 minutes off-peak ±750 per minute
    public int getTravelTimeSalaryAdjustment(int travelTimeInMinutes) {
        final int maxAllowedTime = 45;
        if (travelTimeInMinutes <= maxAllowedTime) {
            return -250 * (maxAllowedTime - travelTimeInMinutes);
        } else {
            return (travelTimeInMinutes - maxAllowedTime) * 750;
        }
    }


    public int getHolidayAdjustment(int annualLeave) {
        final int minimumHolidayAllowance = 25;
        if (minimumHolidayAllowance == annualLeave) {
            return 0;
        }

        if (annualLeave < minimumHolidayAllowance) {
            return (minimumHolidayAllowance - annualLeave) * 2000;
        } else {
            return (annualLeave - minimumHolidayAllowance) * -750;
        }
    }

    public int zoneOneAddon() {
        return 1000 + 15 * agingBonus();
    }

    public int getSeniorPenalty() {
        return toIntFromDouble(Math.round(getBasicSalary() * 1.5));
    }
}
