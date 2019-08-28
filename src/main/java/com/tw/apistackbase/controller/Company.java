package com.tw.apistackbase.controller;

import java.util.List;

public class Company {
    private String companyID;
    private String companyName;
    private int employeesNumber;
    private List<Employee> employees;



    public Company() {
        super();
    }

    public Company(String companyID, String companyName, int employeesNumber, List<Employee> employees) {
        super();
        this.companyID = companyID;
        this.companyName = companyName;
        this.employeesNumber = employeesNumber;
        this.employees = employees;
    }



    public String getCompanyID() {
        return companyID;
    }

    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public int getEmployeesNumber() {
        return employeesNumber;
    }
    public void setEmployeesNumber(int employeesNumber) {
        this.employeesNumber = employeesNumber;
    }
    public List<Employee> getEmployees() {
        return employees;
    }
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }


}
