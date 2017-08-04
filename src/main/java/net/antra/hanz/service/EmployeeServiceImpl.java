package net.antra.hanz.service;

import net.antra.hanz.persistence.entity.Department;
import net.antra.hanz.persistence.entity.Employee;
import net.antra.hanz.persistence.repository.DepartmentRepository;
import net.antra.hanz.persistence.repository.EmployeeRepository;
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
    EmployeeRepository employeeRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Transactional
    @Override
    public Employee saveEmployee(Employee e, Integer deptId) {
        Department d = departmentRepository.findOne(deptId);
        e.setDepartment(d);
        return employeeRepository.save(e);
    }

    @Transactional
    @Override
    public Employee updateEmployee(Employee e, Integer id) {
        Employee persistEmp = employeeRepository.findOne(id);
        if (persistEmp == null) {
            return persistEmp;
        }
        persistEmp.setAge(e.getAge());
        persistEmp.setFirstName(e.getFirstName());
        persistEmp.setLastName(e.getLastName());
        return employeeRepository.save(persistEmp);
    }

    @Transactional
    @Override
    public List<Employee> findAllEmployees(){
        return employeeRepository.findAll();
    }

    @Transactional
    @Override
    public Employee findEmployeeById(Integer id){
        return employeeRepository.findOne(id);
    }

    @Transactional
    @Override
    public List<Employee> findEmployeeByName(String name) {
        return employeeRepository.findByName(name);
    }

    @Transactional
    @Override
    public Employee deleteEmployeeById(Integer id) {
        Employee e = employeeRepository.findOne(id);
        if (e != null) employeeRepository.delete(e);
        return e;
    }
}