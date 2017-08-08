package net.antra.hanz;

import net.antra.hanz.dto.DepartmentDTO;
import net.antra.hanz.dto.Mapper;
import net.antra.hanz.persistence.entity.Department;
import net.antra.hanz.persistence.entity.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hanzheng on 8/8/17.
 */
public class MapperTest {

    public static void main(String[] args) {
        Mapper mapper = new Mapper();
        Department d = new Department();
        d.setDeptId(12);
        d.setDeptName("test");
        d.setDeptEmail("test@antra.net");
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee());
        employees.add(new Employee());
        d.setEmployees(employees);
//
        try {
            DepartmentDTO ddto = (DepartmentDTO) mapper.map(d);
            System.out.println(ddto.toString());
//        System.out.println(Class.forName("DepartmentDTO").getName().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
