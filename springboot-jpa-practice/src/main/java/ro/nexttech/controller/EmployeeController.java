package ro.nexttech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ro.nexttech.data.EmployeeRepository;
import ro.nexttech.model.EmployeeModel;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeData;

    @RequestMapping(value = "/addEmployee.html", method = RequestMethod.POST)
    public String newEmployee(EmployeeModel employee) {

        employeeData.save(employee);
        return ("redirect:/listEmployees.html");

    }

    @RequestMapping(value = "/addEmployee.html", method = RequestMethod.GET)
    public ModelAndView addNewEmployee() {

        EmployeeModel emp = new EmployeeModel();
        return new ModelAndView("newEmployee", "form", emp);

    }

    @RequestMapping(value = "/listEmployees.html", method = RequestMethod.GET)
    public ModelAndView employees() {
        List<EmployeeModel> allEmployees = employeeData.findAll();
        return new ModelAndView("allEmployees", "employees", allEmployees);

    }

}
