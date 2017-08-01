package net.antra.hanz.controller;

import net.antra.hanz.exception.controller.DepartmentNotFoundException;
import net.antra.hanz.pojo.Department;
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

    @RequestMapping(path="/department", method=RequestMethod.GET)
    public List<Department> getAllDepartments() {
        return departmentService.findAllDepartments();
    }

    @RequestMapping(path="/department/id/{id}", method=RequestMethod.GET)
    public Department getDepartmentById(@PathVariable Integer id){
        Department d = departmentService.findDepartmentById(id);
        if (d == null) {
            throw new DepartmentNotFoundException("department ID(" + id + ")is not found in the database!!");
        }
        return d;
    }

    @RequestMapping(path="/department/name/{name}", method=RequestMethod.GET)
    public List<Department> getDepartmentsByName(@PathVariable String name) {
        List<Department> res = departmentService.findDepartmentByName(name);
        if(res.size() == 0) {
            throw new DepartmentNotFoundException("department name(" + name + ") is not found in the database!!");
        }
        return res;
    }

    @RequestMapping(path="/department", method=RequestMethod.POST)
    public Department addDepartment(Department d) {
        departmentService.saveDepartment(d);
        return d;
    }

    @RequestMapping(path="/department/id/{id}", method=RequestMethod.DELETE)
    public Department deleteDepartmentById(@PathVariable Integer id) {
        Department d = departmentService.deleteDepartmentById(id);
        if (d == null) {
            throw new DepartmentNotFoundException("department ID(" + id + ") is not found in the database! Delete operation cannot be performed!");
        }
        return d;
    }

    @ResponseStatus(code=HttpStatus.NOT_FOUND)
    @ExceptionHandler(DepartmentNotFoundException.class)
    public String departmentException(Exception e) {
        return e.getMessage();
    }
}
