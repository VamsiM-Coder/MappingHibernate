package org.onetomany2;

import jakarta.persistence.*;

@Entity
@Table(name = "laptop21")
public class Laptop21 {

    @Id
    private int lid;

    private String lname;
    private String model;

    @ManyToOne
    @JoinColumn(name = "emp_id") // FK in laptop21 table pointing to employee21.empId
    private Employee21 employee;

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

    public Employee21 getEmployee() {
        return employee;
    }

    public void setEmployee(Employee21 employee) {
        this.employee = employee;
    }
}

