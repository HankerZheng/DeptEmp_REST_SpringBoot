package net.antra.hanz.service;

import net.antra.hanz.persistence.entity.Employee;

import java.util.List;

/**
 * Created by hanzheng on 7/27/17.
 */
public interface EmployeeService {

    // modification operation
    public Employee saveEmployee(Employee e, Integer deptId);
    public Employee updateEmployee(Employee e, Integer id);

    // delete operation
    public Employee deleteEmployeeById(Integer id);

    // normal find queries
    public List<Employee> findAllEmployees();
    public Employee findEmployeeById(Integer id);

    // search queries
    public List<Employee> findEmployeeByName(String name);

}
