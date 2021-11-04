package dms.pastor.spring.domain.error;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

/**
 * Author Dominik Symonowicz
 * Created 24/12/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * <p>
 * tag-error
 */
@EqualsAndHashCode(callSuper = true)
@Getter
public class ValidationErrorResponse extends ErrorResponse {
    private final List<Field> fields;

    public ValidationErrorResponse(long id, String errorMessage, String caused, String solution, String moreInfo, List<Field> fields) {
        super(id, errorMessage, caused, solution, moreInfo);
        this.fields = fields;
    }


}
