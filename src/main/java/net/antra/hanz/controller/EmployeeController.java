package net.antra.hanz.controller;

import net.antra.hanz.exception.controller.EmployeeNotFoundException;
import net.antra.hanz.exception.ErrorTestException;
import net.antra.hanz.pojo.Employee;
import net.antra.hanz.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        Employee e = employeeService.findEmployeeById(id);
        if(e == null) {
            throw new EmployeeNotFoundException("employee ID(" + id + ") is not found in the database!!");
        }
        return e;
    }

//    @GetMapping(path="/employee/name/{name}")
    @RequestMapping(path="/employee/name/{name}", method=RequestMethod.GET)
    public List<Employee> getEmployeesByName(@PathVariable String name) {
        List<Employee> eList = employeeService.findEmployeeByName(name);
        if (eList.size() == 0) {
            throw new EmployeeNotFoundException("employee name(" + name + ") is not found in the database!!");
        }
        return eList;
    }

    @RequestMapping(path="/employee", method=RequestMethod.POST)
    public Employee addEmployee(Employee employee, @RequestParam Integer deptId) {
        employeeService.saveEmployee(employee, deptId);
        return employee;
    }

    @RequestMapping(path="/employee/id/{id}", method=RequestMethod.DELETE)
    public Employee deleteEmployeeById(@PathVariable Integer id) {
        Employee e = employeeService.deleteEmployeeById(id);
        if(e == null) {
            throw new EmployeeNotFoundException("employee name(" + id + ") is not found in the database!! Delete operation cannot be performed!");
        }
        return e;
    }

    @RequestMapping(path="/error", method=RequestMethod.GET)
    public String showErrorMsg() {
        throw new ErrorTestException("this is a error message example!");
    }


    @ResponseStatus(code=HttpStatus.NOT_FOUND)
    @ExceptionHandler(EmployeeNotFoundException.class)
    public String employeeException(Exception e) {
        return e.getMessage();
    }
}
