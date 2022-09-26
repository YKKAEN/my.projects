package springboot.my.projects.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.my.projects.entities.Courses;
import springboot.my.projects.entities.Operators;
import springboot.my.projects.entities.Requests;
import springboot.my.projects.repositories.CourseRepository;
import springboot.my.projects.repositories.OperatorRepository;
import springboot.my.projects.repositories.RequestRepository;
import springboot.my.projects.services.RequestService;

import java.util.List;

@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    OperatorRepository operatorRepository;

    @Override
    public Requests addRequest(Requests request) {
        return requestRepository.save(request);
    }

    @Override
    public List<Requests> getAllRequests() {
        return requestRepository.findAll();
    }

    @Override
    public Requests getRequest(Long id) {
        return requestRepository.getById(id);
    }

    @Override
    public void deleteRequest(Requests request) {
        requestRepository.delete(request);
    }

    @Override
    public Requests saveRequest(Requests request) {
        return requestRepository.save(request);
    }

    @Override
    public Courses addCourse(Courses course) {
        return courseRepository.save(course);
    }

    @Override
    public List<Courses> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Courses getCourse(Long id) {
        return courseRepository.getById(id);
    }

    @Override
    public Courses saveCourse(Courses course) {
        return courseRepository.save(course);
    }

    @Override
    public List<Operators> getAllOperators() {
        return operatorRepository.findAll();
    }

    @Override
    public Operators getOperator(long id) {
        return operatorRepository.getById(id);
    }

    @Override
    public Operators saveOperator(Operators operator) {
        return operatorRepository.save(operator);
    }

    @Override
    public Operators addOperator(Operators operator) {
        return operatorRepository.save(operator);
    }

}
