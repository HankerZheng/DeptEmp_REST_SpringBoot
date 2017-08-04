package net.antra.hanz.service;

import net.antra.hanz.persistence.repository.DepartmentRepository;
import net.antra.hanz.persistence.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hanzheng on 7/27/17.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    DepartmentRepository departmentRepository;

    @Transactional
    @Override
    public Department saveDepartment(Department d) {
        return departmentRepository.save(d);
    }

    @Transactional
    @Override
    public List<Department> findAllDepartments() {
        return departmentRepository.findAll();
    }

    @Transactional
    @Override
    public Department findDepartmentById(Integer id) {
        return departmentRepository.findOne(id);
    }

    @Transactional
    @Override
    public List<Department> findDepartmentByName(String name) {
        return departmentRepository.findByDeptName(name);
    }

    @Transactional
    @Override
    public List<Department> findDepartmentByEmpId(Integer empId) {
        return departmentRepository.findByEmpId(empId);
    }

    @Transactional
    @Override
    public Department deleteDepartmentById(Integer id) {
        Department d = departmentRepository.findOne(id);
        if (d != null) departmentRepository.save(d);
        return d;
    }

}
