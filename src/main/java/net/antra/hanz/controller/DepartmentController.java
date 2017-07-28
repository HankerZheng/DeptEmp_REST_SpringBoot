package net.antra.hanz.controller;

import net.antra.hanz.pojo.Department;
import net.antra.hanz.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Department getDepartmentById(@PathVariable Integer id) {
        return departmentService.findDepartmentById(id);
    }

    @RequestMapping(path="/department/name/{name}", method=RequestMethod.GET)
    public List<Department> getDepartmentsByName(@PathVariable String name) {
        return departmentService.findDepartmentByName(name);
    }

    @RequestMapping(path="/department", method=RequestMethod.POST)
    public Department addDepartment(Department d) {
        departmentService.saveDepartment(d);
        return d;
    }

    @RequestMapping(path="/department/id/{id}", method=RequestMethod.DELETE)
    public Department deleteDepartmentById(@PathVariable Integer id) {
        return departmentService.deleteDepartmentById(id);
    }

    @ExceptionHandler(RuntimeException.class)
    public Exception departmentException(Exception e) {
        return e;
    }
}
