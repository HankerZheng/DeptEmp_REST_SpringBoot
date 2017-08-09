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

    @Transactional
    @Override
    public Employee saveEmployee(Employee e) {
        return employeeRepository.save(e);
    }

    @Transactional
    @Override
    public Employee updateEmployee(Employee e, Integer id) {
        e.setEmpId(id);
        return employeeRepository.save(e);
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
    public List<Employee> searchEmployeeByName(String name) {
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