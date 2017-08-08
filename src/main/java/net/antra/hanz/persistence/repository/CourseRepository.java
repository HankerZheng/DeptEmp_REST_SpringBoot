package net.antra.hanz.persistence.repository;

import net.antra.hanz.persistence.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by hanzheng on 8/3/17.
 */
public interface CourseRepository extends JpaRepository<Course, Integer> {

    List<Course> findByCourseNameLike(String name);

    @Query("select c from Course c join c.ceas cea join cea.employee e where e.empId = ?1")
    List<Course> findByEmpId(Integer empId);
}
