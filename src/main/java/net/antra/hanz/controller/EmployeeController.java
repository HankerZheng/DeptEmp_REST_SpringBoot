package net.antra.hanz.controller;

import net.antra.hanz.pojo.Employee;
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

    @RequestMapping(path="/employee", method=RequestMethod.GET)
    public List<Employee> getAllEmployees(){
        return employeeService.findAllEmployees();
    }

    @RequestMapping(path="/employee/id/{id}", method=RequestMethod.GET)
    public Employee getEmployeeById(@PathVariable Integer id) {
        return employeeService.findEmployeeById(id);
    }

//    @GetMapping(path="/employee/name/{name}")
    @RequestMapping(path="/employee/name/{name}", method=RequestMethod.GET)
    public List<Employee> getEmployeesByName(@PathVariable String name) {
        return employeeService.findEmployeeByName(name);
    }

    @RequestMapping(path="/employee", method=RequestMethod.POST)
    public Employee addEmployee(Employee employee, @RequestParam Integer deptId) {
        employeeService.saveEmployee(employee, deptId);
        return employee;
    }

    @RequestMapping(path="/employee/id/{id}", method=RequestMethod.DELETE)
    public Employee deleteEmployeeById(@PathVariable Integer id) {
        return employeeService.deleteEmployeeById(id);
    }

    @ExceptionHandler(RuntimeException.class)
    public Exception employeeException(Exception e) {
        return e;
    }
}
