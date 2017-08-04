package net.antra.hanz.service;

import net.antra.hanz.persistence.entity.Employee;

import java.util.List;

/**
 * Created by hanzheng on 7/27/17.
 */
public interface EmployeeService {

    public Employee saveEmployee(Employee e, Integer deptId);
    public List<Employee> findAllEmployees();
    public Employee findEmployeeById(Integer id);
    public List<Employee> findEmployeeByName(String name);
    public Employee deleteEmployeeById(Integer id);

}
