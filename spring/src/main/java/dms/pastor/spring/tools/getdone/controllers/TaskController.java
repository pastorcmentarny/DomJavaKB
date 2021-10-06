package dms.pastor.spring.tools.getdone.controllers;

import dms.pastor.spring.tools.getdone.commons.Status;
import dms.pastor.spring.tools.getdone.model.StatusMessage;
import dms.pastor.spring.tools.getdone.model.Task;
import dms.pastor.spring.tools.getdone.services.TaskServiceI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@RestController
@RequestMapping("/task")
public class TaskController {
    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);


    private final TaskServiceI taskService;

    @Autowired
    public TaskController(TaskServiceI taskService) {
        this.taskService = taskService;
    }


    @RequestMapping(value = "/create", method = RequestMethod.PUT)
    public StatusMessage createTask(@RequestParam(value = "userId") int userId) {
        Task task = taskService.createTask(userId);
        return new StatusMessage(Status.OK.name(), "Task " + task.getId() + " was created.");
    }

    @RequestMapping(value = "/draft", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
    public StatusMessage draft(@RequestParam(value = "userId") int userId) {
        Task task = new Task(userId);
        logger.debug("Task:" + task.getId());
        return new StatusMessage(Status.OK.name(), "Created");
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public StatusMessage taskTest(@RequestParam(value = "userId") int userId, @RequestBody Task task) {
        if (taskService.save(task)) {
            return new StatusMessage(Status.OK.name(), "OK", "So far,so good.");
        } else {
            return new StatusMessage(Status.ERROR.name(), "Unable to update task.", "Do you have permission?");
        }

    }

    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = "application/json")
    public Task getTask(@RequestParam(value = "userId") int userId, @RequestParam(value = "taskId") int taskId) {
        Task task = taskService.getTask(userId, taskId);

        logger.debug("Task:" + task.getId());
        return task;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = "application/json")
    public StatusMessage deleteTask(@RequestParam(value = "userId") int userId, @RequestParam(value = "taskId") int taskId) {
        if (taskService.deleteTask(userId, taskId)) {
            return new StatusMessage(Status.OK.name(), "Task no: + " + taskId + " was  deleted");
        } else {
            logger.debug("Unable to delete task:" + taskId + " for user : " + userId);
            return new StatusMessage(Status.ERROR.name(), "Task no: + " + taskId + " was  deleted");
        }
    }


    @RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = "application/json")
    public ArrayList<Task> getAllTask(@RequestParam(value = "userId") int userId) {
        return taskService.getAllTaskForUser();
    }

}
