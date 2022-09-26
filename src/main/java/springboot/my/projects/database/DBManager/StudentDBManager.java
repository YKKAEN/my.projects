package springboot.my.projects.database.DBManager;

import springboot.my.projects.database.constructors.Student;

import java.util.ArrayList;

public class StudentDBManager {

    private static ArrayList<Student> studentList = new ArrayList<>();

    private static Long id = 1L;

    public static ArrayList<Student> getStudent()
    {
        return studentList;
    }

    public static void addStudent(Student student) {
        student.setId(id);
        studentList.add(student);
        id++;
    }
}