package dms.pastor.tools.salarycalc;

/**
 * Author Dominik Symonowicz
 * Created 05/08/2018
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class SalaryConfig {
    public static final int BASIC_SALARY = 45000; // industry is 55000
    public static final int ZONE1_PENALTY = tenPercent();
    public static final int CRAP_STATION_PENALTY = tenPercent(); //Oxford, Victoria, Picadilly
    public static final int WFH_BONUS = discount(fivePercent());
    public static final int HALF_HOUR_LESS_BONUS = discount(fivePercent());
    public static final int HALF_HOUR_MORE_BONUS = discount(tenPercent());

    private static int twoPercent() {
        return BASIC_SALARY / 50;
    }

    private static int threePercent() {
        return BASIC_SALARY / 50;
    }

    private static int fivePercent() {
        return BASIC_SALARY / 20;
    }

    private static int tenPercent() {
        return BASIC_SALARY / 10;
    }

    private static int discount(int value) {
        return -1 * value;
    }
    /*                 *
     * Zone 1 + 3200
     *
     * WFH -2500
     *
     * 25 Days 0  For 1 Day less +2000, For 1 Day more -750
     * For ability to buy day -500 per day
     *
     * 45 minutes off-peak ±750 per minute
     *
     *  + 1000
     * 37.5hr is 0  ±1200 per 0.5h*/
}
