package net.antra.hanz.service;

import net.antra.hanz.persistence.entity.Course;
import net.antra.hanz.persistence.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by hanzheng on 8/3/17.
 */
@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    CourseRepository courseRepository;

    @Transactional
    @Override
    public Course saveCourse(Course d) {
        return courseRepository.save(d);
    }

    @Transactional
    @Override
    public List<Course> findAllCourses() {
        return courseRepository.findAll();
    }

    @Transactional
    @Override
    public Course findCourseById(Integer id) {
        return courseRepository.findOne(id);
    }

    @Transactional
    @Override
    public List<Course> findCourseByName(String name) {
        return courseRepository.findByCourseName(name);
    }

    @Transactional
    @Override
    public List<Course> findCourseByEmpId(Integer empId) {
        return courseRepository.findByEmpId(empId);
    }

    @Transactional
    @Override
    public Course deleteCourseById(Integer id) {
        Course c = courseRepository.findOne(id);
        if (c != null) courseRepository.delete(c);
        return c;
    }
}
