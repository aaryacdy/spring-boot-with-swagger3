package com.arya.swagger.controller;

import com.arya.swagger.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {

    private List<Employee> employees = createList();

    @GetMapping(value = "/employees", produces = "application/json")
    public List<Employee> firstPage() {
        System.out.println(" Employee Size : " + employees.size());
        return employees;
    }

    @DeleteMapping(path = {"/{id}"})
    public Employee delete(@PathVariable("id") int id) {
        Employee deletedEmp = null;
        for (Employee emp : employees) {
            if (emp.getEmpId().equals(id)) {
                employees.remove(emp);
                deletedEmp = emp;
                break;
            }
        }
        return deletedEmp;
    }

    @PostMapping
    public Employee create(@RequestBody Employee user) {
        employees.add(user);
        System.out.println(employees);
        return user;
    }

    private static List<Employee> createList() {
        List<Employee> tempEmployees = new ArrayList<>();
        Employee emp1 = new Employee();
        emp1.setName("Aarya Chaudhary");
        emp1.setDesignation("Software Developer");
        emp1.setEmpId("1");
        emp1.setSalary(90000);

        Employee emp2 = new Employee();
        emp2.setName("Nikit Karki");
        emp2.setDesignation("Java Developer");
        emp2.setEmpId("2");
        emp2.setSalary(60000);
        tempEmployees.add(emp1);
        tempEmployees.add(emp2);
        return tempEmployees;
    }
}
