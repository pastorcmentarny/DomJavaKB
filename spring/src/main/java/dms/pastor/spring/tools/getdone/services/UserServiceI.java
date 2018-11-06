package dms.pastor.spring.tools.getdone.services;

import dms.pastor.spring.tools.getdone.model.User;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public interface UserServiceI {

    boolean isExist(int userId);

    boolean createUser(User user);

    boolean updateUser(User user);

    boolean getUser(int userId);

    boolean deleteUser(int userId);

}
