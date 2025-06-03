package Rel.manytomany;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class EmployeeN {

    @Id
    private int empId;

    private String empName;
    private double empSalary;

    @ManyToMany(cascade = CascadeType.ALL)
    // Purpose of JoinTable
//    You want to control the name of the join table.
//    You want to control the column names in the join table.
//    You want better clarity in your database schema.
    // This is optional
    @JoinTable(
            name = "employee_laptop", // Join table
            joinColumns = @JoinColumn(name = "emp_id"),
            inverseJoinColumns = @JoinColumn(name = "lap_id")
    )
    private List<LaptopN> laptops;

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

    public double getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(double empSalary) {
        this.empSalary = empSalary;
    }

    public List<LaptopN> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<LaptopN> laptops) {
        this.laptops = laptops;
    }

    @Override
    public String toString() {
        return "EmployeeN{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empSalary=" + empSalary +
                ", laptops=" + laptops +
                '}';
    }
}
