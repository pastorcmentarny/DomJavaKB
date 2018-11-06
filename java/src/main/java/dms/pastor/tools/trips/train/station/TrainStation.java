package dms.pastor.tools.trips.train.station;

/**
 * Author Dominik Symonowicz
 * Created 23/05/2018
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class TrainStation {//} implements Station {
    private final String name;

    public TrainStation(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
