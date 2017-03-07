package dms.pastor.domain;

/**
 * Author Dominik Symonowicz
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
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