package dms.pastor.spring.tools.getdone.services;

import dms.pastor.spring.tools.getdone.model.Task;

import java.util.ArrayList;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public interface TaskServiceI {

    Task createTask(int userId);

    boolean deleteTask(int userId, long id);

    Task getTask(int userId, int taskId);

    ArrayList<Task> getAllTaskForUser();

    boolean save(Task task);

}
