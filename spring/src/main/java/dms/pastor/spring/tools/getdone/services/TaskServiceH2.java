package dms.pastor.spring.tools.getdone.services;

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
public class TaskServiceH2 implements TaskServiceI {

    @Override
    public Task createTask(int userId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Task editTask(int userId, long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean deleteTask(int userId, long id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Task getTask(int userId, int taskId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<Task> getAllTaskForUser(int userId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean save(Task task) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean updateState(int taskId, String state) {
        // TODO Auto-generated method stub
        return false;
    }

}
