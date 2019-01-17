package dms.pastor.rpg.commons;


/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * //TODO reuse from Utils in Java
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
