package dms.pastor.spring.tools.getdone.commons;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class NotFoundException extends Exception {

    String what;
    long id;

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
