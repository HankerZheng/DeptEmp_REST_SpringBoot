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
    @GetMapping(path="/departments")
    public List<Department> getAllDepartments() {
        return departmentService.findAllDepartments();
    }

    // Find one department with ID
    @GetMapping(path="/departments/{id}")
    public Department getDepartmentById(@PathVariable Integer id) throws DepartmentNotFoundException{
        Department d = departmentService.findDepartmentById(id);
        if (d == null) {
            throw new DepartmentNotFoundException("ID", id.toString());
        }
        return d;
    }

    // Create new department
    @PostMapping(path="/departments")
    public Department addDepartment(Department d) {
        return departmentService.saveDepartment(d);
    }

    // Update an existing department
    @PutMapping(path="/departments/{id}")
    public Department updateDepartment(Department d, @PathVariable Integer id) throws DepartmentNotFoundException{
        Department updated = departmentService.updateDepartment(d, id);
        if (updated == null) throw new DepartmentNotFoundException("ID", id.toString());
        return updated;
    }


    @DeleteMapping(path="/departments/{id}")
    public Department deleteDepartmentById(@PathVariable Integer id) throws DepartmentNotFoundException{
        Department d = departmentService.deleteDepartmentById(id);
        if (d == null) {
            throw new DepartmentNotFoundException("ID", id.toString());
        }
        d.setEmployees(null);
        return d;
    }

    @GetMapping(path="/departments/name/{name}")
    public List<Department> getDepartmentsByName(@PathVariable String name) throws DepartmentNotFoundException{
        List<Department> res = departmentService.findDepartmentByName(name);
        if(res.size() == 0) {
            throw new DepartmentNotFoundException("Name", name);
        }
        return res;
    }


    @GetMapping(path="/departments/search/empid/{id}")
    public List<Department> getDepartmentByEmpId(@PathVariable Integer id) throws DepartmentNotFoundException{
        List<Department> res = departmentService.findDepartmentByEmpId(id);
        if (res.size() == 0) {
            throw new DepartmentNotFoundException("with EmpID", id.toString());
        }
        return res;
    }


    @ResponseStatus(code=HttpStatus.NOT_FOUND)
    @ExceptionHandler(DepartmentNotFoundException.class)
    public String departmentException(Exception e) {
        return e.getMessage();
    }
}
