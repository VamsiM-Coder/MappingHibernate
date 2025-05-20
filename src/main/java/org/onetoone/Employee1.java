package org.onetoone;

import jakarta.persistence.*;

@Entity
public class Employee1 {

    @Id
    private int empId;
    private String empName;
    private Double empSalary;
    private String department;

    @OneToOne(cascade = CascadeType.ALL)
    private Laptop1 lap;

    // Getters and setters
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public Laptop1 getLaptop() {
        return lap;
    }

    public void setLaptop(Laptop1 lap) {
        this.lap = lap;
    }

    public Double getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(Double empSalary) {
        this.empSalary = empSalary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "department='" + department + '\'' +
                ", empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empSalary=" + empSalary +
                ", laptop=" + lap +
                '}';
    }
}
