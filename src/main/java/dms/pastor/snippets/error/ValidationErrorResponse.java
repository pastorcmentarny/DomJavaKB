package dms.pastor.snippets.error;

import java.util.List;
import java.util.Objects;

/**
 * Author Dominik Symonowicz
 * Created 24/12/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * <p>
 * tag-error
 */
public class ValidationErrorResponse extends ErrorResponse {
    private final List<Field> fields;

    public ValidationErrorResponse(long id, String errorMessage, String caused, String solution, String moreInfo, List<Field> fields) {
        super(id, errorMessage, caused, solution, moreInfo);
        this.fields = fields;
    }

    private List<Field> getFields() {
        return fields;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ValidationErrorResponse)) return false;
        if (!super.equals(o)) return false;
        ValidationErrorResponse that = (ValidationErrorResponse) o;
        return Objects.equals(getFields(), that.getFields());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getFields());
    }

    @Override
    public String toString() {
        return "ValidationErrorResponse{" +
                "fields=" + fields +
                "} " + super.toString();
    }
}
