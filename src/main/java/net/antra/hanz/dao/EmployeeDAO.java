package net.antra.hanz.dao;

import net.antra.hanz.pojo.Employee;

import java.util.List;

/**
 * Created by hanzheng on 7/27/17.
 */
public interface EmployeeDAO {
    public void save(Employee e);
    public Employee findEmployeeById(Integer id);
    public List<Employee> findAllEmployees();
    public List<Employee> findEmployeeByName(String name);
    public Employee deleteEmployeeById(Integer id);
}
