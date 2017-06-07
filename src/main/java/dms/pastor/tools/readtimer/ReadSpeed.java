package dms.pastor.tools.readtimer;

/**
 * Author Dominik Symonowicz
 * Created 20/04/2016
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public enum ReadSpeed {
    ADULT_SLOW(130),
    ADULT_AVERAGE(250);

    private final int speed;

    ReadSpeed(int speed) {
        this.speed = speed;
    }

    public int speed() {
        return speed;
    }

    public static String getSpeedAsStringFor(ReadSpeed readSpeed) {
        if(readSpeed == null){
            return String.valueOf(ADULT_AVERAGE.speed());
        }
        return String.valueOf(readSpeed.speed());
    }
}
