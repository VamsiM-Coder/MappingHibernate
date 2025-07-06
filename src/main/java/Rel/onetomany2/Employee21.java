package Rel.onetomany2;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table
public class Employee21 {

    @Id
    private int empId;

    private String empName;
    private Double empSalary;
    private String department;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL) //Interlinkage done by this entity.
    private List<Laptop21> laps;

    // Getters and Setters

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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Laptop21> getLaps() {
        return laps;
    }

    public void setLaps(List<Laptop21> laps) {
        this.laps = laps;
    }
}

