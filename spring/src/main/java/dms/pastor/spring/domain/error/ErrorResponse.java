package dms.pastor.spring.domain.error;

import java.util.Objects;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * <p>
 * tag-error
 */
class ErrorResponse {
    private final long id;
    private final String errorMessage;
    private final String caused;
    private final String solution;
    private final String moreInfo;

    public ErrorResponse(long id, String errorMessage, String caused, String solution, String moreInfo) {
        this.id = id;
        this.errorMessage = errorMessage;
        this.caused = caused;
        this.solution = solution;
        this.moreInfo = moreInfo;
    }

    private long getId() {
        return id;
    }

    private String getErrorMessage() {
        return errorMessage;
    }

    private String getCaused() {
        return caused;
    }

    private String getSolution() {
        return solution;
    }

    private String getMoreInfo() {
        return moreInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ErrorResponse)) return false;
        ErrorResponse that = (ErrorResponse) o;
        return getId() == that.getId() &&
                Objects.equals(getErrorMessage(), that.getErrorMessage()) &&
                Objects.equals(getCaused(), that.getCaused()) &&
                Objects.equals(getSolution(), that.getSolution()) &&
                Objects.equals(getMoreInfo(), that.getMoreInfo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getErrorMessage(), getCaused(), getSolution(), getMoreInfo());
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