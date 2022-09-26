package springboot.my.projects.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springboot.my.projects.database.constructors.Student;
import springboot.my.projects.database.DBManager.StudentDBManager;

import java.util.ArrayList;

@Controller
@RequestMapping("/student")
public class StudentController {

    @GetMapping(value = "/studentlist")
    public String studentList (Model model) {
        ArrayList<Student> studentList = StudentDBManager.getStudent();
        for(Student student : studentList) {
            student.setMark(getMark(student.getExam()));
        }
        model.addAttribute("students", studentList);
        return "studentList";
    }

    @GetMapping(value = "/addstudent")
    public String addStudent(Model model) {
        model.addAttribute("addStudent", new Student());
        return "addStudent";
    }
    @PostMapping(value = "/addstudent")
    public String addStudent(@RequestParam(name = "studentName") String studentName,
                             @RequestParam(name = "studentSurname") String studentSurname,
                             @RequestParam(name = "studentExam") int studentExam) {
        StudentDBManager.addStudent(new Student(null, studentName, studentSurname, studentExam, null));
        return "redirect:/student/studentlist";
    }
    private String getMark(int exam) {
        if(exam >= 90) return "A"; 
        else if (exam >= 75 && exam <= 90) return "B";
        else if (exam >= 60 && exam <= 75) return "C";
        else if (exam >= 50 && exam < 60) return "D";
        else return "F";
    }
}