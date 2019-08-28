package com.tw.apistackbase.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")

public class EmployeeAPIController {


    List<Employee> employees = new ArrayList<Employee>();

    {
        employees.add(new Employee(1, "老一", 18, "500"));
        employees.add(new Employee(2, "老二", 18, "500"));
        employees.add(new Employee(3, "老三", 18, "500"));
        employees.add(new Employee(1, "小一", 20, "1000"));
        employees.add(new Employee(2, "小二", 20, "1000"));
        employees.add(new Employee(3, "小三", 20, "1000"));
    }


    @GetMapping(path = "/employees")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getAll() {
        return employees;
    }


    @GetMapping(path = "/employees/{id}")
    public ResponseEntity<Employee> getOneEmployee(@PathVariable int id) {
        for (Employee e : employees) {
            if (e.getId() == id) {
                return ResponseEntity.ok(e);
            }
        }
        return ResponseEntity.notFound().build();
    }


    @PostMapping(path = "/employees")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee creatEmployee(@RequestBody Employee employee) {
        employees.add(employee);
        return employee;
    }


    @DeleteMapping(path = "/employees/{id}")
    public ResponseEntity<Integer> deletEmployee(@PathVariable int id) {
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId() == id) {
                iterator.remove();
                return ResponseEntity.ok(id);
            }

        }
        return ResponseEntity.notFound().build();
    }
}
