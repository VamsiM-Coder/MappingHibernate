package Rel.embeded;

import jakarta.persistence.Embeddable;

@Embeddable
public class Laptop {

    int lid;
    String lname;
    String model;

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
        return "Laptop{" +
                "lid=" + lid +
                ", lname='" + lname + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
