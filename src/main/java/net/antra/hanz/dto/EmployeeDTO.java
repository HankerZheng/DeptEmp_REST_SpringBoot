package net.antra.hanz.dto;

import net.antra.hanz.persistence.entity.CourseEmployeeAssociation;
import net.antra.hanz.persistence.entity.Department;

import java.util.List;

/**
 * Created by hanzheng on 8/4/17.
 */
public class EmployeeDTO {

    String empId;
    String firstName;
    String lastName;
    String age;
    List<String> ceas;
    String department;

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public List<String> getCeas() {
        return ceas;
    }

    public void setCeas(List<String> ceas) {
        this.ceas = ceas;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
