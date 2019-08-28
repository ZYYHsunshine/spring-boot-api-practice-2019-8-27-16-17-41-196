package com.tw.apistackbase.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

@RestController
@RequestMapping("/")

public class companyAPIController {

    List<Employee> employeesOld = new ArrayList<Employee>();

    {
        employeesOld.add(new Employee(1, "老一", 18, "500"));
        employeesOld.add(new Employee(2, "老二", 18, "500"));
        employeesOld.add(new Employee(3, "老三", 18, "500"));

    }

    List<Employee> employeesLittle = new ArrayList<Employee>();

    {
        employeesLittle.add(new Employee(1, "小一", 20, "1000"));
        employeesLittle.add(new Employee(2, "小二", 20, "1000"));
        employeesLittle.add(new Employee(3, "小三", 20, "1000"));
    }


    List<Company> companies = new ArrayList<Company>();

    {
        companies.add(new Company("1", "Old公司", 200, employeesOld));
        companies.add(new Company("2", "Little公司", 200, employeesLittle));

    }


    @GetMapping(path = "/companies/")
    @ResponseStatus(HttpStatus.OK)
    public List<Company> getAll() {
        return companies;
    }


    @GetMapping(path = "/companies/{id}")
    public ResponseEntity<Company> getOneCompany(@PathVariable String id) {
        for (Company c : companies) {
            if (c.getCompanyID().equals(id)) {
                return ResponseEntity.ok(c);
            }
        }

        return ResponseEntity.notFound().build();
    }


    @GetMapping(path = "/companies/{id}/employees")
    public ResponseEntity<List<Employee>> getOneCompanyEmployees(@PathVariable String id) {
        for (Company c : companies) {
            if (c.getCompanyID().equals(id)) {
                return ResponseEntity.ok(c.getEmployees());
            }
        }
        return ResponseEntity.notFound().build();

    }


    @PostMapping(path = "/companies/")
    @ResponseStatus(HttpStatus.CREATED)
    public Company creatEmployee(@RequestBody Company company) {
        companies.add(company);
        return company;
    }


    @PutMapping(path = "/companies/{id}/")
    public ResponseEntity<Company> updateCompany(@PathVariable String id, @RequestBody Company changecompany) {
        for (Company company : companies) {
            if (company.getCompanyID().equals(id)) {
                company.setCompanyID(changecompany.getCompanyID());
                company.setCompanyName(changecompany.getCompanyName());
                company.setEmployees(changecompany.getEmployees());
                company.setEmployeesNumber(changecompany.getEmployeesNumber());
                return ResponseEntity.ok(company);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/companies/{id}/")
    public ResponseEntity<String> deletCompany(@PathVariable String id) {
        Iterator<Company> iterator = companies.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getCompanyID() == id) {
                iterator.remove();
                return ResponseEntity.ok(id);
            }

        }
        return ResponseEntity.notFound().build();
    }

}
