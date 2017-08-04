package net.antra.hanz.service;

import net.antra.hanz.persistence.entity.Course;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hanzheng on 8/3/17.
 */
public interface CourseService {
    public Course saveCourse(Course d);
    public List<Course> findAllCourses();
    public Course findCourseById(Integer id);
    public List<Course> findCourseByName(String name);
    public List<Course> findCourseByEmpId(Integer empId);
    public Course deleteCourseById(Integer id);
}
