package net.antra.hanz.persistence.repository;

import net.antra.hanz.persistence.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by hanzheng on 8/3/17.
 */
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    List<Department> findByDeptNameLike(String deptName);
    List<Department> findByDeptEmailLike(String deptEmail);

    @Query("select d from Department d join d.employees e where e.empId = ?1")
    List<Department> findByEmpId(Integer empId);

}
