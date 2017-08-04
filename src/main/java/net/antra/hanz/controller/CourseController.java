package net.antra.hanz.controller;

import net.antra.hanz.exception.controller.CourseNotFoundException;
import net.antra.hanz.persistence.entity.Course;
import net.antra.hanz.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by hanzheng on 8/3/17.
 */
@RestController
public class CourseController {

    @Autowired
    CourseService courseService;

    /*
     * Retrieve all courses
     */
    @GetMapping(path="/courses")
    List<Course> getAllCourses(){
        return courseService.findAllCourses();
    }

    /*
     * Retrieve one course according to its id
     */
    @GetMapping(path="/courses/{id}")
    Course getCourseById(@PathVariable Integer id) {
        return courseService.findCourseById(id);
    }

    /*
     * Create a new course
     */
    @PostMapping(path="/courses")
    Course addCourse(Course c) {
        return courseService.saveCourse(c);
    }

    /*
     * Update an existing course
     */
    @PutMapping(path="/courses/{id}")
    Course updateCourse(Course c, @PathVariable Integer id) throws CourseNotFoundException{
        Course updated = courseService.updateCourse(c, id);
        if (updated == null) {
            throw new CourseNotFoundException("ID", id.toString());
        }
        return updated;
    }

    /*
     * Delete an existing course
     */
    @DeleteMapping(path="/courses/{id}")
    Course deleteCourse(@PathVariable Integer id) throws CourseNotFoundException{
        Course c = courseService.deleteCourseById(id);
        if (c == null){
            throw new CourseNotFoundException("ID", id.toString());
        }
        return c;
    }

    /*
     * Search Queries for Course
     */

    /*
     * Search according to course name
     */
    @GetMapping(path="/search/courses/name/{name}")
    List<Course> searchCourseByName(@PathVariable String name) throws CourseNotFoundException {
        List<Course> res = courseService.searchCourseByName(name);
        if (res.size() == 0) {
            throw new CourseNotFoundException("Name", name);
        }
        return res;
    }


    /*
     * Exception handler for Course
     */
    @ResponseStatus(code= HttpStatus.NOT_FOUND)
    @ExceptionHandler(CourseNotFoundException.class)
    public String handleCourseException(Exception e) {
        return e.getMessage();
    }

}
