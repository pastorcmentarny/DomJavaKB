package dms.pastor.spring.tools.getdone.model;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class StatusMessage {

    private String status;
    private String message;
    private String advice = "";
    private static String DEFAULT_ADVICE = "So far,so good!";

    public StatusMessage(String status, String message) {
        this.status = status;
        this.message = message;
        advice = DEFAULT_ADVICE;
    }

    public StatusMessage(String status, String message, String advice) {
        this.status = status;
        this.message = message;
        this.advice = advice;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getAdvice() {
        return advice;
    }

}
