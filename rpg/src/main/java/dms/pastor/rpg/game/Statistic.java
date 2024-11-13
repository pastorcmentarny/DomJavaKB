package dms.pastor.rpg.game;

/**
 * Author Dominik Symonowicz
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
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
