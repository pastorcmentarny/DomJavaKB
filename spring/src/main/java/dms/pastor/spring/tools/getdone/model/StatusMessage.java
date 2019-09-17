package dms.pastor.spring.tools.getdone.model;

import lombok.Data;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@Data
public class StatusMessage {

    private final String status;
    private final String message;
    private String advice;

    public StatusMessage(String status, String message) {
        this.status = status;
        this.message = message;
        advice = "So far,so good!";
    }

    public StatusMessage(String status, String message, String advice) {
        this.status = status;
        this.message = message;
        this.advice = advice;
    }

}
