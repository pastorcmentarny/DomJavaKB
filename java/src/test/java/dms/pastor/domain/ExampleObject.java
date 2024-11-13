package dms.pastor.domain;

/**
 * Author Dominik Symonowicz
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
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