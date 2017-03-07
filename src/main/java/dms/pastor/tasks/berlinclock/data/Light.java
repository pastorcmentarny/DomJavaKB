package dms.pastor.tasks.berlinclock.data;

/**
 * Author Dominik Symonowicz
 * Created 2013-07-24
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public enum Light {

    RED("R"),
    YELLOW("Y"),
    OFF("0");
    private final String colour;

    Light(String colour) {
        this.colour = colour;
    }

    public String getColor() {
        return colour;
    }
}
