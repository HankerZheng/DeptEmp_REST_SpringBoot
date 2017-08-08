package net.antra.hanz.service;

import net.antra.hanz.persistence.repository.DepartmentRepository;
import net.antra.hanz.persistence.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public Department updateDepartment(Department d, Integer id) {
        Department persistDept = departmentRepository.getOne(id);
        if (persistDept == null) {
            return persistDept;
        }
        persistDept.setDeptName(d.getDeptName());
        persistDept.setDeptEmail(d.getDeptEmail());
        return departmentRepository.save(persistDept);
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
    public List<Department> searchDepartmentByName(String name) {
        return departmentRepository.findByDeptNameLike(name);
    }

    @Transactional
    @Override
    public List<Department> searchDepartmentByEmpId(Integer empId) {
        return departmentRepository.findByEmpId(empId);
    }

    @Transactional
    @Override
    public Department deleteDepartmentById(Integer id) {
        Department d = departmentRepository.findOne(id);
        if (d != null) departmentRepository.save(d);
        return d;
    }


    @Transactional
    @Override
    public List<Department> testQuery() {
        return departmentRepository.testQuery();
    }
}
