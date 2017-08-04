package net.antra.hanz.controller;

import net.antra.hanz.exception.controller.DepartmentNotFoundException;
import net.antra.hanz.persistence.entity.Department;
import net.antra.hanz.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by hanzheng on 7/27/17.
 */

@RestController
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    // Find all departments
    @RequestMapping(path="/departments", method=RequestMethod.GET)
    public List<Department> getAllDepartments() {
        return departmentService.findAllDepartments();
    }

    // Find one department with ID
    @RequestMapping(path="/departments/{id}", method=RequestMethod.GET)
    public Department getDepartmentById(@PathVariable Integer id) throws DepartmentNotFoundException{
        Department d = departmentService.findDepartmentById(id);
        if (d == null) {
            throw new DepartmentNotFoundException("department ID(" + id + ")is not found in the database!!");
        }
        return d;
    }

    // Create new department
    @RequestMapping(path="/departments", method=RequestMethod.POST)
    public Department addDepartment(Department d) {
        return departmentService.saveDepartment(d);
    }

//    @RequestMapping(path="/departments/{id}", method=RequestMethod.PUT)
//    public Department updateDepartment(Department d){
//        departmentService.saveDepartment(d);
//    }


    @RequestMapping(path="/departments/{id}", method=RequestMethod.DELETE)
    public Department deleteDepartmentById(@PathVariable Integer id) throws DepartmentNotFoundException{
        Department d = departmentService.deleteDepartmentById(id);
        if (d == null) {
            throw new DepartmentNotFoundException("department ID(" + id + ") is not found in the database! Delete operation cannot be performed!");
        }
        d.setEmployees(null);
        return d;
    }

    @RequestMapping(path="/departments/name/{name}", method=RequestMethod.GET)
    public List<Department> getDepartmentsByName(@PathVariable String name) throws DepartmentNotFoundException{
        List<Department> res = departmentService.findDepartmentByName(name);
        if(res.size() == 0) {
            throw new DepartmentNotFoundException("department name(" + name + ") is not found in the database!!");
        }
        return res;
    }


    @RequestMapping(path="/departments/search/empid/{id}", method=RequestMethod.GET)
    public List<Department> getDepartmentByEmpId(@PathVariable Integer id) throws DepartmentNotFoundException{
        List<Department> res = departmentService.findDepartmentByEmpId(id);
        if (res.size() == 0) {
            throw new DepartmentNotFoundException("There is no department who has an employee with id(" + id + ")!!");
        }
        return res;
    }


    @ResponseStatus(code=HttpStatus.NOT_FOUND)
    @ExceptionHandler(DepartmentNotFoundException.class)
    public String departmentException(Exception e) {
        return e.getMessage();
    }
}
