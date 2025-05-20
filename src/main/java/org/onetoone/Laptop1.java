package org.onetoone;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Laptop1 {

    @Id
    private int lid;
    private String lname;
    private String model;

    // Getters and setters
    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    @Override
    public String toString() {
        return "Laptopp{" +
                "lid=" + lid +
                ", lname='" + lname + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
