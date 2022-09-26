package springboot.my.projects.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.my.projects.entities.Task;
import springboot.my.projects.repositories.TaskRepository;
import springboot.my.projects.services.TaskService;

import java.util.List;
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Override
    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTask(Long id) {
        return taskRepository.getById(id);
    }

    @Override
    public void deleteTask(Task task) {
    taskRepository.delete(task);
    }

    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }
}
