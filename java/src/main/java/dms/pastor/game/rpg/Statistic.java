package dms.pastor.game.rpg;

/**
 * @author Pastor
 * Created Jan 10, 2015 at 7:43:17 PM
 */
public class Statistic {
    private static Statistic statistic;

    /**
     * @return return instance of Player
     */
    public static synchronized Statistic getStatistic() {

        if (statistic == null) {
            statistic = new Statistic();
        }
        return statistic;
    }

    @Override
    public final Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
