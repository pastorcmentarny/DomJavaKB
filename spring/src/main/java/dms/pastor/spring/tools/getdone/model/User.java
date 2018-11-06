package dms.pastor.spring.tools.getdone.model;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class User {
    private int userId;
    private String username;
    private boolean admin;

    public User(int userId, String username) {
        this.userId = userId;
        this.username = username;
        this.admin = false;
    }

    public User(int userId, String username, boolean admin) {
        this.userId = userId;
        this.username = username;
        this.admin = admin;
    }


}
