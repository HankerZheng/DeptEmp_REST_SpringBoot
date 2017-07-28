package net.antra.hanz.service;

import net.antra.hanz.dao.DepartmentDAO;
import net.antra.hanz.dao.EmployeeDAO;
import net.antra.hanz.pojo.Department;
import net.antra.hanz.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by hanzheng on 7/27/17.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDAO employeeDAO;

    @Autowired
    DepartmentDAO departmentDAO;


    @Transactional
    @Override
    public void saveEmployee(Employee e, Integer deptId) {
        Department d = departmentDAO.findDepartmentById(deptId);
        e.setDepartment(d);
        employeeDAO.save(e);
    }

    @Transactional
    @Override
    public List<Employee> findAllEmployees() {
        return employeeDAO.findAllEmployees();
    }

    @Transactional
    @Override
    public Employee findEmployeeById(Integer id){
        return employeeDAO.findEmployeeById(id);
    }

    @Transactional
    @Override
    public List<Employee> findEmployeeByName(String name) {
        return employeeDAO.findEmployeeByName(name);
    }
}