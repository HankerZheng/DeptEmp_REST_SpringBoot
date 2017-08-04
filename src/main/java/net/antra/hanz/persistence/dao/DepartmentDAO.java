package net.antra.hanz.persistence.dao;

import net.antra.hanz.persistence.entity.Department;

import java.util.List;

/**
 * Created by hanzheng on 7/27/17.
 */
public interface DepartmentDAO {
    public void save(Department d);
    public Department findDepartmentById(Integer id);
    public List<Department> findAllDepartments();
    public List<Department> findDepartmentByName(String name);
    public Department deleteDepartmentById(Integer id);
}
