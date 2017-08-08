package net.antra.hanz.controller;

import net.antra.hanz.exception.controller.EmployeeNotFoundException;
import net.antra.hanz.persistence.entity.Employee;
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

    // Find all employees
    @GetMapping(path="/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.findAllEmployees();
    }

    // Find employee with ID
    @GetMapping(path="/employees/{id}")
    public Employee getEmployeeById(@PathVariable Integer id) throws EmployeeNotFoundException{
        Employee e = employeeService.findEmployeeById(id);
        if(e == null) {
            throw new EmployeeNotFoundException("ID", id.toString());
        }
        return e;
    }

    // Create new employee
    @PostMapping(path="/employees")
    public Employee addEmployee(Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    // Update an existing employee
    @PutMapping(path="/employees/{id}")
    public Employee updateEmployee(Employee e, @PathVariable Integer id) throws EmployeeNotFoundException{
        Employee updated = employeeService.updateEmployee(e, id);
        if (updated == null) {
            throw new EmployeeNotFoundException("ID", id.toString());
        }
        return updated;
    }

    // Delete an existing employee
    @DeleteMapping(path="/employees/{id}")
    public Employee deleteEmployeeById(@PathVariable Integer id) throws EmployeeNotFoundException{
        Employee e = employeeService.deleteEmployeeById(id);
        if(e == null) {
            throw new EmployeeNotFoundException("ID", id.toString());
        }
        return e;
    }


    // Search Queries
    @GetMapping(path="/search/employees/name/{name}")
    public List<Employee> getEmployeesByName(@PathVariable String name) throws EmployeeNotFoundException{
        List<Employee> eList = employeeService.searchEmployeeByName(name);
        if (eList.size() == 0) {
            throw new EmployeeNotFoundException("Name", name);
        }
        return eList;
    }


    // Exception Handler for Employee
    @ResponseStatus(code=HttpStatus.NOT_FOUND)
    @ExceptionHandler(EmployeeNotFoundException.class)
    public String employeeException(Exception e) {
        return e.getMessage();
    }
}
