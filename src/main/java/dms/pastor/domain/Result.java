package dms.pastor.domain;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static dms.pastor.utils.StringUtils.getUnknownWhenNullString;

/**
 * Author Dominik Symonowicz
 * Created 2012-06-12 at 16:41
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class Result {

    private boolean success;
    private String message;
    private Object item;

    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public Result(boolean success, String message, Object item) {
        this.success = success;
        this.message = message;
        this.item = item;
    }

    public static Result success(String message) {
        return new Result(true, message);
    }

    public static Result success(String message, Object item) {
        return new Result(true, message, item);
    }

    public static Result success() {
        return new Result(true, "Success");
    }

    public static Result fail(String message) {
        return new Result(false, message);
    }

    public static Result fail() {
        return new Result(false, "Fail");
    }

    public boolean isSuccess() {
        return success;
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

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getItem() {
        return item;
    }

    public void setItem(Object item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Result{" +
                "\n\tsuccess: " + success +
                "\n\tmessage: \'" + message + '\'' +
                (item != null ? "\n\thasItem: " + item.toString() : EMPTY_STRING) +
                "\n}";
    }

}
