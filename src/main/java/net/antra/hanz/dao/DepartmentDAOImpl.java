package net.antra.hanz.dao;

import net.antra.hanz.pojo.Department;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by hanzheng on 7/27/17.
 */
@Repository
public class DepartmentDAOImpl implements DepartmentDAO{

    @PersistenceContext
    EntityManager em;

    @Transactional
    @Override
    public void save(Department d) {
       em.persist(d);
    }

    @Transactional
    @Override
    public Department findDepartmentById(Integer id) {
        return em.find(Department.class, id);
    }

    @Transactional
    @Override
    public List<Department> findAllDepartments() {
        Query query = em.createQuery("select distinct object (d) from Department d");
        return query.getResultList();
    }

    @Transactional
    @Override
    public List<Department> findDepartmentByName(String name) {
        Query query = em.createQuery("select distinct object (d) from Department d where d.deptName = :name");
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Transactional
    @Override
    public Department deleteDepartmentById(Integer id) {
        Department d = em.find(Department.class, id);
        em.remove(d);
        return d;
    }
}
