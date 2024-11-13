package dms.pastor.spring.domain.error;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Author Dominik Symonowicz
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * <p>
 * tag-error
 */
@Getter
@EqualsAndHashCode
public class ErrorResponse {
    private final long id;
    private final String errorMessage;
    private final String caused;
    private final String solution;
    private final String moreInfo;
    private final Long timestamp;

    public ErrorResponse(long id, String errorMessage, String caused, String solution, String moreInfo) {
        this.timestamp = System.currentTimeMillis();
        this.id = id;
        this.errorMessage = errorMessage;
        this.caused = caused;
        this.solution = solution;
        this.moreInfo = moreInfo;
    }


    @Override
    public String toString() {
        return "ErrorResponse{" +
                "id=" + id +
                ", errorMessage='" + errorMessage + '\'' +
                ", caused='" + caused + '\'' +
                ", solution='" + solution + '\'' +
                ", moreInfo='" + moreInfo + '\'' +
                '}';
    }
}
