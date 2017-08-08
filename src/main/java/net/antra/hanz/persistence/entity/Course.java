package net.antra.hanz.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

/**
 * Created by hanzheng on 8/3/17.
 */

@Entity
@Table(name="course")
public class Course {
    @Id
    @Column(name="course_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Integer courseId;

    @Column(name="course_name")
    String courseName;

    @OneToMany(mappedBy="course")
    @JsonBackReference
    List<CourseEmployeeAssociation> ceas;

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public List<CourseEmployeeAssociation> getCeas() {
        return ceas;
    }

    public void setCeas(List<CourseEmployeeAssociation> ceas) {
        this.ceas = ceas;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String toString() {
        return getCourseId() + ": " + getCourseName();
    }
}
