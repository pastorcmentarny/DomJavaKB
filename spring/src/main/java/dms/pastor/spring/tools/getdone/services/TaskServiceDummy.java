package dms.pastor.spring.tools.getdone.services;

import dms.pastor.spring.tools.getdone.commons.NotFoundException;
import dms.pastor.spring.tools.getdone.commons.State;
import dms.pastor.spring.tools.getdone.controllers.ErrorController;
import dms.pastor.spring.tools.getdone.model.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@Component
public class TaskServiceDummy implements TaskServiceI {
    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorController.class);
    private ArrayList<Task> tasks = new ArrayList<>();

    @Override
    public Task createTask(int userId) {
        Task task = new Task(userId);
        tasks.add(task);
        return task;
    }

    @Override
    public Task editTask(int userId, long id) throws NotFoundException {
        for (Task task : tasks) {
            if (Long.compare(id, task.getId()) == 0) {
                if (userId == task.getUserId()) {
                    return task;
                } else {
                    //error
                    //TODO security log
                }
            }
        }
        throw new NotFoundException("task", id);
    }

    @Override
    public boolean deleteTask(int userId, long id) {
        for (Task task : tasks) {
            if (Long.compare(id, task.getId()) == 0) {
                if (userId == task.getUserId()) {
                    tasks.remove(task);
                    return true;
                } else {
                    //error
                    //TODO security log
                }
            }
        }
        return false;
    }

    @Override
    public Task getTask(int userId, int taskId) {
        for (Task task : tasks) {
            if (Long.compare(taskId, task.getId()) == 0) {
                if (userId == task.getUserId()) {
                    return task;
                } else {
                    //error
                    //TODO security log
                }
            }
        }
        return null;
    }

    @Override
    public ArrayList<Task> getAllTaskForUser(int userId) {
        return tasks;
    }

    @Override
    public boolean save(Task taskToSave) {
        for (Task task : tasks) {
            if (Long.compare(task.getId(), task.getId()) == 0) {
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

    @Override
    public boolean updateState(int taskId, String state) {
        // TODO Auto-generated method stub
        return false;
    }

}
