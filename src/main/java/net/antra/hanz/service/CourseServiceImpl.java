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
    public Course updateCourse(Course c, Integer id) {
        Course persistCourse = courseRepository.findOne(id);
        if (persistCourse == null) {
            return persistCourse;
        }
        persistCourse.setCourseName(c.getCourseName());
        return courseRepository.save(persistCourse);
    }

    @Transactional
    @Override
    public Course deleteCourseById(Integer id) {
        Course c = courseRepository.findOne(id);
        if (c != null) courseRepository.delete(c);
        return c;
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
    public List<Course> searchCourseByName(String name) {
        return courseRepository.findByCourseNameLike(name);
    }

    @Transactional
    @Override
    public List<Course> searchCourseByEmpId(Integer empId) {
        return courseRepository.findByEmpId(empId);
    }


}
