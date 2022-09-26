package springboot.my.projects.services;

import springboot.my.projects.entities.Task;

import java.util.List;

public interface TaskService {
    Task addTask(Task task);
    List<Task> getAllTasks();
    Task getTask(Long id);
    void deleteTask(Task task);
    Task saveTask(Task task);
}




