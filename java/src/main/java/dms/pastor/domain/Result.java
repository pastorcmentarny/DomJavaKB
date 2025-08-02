package dms.pastor.domain;

import lombok.Getter;
import lombok.Setter;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static dms.pastor.utils.StringUtils.getUnknownWhenNullString;

/**
 * Author Dominik Symonowicz
 * Created 2012-06-12 at 16:41
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
public class Result<T> {

    @Getter
    private boolean success;
    @Setter
    private String message;
    @Setter
    @Getter
    private T item;

    public Result(boolean success) {
        this.success = success;
        this.message = success ? "Success" : "Fail";
    }

    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public Result(boolean success, String message, T item) {
        this.success = success;
        this.message = message;
        this.item = item;
    }


    public void setSuccess() {
        this.success = true;
    }

    public boolean isFail() {
        return !success;
    }

    public String getMessage() {
        return getUnknownWhenNullString(message);
    }

    @Override
    public String toString() {
        return "Result{" +
                "\n\tsuccess: " + success +
                "\n\tmessage: '" + message + '\'' +
                (item != null ? "\n\thasItem: " + item : EMPTY_STRING) +
                "\n}";
    }

}
