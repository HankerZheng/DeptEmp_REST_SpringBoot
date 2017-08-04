package net.antra.hanz.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

/**
 * Created by hanzheng on 8/3/17.
 */

@Entity
@Table(name="course_emp_asso")
public class CourseEmployeeAssociation {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Integer id;

    @Column(name="grade")
    Integer grade;

    @ManyToOne
    @JoinColumn(name="emp_id")
//    @JsonBackReference
    Employee employee;

    @ManyToOne
    @JoinColumn(name="course_id")
//    @JsonBackReference
    Course course;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
