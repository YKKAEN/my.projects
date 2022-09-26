package springboot.my.projects.contoller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springboot.my.projects.entities.Task;
import springboot.my.projects.repositories.TaskRepository;

import java.util.List;

@Controller
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskRepository taskRepository;

    @GetMapping(value = "/alltasks")
    public String getAllTasks(Model model) {
        List<Task> tasks = taskRepository.findAll();
        model.addAttribute("taskList", tasks);
        return "allTasks";
    }

    @PostMapping(value = "/addnewtask")
    public String addTask(@RequestParam(name = "taskName") String taskName,
                          @RequestParam(name = "taskDescription") String taskDescription,
                          @RequestParam(name = "taskDeadlineDate") String taskDeadlineDate) {
        Task task = new Task();
        task.setTaskName(taskName);
        task.setTaskDecription(taskDescription);
        task.setTaskDeadlineDate(taskDeadlineDate);
        taskRepository.save(task);
        return "redirect:/task/alltasks";
    }

    @GetMapping(value = "/edittask/{id}")
    public String getEditTaskForm(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("editTask", taskRepository.findById(id).orElseThrow());
        return "editTask";
    }

    @PostMapping(value = "/edittask/{id}")
    public String editTask(@ModelAttribute(name = "editTask") Task editTask, @PathVariable(name = "id") Long id) {
        editTask.setId(id);
        taskRepository.save(editTask);
        return "redirect:/task/alltasks";
}
    @GetMapping(value = "/deletetask/{id}")
    public String deleteTask(@PathVariable(name = "id") Long id) {
        taskRepository.deleteById(id);
        return "redirect:/task/alltasks";
    }
}