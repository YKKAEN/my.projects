package springboot.my.projects.services;

import springboot.my.projects.entities.Courses;
import springboot.my.projects.entities.Operators;
import springboot.my.projects.entities.Requests;

import java.util.List;

public interface RequestService {

    Requests addRequest(Requests request);

    List<Requests> getAllRequests();

    Requests getRequest(Long id);

    void deleteRequest(Requests request);

    Requests saveRequest(Requests request);

    Courses addCourse(Courses course);
    List<Courses> getAllCourses();
    Courses getCourse(Long id);
    Courses saveCourse(Courses course);

    List<Operators> getAllOperators();
    Operators getOperator(long id);
    Operators saveOperator(Operators operator);
    Operators addOperator(Operators operator);
}
