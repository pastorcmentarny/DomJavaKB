package dms.pastor.domain;

/**
 * User: Pastor Cmentarny
 * Created: 24.06.12 , 16:41
 * Last update  2013-06-21
 */
public class Result {
    private boolean success;
    private String message;
    private Object item;

    public Result(boolean success) {
        this.success = success;
        if (success) {
            message = "Success";
        } else {
            message = "Fail";
        }
    }

    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public Result(boolean success, String message, Object item) {
        this.success = success;
        this.message = message;
        this.item = item;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isFail() {
        return !success;
    }

    public String getMessage() {
        if (message != null) {
            return message;
        } else {
            return "Unknown";
        }
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
                "\n\tmessage: " + message + '\'' +
                "\n\thasItem: " + (item != null ? item.toString() : "null") +
                "\n}";
    }
}
