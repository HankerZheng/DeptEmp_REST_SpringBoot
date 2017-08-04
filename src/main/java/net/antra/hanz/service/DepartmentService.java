package net.antra.hanz.service;

import net.antra.hanz.exception.controller.DepartmentNotFoundException;
import net.antra.hanz.persistence.entity.Department;

import java.util.List;

/**
 * Created by hanzheng on 7/27/17.
 */
public interface DepartmentService {

    // modification operation
    public Department saveDepartment(Department d);
    public Department updateDepartment(Department d, Integer id);

    // delete operation
    public Department deleteDepartmentById(Integer id);

    // normal find queries
    public List<Department> findAllDepartments();
    public Department findDepartmentById(Integer id);

    // search queries
    public List<Department> findDepartmentByName(String name);
    public List<Department> findDepartmentByEmpId(Integer empId);
}
