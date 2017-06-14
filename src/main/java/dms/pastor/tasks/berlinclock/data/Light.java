package dms.pastor.tasks.berlinclock.data;

/**
 * Author Dominik Symonowicz
 * Created 2013-07-24
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
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
