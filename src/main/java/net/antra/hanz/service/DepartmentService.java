package net.antra.hanz.service;

import net.antra.hanz.persistence.entity.Department;

import java.util.List;

/**
 * Created by hanzheng on 7/27/17.
 */
public interface DepartmentService {

    public Department saveDepartment(Department d);
    public List<Department> findAllDepartments();
    public Department findDepartmentById(Integer id);
    public List<Department> findDepartmentByName(String name);
    public List<Department> findDepartmentByEmpId(Integer empId);
    public Department deleteDepartmentById(Integer id);
}
