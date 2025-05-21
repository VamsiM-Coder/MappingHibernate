package org.onetomany1;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Employee2 {
    @Id
    private int empId;
    private String empName;
    private Double empSalary;
    private String department;

    @OneToMany//(cascade = CascadeType.ALL)
    private List<Laptop2> laps;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Double getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(Double empSalary) {
        this.empSalary = empSalary;
    }

    public List<Laptop2> getLaps() {
        return laps;
    }

    public void setLaps(List<Laptop2> laps) {
        this.laps = laps;
    }

    @Override
    public String toString() {
        return "Employee2{" +
                "department='" + department + '\'' +
                ", empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empSalary=" + empSalary +
                ", laps=" + laps +
                '}';
    }
}


