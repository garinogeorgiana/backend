package entity;

import java.util.List;

public class Company {
    private String cuit;
    private String razonSocial;
    private List<Empleado>empleadoList;

    //cosntructor

    public Company(String cuit, String razonSocial, List<Empleado> empleadoList) {
        this.cuit = cuit;
        this.razonSocial = razonSocial;
        this.empleadoList = empleadoList;
    }

    //getter y setter

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public List<Empleado> getEmpleadoList() {
        return empleadoList;
    }

    public void setEmpleadoList(List<Empleado> empleadoList) {
        this.empleadoList = empleadoList;
    }

    //toString

    @Override
    public String toString() {
        return "Company{" +
                "cuit='" + cuit + '\'' +
                ", razonSocial='" + razonSocial + '\'' +
                ", empleadoList=" + empleadoList +
                '}';
    }
}
