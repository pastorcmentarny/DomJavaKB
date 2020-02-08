package dms.pastor.tools.salarycalc;

import dms.pastor.utils.DateUtils;

import java.time.LocalDate;
import java.time.Month;

import static dms.pastor.tools.salarycalc.SalaryConfig.HALF_HOUR_LESS_BONUS;
import static dms.pastor.tools.salarycalc.SalaryConfig.HALF_HOUR_MORE_BONUS;
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
    public static final int MINIMUM_SALARY = 55000;  // industry is 55000 in 2018

    private Vacancy data;

    public Calculator() {
        this.data = Vacancy.getTypicalVacancy();
    }

    public Calculator(Vacancy data) {
        this.data = data;
    }


    // without any pattern
    public int calculateSalary() {
        int salary = SalaryConfig.BASIC_SALARY;
        int adjustment = 0;
        if (data.isInZone1()) {
            adjustment += SalaryConfig.ZONE1_PENALTY;
            if (data.isHatedStation())
                adjustment += SalaryConfig.CRAP_STATION_PENALTY;
        }
        adjustment += getHolidayAdjustment(data.getAnnualLeaveDays());
        adjustment += getTravelTimeSalaryAdjustment(data.getTimeTravel());
        adjustment += workHoursAdjustment(data.getHours());

        salary += adjustment;
        return Math.max(salary, MINIMUM_SALARY);
    }

/*
      Zone 1 + 3200

      WFH -2500

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
            return (minimumHolidayAllowance - annualLeave) * (2000 + 10 * agingBonus());
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

    private int workHoursAdjustment(double hours) {
        final double typicalHours = 37.5;
        if (hours == typicalHours) {
            return 0;
        }
        if (hours > typicalHours) {
            return toIntFromDouble((hours - typicalHours) * HALF_HOUR_MORE_BONUS);
        }
        return toIntFromDouble((typicalHours - hours) * HALF_HOUR_LESS_BONUS);
    }
}
