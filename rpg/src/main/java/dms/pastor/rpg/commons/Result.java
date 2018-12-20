package dms.pastor.rpg.commons;

/**
 * Author: Pastor
 * Date: 24.06.12
 * Time: 16:41
 */
public class Result {

    private boolean success;
    private String message = "";
    private Object data = null;

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

    public Result(boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public static Result notImplementedYet() {
        return new Result(false, "not implemented yet");
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }

    public void setFail(String msg) {
        if (success) {
            success = false;
            this.message = msg;
        } else {
            this.message += message + ".\n";
        }

    }

}
