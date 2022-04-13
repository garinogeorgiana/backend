package entity;


public class Empleado {
    private String name;
    private String lastname;
    private String docket;
    private Double salary;

    //constructor
    public Empleado(String name, String lastname, String docket, Double salary) {
        this.name = name;
        this.lastname = lastname;
        this.docket = docket;
        this.salary = salary;
    }

    //getter y setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDocket() {
        return docket;
    }

    public void setDocket(String docket) {
        this.docket = docket;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    //tostring

    @Override
    public String toString() {
        return "Empleado{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", docket='" + docket + '\'' +
                ", salary=" + salary +
                '}';
    }
}
