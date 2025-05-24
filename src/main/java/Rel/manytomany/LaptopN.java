package Rel.manytomany;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class LaptopN {

    @Id
    private int lid;

    private String lname;
    private String model;

    @ManyToMany(mappedBy = "laptops")  // Inverse side
    private List<EmployeeN> employees;

    // Getters and Setters

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<EmployeeN> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeN> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "LaptopN{" +
                "employees=" + employees +
                ", lid=" + lid +
                ", lname='" + lname + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
