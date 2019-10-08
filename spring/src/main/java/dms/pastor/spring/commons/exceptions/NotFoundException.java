package dms.pastor.spring.commons.exceptions;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class NotFoundException extends Exception {

    private String what;
    private long id;

    public NotFoundException(String what, long id) {
        this.what = what;
        this.id = id;
    }

    public String getWhat() {
        return what;
    }

    public long getId() {
        return id;
    }


}
