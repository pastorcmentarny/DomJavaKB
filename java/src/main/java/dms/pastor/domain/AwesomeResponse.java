package dms.pastor.domain;

/**
 * Author Dominik Symonowicz
 * Created 09/09/2016
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class AwesomeResponse {

    private final boolean success;

    public AwesomeResponse() {
        this.success = true;
    }

    public boolean isSuccess() {
        return success;
    }
}