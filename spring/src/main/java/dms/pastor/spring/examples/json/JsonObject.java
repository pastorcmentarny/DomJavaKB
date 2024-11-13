package dms.pastor.spring.examples.json;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Author Dominik Symonowicz
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@Setter
@Getter
@EqualsAndHashCode
@ToString
public class JsonObject {

    private String name;
    private int version;
    private boolean ok;
    @JsonIgnore
    private String ignoredField;

    public JsonObject() {
    }

    public JsonObject(String name, int version, boolean ok) {
        this.name = name;
        this.version = version;
        this.ok = ok;
    }

}
