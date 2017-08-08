package net.antra.hanz.dto;

import net.antra.hanz.persistence.entity.CourseEmployeeAssociation;

import java.util.List;

/**
 * Created by hanzheng on 8/4/17.
 */
public class CourseDTO {

    String courseId;
    String courseName;
    List<String> ceas;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<String> getCeas() {
        return ceas;
    }

    public void setCeas(List<String> ceas) {
        this.ceas = ceas;
    }
}
