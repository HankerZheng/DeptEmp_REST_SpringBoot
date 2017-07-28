package net.antra.hanz.service;

import net.antra.hanz.dao.DepartmentDAO;
import net.antra.hanz.pojo.Department;
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
    DepartmentDAO departmentDAO;

    @Transactional
    @Override
    public void saveDepartment(Department d) {
        departmentDAO.save(d);
    }

    @Transactional
    @Override
    public List<Department> findAllDepartments() {
        return departmentDAO.findAllDepartments();
    }

    @Transactional
    @Override
    public Department findDepartmentById(Integer id) {
        return departmentDAO.findDepartmentById(id);
    }

    @Transactional
    @Override
    public List<Department> findDepartmentByName(String name) {
        return departmentDAO.findDepartmentByName(name);
    }

    @Transactional
    @Override
    public Department deleteDepartmentById(Integer id) {
        return departmentDAO.deleteDepartmentById(id);
    }

}
