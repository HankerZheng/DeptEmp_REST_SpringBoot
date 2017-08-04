package net.antra.hanz.service;

import net.antra.hanz.persistence.entity.Course;

import java.util.List;

/**
 * Created by hanzheng on 8/3/17.
 */
public interface CourseService {
    // modification operation
    public Course saveCourse(Course c);
    public Course updateCourse(Course c, Integer id);

    // delete operation
    public Course deleteCourseById(Integer id);

    // normal find queries
    public List<Course> findAllCourses();
    public Course findCourseById(Integer id);

    // search queries
    public List<Course> searchCourseByName(String name);
    public List<Course> searchCourseByEmpId(Integer empId);
}
