package dms.pastor.tools.job.salarycalc;

/**
 * Author Dominik Symonowicz
 * Created 05/08/2018
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
class SalaryConfig {
    public static final int BASIC_SALARY = 52500; // industry is 55000
    public static final int ZONE1_PENALTY = tenPercent();
    public static final int CRAP_STATION_PENALTY = tenPercent(); //Oxford, Victoria, Piccadilly
    public static final int HALF_HOUR_LESS_BONUS = discount(fivePercent());
    public static final int HALF_HOUR_MORE_BONUS = tenPercent();

    public static int twoPercent() {
        return BASIC_SALARY / 50;
    }

    public static int onePercent() {
        return BASIC_SALARY / 100;
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

}
