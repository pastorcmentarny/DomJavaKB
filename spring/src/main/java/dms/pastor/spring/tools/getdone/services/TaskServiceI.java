package dms.pastor.spring.tools.getdone.services;

import dms.pastor.spring.tools.getdone.commons.NotFoundException;
import dms.pastor.spring.tools.getdone.model.Task;

import java.util.ArrayList;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public interface TaskServiceI {

    Task createTask(int userId);

    Task editTask(int userId, long id) throws NotFoundException;

    boolean deleteTask(int userId, long id);

    Task getTask(int userId, int taskId);

    ArrayList<Task> getAllTaskForUser(int userId);

    boolean save(Task task);

    boolean updateState(int taskId, String state);
}
