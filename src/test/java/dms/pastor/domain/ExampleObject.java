package dms.pastor.domain;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class ExampleObject {

    private final Integer integer;
    private final Double aDouble;
    private final String string;

    public ExampleObject() {
        this.integer = 10;
        this.aDouble = 20.16;
        this.string = "Text";
    }

    public Integer getInteger() {
        return integer;
    }

    public String getString() {
        return string;
    }

    public Double getADouble() {
        return aDouble;
    }

}