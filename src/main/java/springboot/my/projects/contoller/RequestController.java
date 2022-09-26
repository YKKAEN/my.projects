package springboot.my.projects.contoller;

import org.apache.catalina.mbeans.SparseUserDatabaseMBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springboot.my.projects.entities.Courses;
import springboot.my.projects.entities.Operators;
import springboot.my.projects.entities.Requests;
import springboot.my.projects.repositories.CourseRepository;
import springboot.my.projects.repositories.OperatorRepository;
import springboot.my.projects.repositories.RequestRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/request")
public class RequestController {

    @Autowired
    RequestRepository requestRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    OperatorRepository operatorRepository;

    @GetMapping(value = "/allrequests")
    public String getRequest(Model model) {
        List<Requests> requests = requestRepository.findAll();
        model.addAttribute("requestList", requests);
        return "allRequests";
    }

    @GetMapping(value = "/addrequest")
    public String getRequestForm(Model model) {
        List<Courses> courses = courseRepository.findAll();
        model.addAttribute("courseList", courses);
        List<Operators> operators = operatorRepository.findAll();
        model.addAttribute("operatorList", operators);
        model.addAttribute("newRequest", new Requests());
        return "addRequest";
    }

    @PostMapping(value = "/addrequest")
    public String addRequest(@ModelAttribute(name = "newRequest") Requests newRequest) {
        requestRepository.save(newRequest);
        return "redirect:/request/allrequests";
    }

    @GetMapping(value = "/handlerequest/{id}")
    public String getDetails(Model model, @PathVariable(name = "id") Long id) {
        Requests request = requestRepository.findById(id).orElse(null);
        model.addAttribute("editRequest", request);
        List<Courses> courses = courseRepository.findAll();
        model.addAttribute("courseList", courses);
        List<Operators> operators = operatorRepository.findAll();
        model.addAttribute("operatorList", operators);
        return "handleRequest";
    }

    @PostMapping(value = "/handlerequest/{id}")
    public String handleRequest(@PathVariable(name = "id") Long id) {
        Requests request = requestRepository.findById(id).orElse(null);
        request.setHandled(true);
        requestRepository.save(request);
        return "redirect:/request/allrequests/";
    }

    @PostMapping(value = "/deleterequest/{id}")
    public String deleteRequest(@PathVariable(name = "id") Long id) {
        requestRepository.deleteById(id);
        return "redirect:/request/allrequests/";
    }

    @GetMapping(value = "/handle")
    public String handle(Model model) {
        List<Requests> requests = requestRepository.findByHandledIsTrue();
        model.addAttribute("handleUsers", requests);
        return "/handle";
    }

    @GetMapping(value = "/nothandle")
    public String notHandle(Model model) {
        List<Requests> requests = requestRepository.findByHandledFalse();
        model.addAttribute("nothandleUsers", requests);
        return "/nothandle";
    }

//    ----------------------

    @PostMapping(value = "/addoperator")
        public String addOperator(@RequestParam(name = "userId") Long userId,
                                  @RequestParam(name = "operatorId") Long operatorId) {
        Requests request = requestRepository.findById(userId).orElseThrow();
        Operators operator = operatorRepository.findById(operatorId).orElseThrow();

        List<Operators> operators = request.getOperators();
        if(operators==null) {
            operators = new ArrayList<>();
        }
        operators.add(operator);
        request.setOperators(operators);
        requestRepository.save(request);
        return "redirect:/request/handlerequest/" + userId;
    }
//    @PostMapping(value = "/deleteoperator")
//    public String deleteOperator(@RequestParam(name = "userId") Long userId,
//                                 @RequestParam(name = "operatorId") Long operatorId) {
//        Requests request = requestRepository.findById(userId).orElseThrow();
//        Operators operator = operatorRepository.findById(operatorId).orElseThrow();
//
//        List<Operators> operators = request.getOperators();
//        if(operators==null) {
//            operators = new ArrayList<>();
//        }
//        operators.remove(operator);
//        request.setOperators(operators);
//        requestRepository.save(request);
//        return "redirect:/request/handlerequest/" + userId;
//    }
}
