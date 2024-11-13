package dms.pastor.spring.tools.getdone.services;

import dms.pastor.spring.tools.getdone.commons.State;
import dms.pastor.spring.tools.getdone.controllers.ErrorController;
import dms.pastor.spring.tools.getdone.model.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Author Dominik Symonowicz
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@Component
public class TaskServiceDummy implements TaskServiceI {
    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorController.class);
    private final ArrayList<Task> tasks = new ArrayList<>();

    @Override
    public Task createTask(int userId) {
        Task task = new Task(userId);
        tasks.add(task);
        return task;
    }

    @Override
    public boolean deleteTask(int userId, long id) {
        for (Task task : tasks) {
            if (id == task.getId()) {
                if (userId == task.getUserId()) {
                    tasks.remove(task);
                    return true;
                }  //error
                //TODO security log

            }
        }
        return false;
    }

    @Override
    public Task getTask(int userId, int taskId) {
        for (Task task : tasks) {
            if (taskId == task.getId()) {
                if (userId == task.getUserId()) {
                    return task;
                }  //error
                //TODO security log

            }
        }
        return null;
    }

    @Override
    public ArrayList<Task> getAllTaskForUser() {
        return tasks;
    }

    @Override
    public boolean save(Task taskToSave) {
        for (Task task : tasks) {
            if (task.getId() == task.getId()) {
                task = taskToSave;
                task.setState(State.BACKLOG.name());
                LOGGER.debug("task " + taskToSave.getId() + " updated.");
                return true;
            }
        }
        tasks.add(taskToSave);
        LOGGER.debug("task " + taskToSave.getId() + " saved..");
        return true;
    }

}
