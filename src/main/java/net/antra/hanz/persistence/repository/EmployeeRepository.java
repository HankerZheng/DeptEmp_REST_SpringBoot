package net.antra.hanz.persistence.repository;

import net.antra.hanz.persistence.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by hanzheng on 8/3/17.
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("select e from Employee e where e.firstName = ?1 or e.lastName = ?1")
    public List<Employee> findByName(String name);
}
