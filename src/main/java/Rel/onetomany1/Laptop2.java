package Rel.onetomany1;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Laptop2 {
    @Id
    private int lid;
    private String lname;
    private String model;

     @ManyToOne// foreign key column in Laptop table
    private Employee2 employee2;

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public Employee2 getEmployee2() {
        return employee2;
    }

    public void setEmployee2(Employee2 employee2) {
        this.employee2 = employee2;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Laptop2{" +
                "employee2=" + employee2 +
                ", lid=" + lid +
                ", lname='" + lname + '\'' +
                ", model='" + model + '\'' +
                '}';
    }

}
