package net.antra.hanz.dao;

import net.antra.hanz.pojo.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by hanzheng on 7/27/17.
 */
@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    @PersistenceContext
    EntityManager em;


    @Override
    public void save(Employee e) {
        em.persist(e);
    }

    @Override
    public Employee findEmployeeById(Integer id) {
        return em.find(Employee.class, id);
    }

    @Override
    public List<Employee> findAllEmployees() {
        Query query = em.createQuery("select distinct OBJECT (e) from Employee e");
        return query.getResultList();
    }

    @Override
    public List<Employee> findEmployeeByName(String name) {
        Query query = em.createQuery("select distinct object (e) from Employee e where e.firstName = :name OR e.lastName = :name");
        query.setParameter("name", name);
        return query.getResultList();
    }
}
