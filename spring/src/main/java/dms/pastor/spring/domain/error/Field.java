package dms.pastor.spring.domain.error;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Author Dominik Symonowicz
 * Created 30/12/2017
 * WWW:	https://dominiksymonowicz.com/
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
@ToString
@EqualsAndHashCode
@Getter
class Field {
    private final String name;
    private final String message;

    public Field(String name, String message) {
        this.name = name;
        this.message = message;
    }

}
