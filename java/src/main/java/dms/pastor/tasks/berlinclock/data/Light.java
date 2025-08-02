package dms.pastor.tasks.berlinclock.data;

/**
 * Author Dominik Symonowicz
 * Created 2013-07-24
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
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
