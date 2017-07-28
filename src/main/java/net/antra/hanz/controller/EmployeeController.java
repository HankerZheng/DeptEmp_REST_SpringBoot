package net.antra.hanz.controller;

import net.antra.hanz.pojo.Department;
import net.antra.hanz.pojo.Employee;
import net.antra.hanz.service.DepartmentService;
import net.antra.hanz.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by hanzheng on 7/27/17.
 */

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(path="/employees", method=RequestMethod.GET)
    public List<Employee> getAllEmployees(){
        return employeeService.findAllEmployees();
    }

    @RequestMapping(path="/employees/id/{id}", method=RequestMethod.GET)
    public Employee getEmployeeById(@PathVariable Integer id) {
        return employeeService.findEmployeeById(id);
    }

    @RequestMapping(path="/employees/name/{name}", method=RequestMethod.GET)
    public List<Employee> getEmployeesByName(@PathVariable String name) {
        return employeeService.findEmployeeByName(name);
    }

    @RequestMapping(path="/employees", method=RequestMethod.POST)
    public Employee addEmployee(Employee employee, @RequestParam Integer deptId) {
        employeeService.saveEmployee(employee, deptId);
        return employee;
    }

    @ExceptionHandler(RuntimeException.class)
    public String employeeException(Exception e) {
        return e.getMessage();
    }
}
