package dms.pastor.domain;

/**
 * Author Dominik Symonowicz
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
public class ExampleObject {

    private final Integer anInteger;
    private final Double aDouble;
    private final String aString;

    public ExampleObject() {
        this.anInteger = 10;
        this.aDouble = 20.16;
        this.aString = "Text";
    }

    public Integer getAnInteger() {
        return anInteger;
    }

    public String getString() {
        return aString;
    }

    public Double getADouble() {
        return aDouble;
    }

}