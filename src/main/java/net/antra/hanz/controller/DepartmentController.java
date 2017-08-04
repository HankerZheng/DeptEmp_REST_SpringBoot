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

    /*
     * Retrieve all departments
     */
    @GetMapping(path="/departments")
    public List<Department> getAllDepartments() {
        return departmentService.findAllDepartments();
    }

    /*
     * Retrieve one department according to its ID
     */
    @GetMapping(path="/departments/{id}")
    public Department getDepartmentById(@PathVariable Integer id) throws DepartmentNotFoundException{
        Department d = departmentService.findDepartmentById(id);
        if (d == null) {
            throw new DepartmentNotFoundException("ID", id.toString());
        }
        return d;
    }

    /*
     * Create a new department
     */
    @PostMapping(path="/departments")
    public Department addDepartment(Department d) {
        return departmentService.saveDepartment(d);
    }

    /*
     * Update an existing department
     */
    @PutMapping(path="/departments/{id}")
    public Department updateDepartment(Department d, @PathVariable Integer id) throws DepartmentNotFoundException{
        Department updated = departmentService.updateDepartment(d, id);
        if (updated == null){
            throw new DepartmentNotFoundException("ID", id.toString());
        }
        return updated;
    }

    /*
     * Delete an existing department
     */
    @DeleteMapping(path="/departments/{id}")
    public Department deleteDepartmentById(@PathVariable Integer id) throws DepartmentNotFoundException{
        Department d = departmentService.deleteDepartmentById(id);
        if (d == null) {
            throw new DepartmentNotFoundException("ID", id.toString());
        }
        return d;
    }



    /*
     * Search Queries
     */

    /*
     * Search departments according to their name
     */
    @GetMapping(path="/search/departments/name/{name}")
    public List<Department> getDepartmentsByName(@PathVariable String name) throws DepartmentNotFoundException{
        List<Department> res = departmentService.searchDepartmentByName(name);
        if(res.size() == 0) {
            throw new DepartmentNotFoundException("Name", name);
        }
        return res;
    }


    /*
     * Search departments according to the employee ID
     */
    @GetMapping(path="/search/departments/empid/{id}")
    public List<Department> getDepartmentByEmpId(@PathVariable Integer id) throws DepartmentNotFoundException{
        List<Department> res = departmentService.searchDepartmentByEmpId(id);
        if (res.size() == 0) {
            throw new DepartmentNotFoundException("with EmpID", id.toString());
        }
        return res;
    }


    /*
     * Exception handler for Department
     */
    @ResponseStatus(code=HttpStatus.NOT_FOUND)
    @ExceptionHandler(DepartmentNotFoundException.class)
    public String departmentException(Exception e) {
        return e.getMessage();
    }
}
