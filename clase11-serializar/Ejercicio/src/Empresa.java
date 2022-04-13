import java.io.Serializable;
import java.util.List;

public class Empresa implements Serializable {
    //atributos
    private String cuit, razonSocial;
    //lista de empleados
    private List<Empleado> empleados;

    //constructor
    public Empresa(String cuit, String razonSocial, List<Empleado> empleados) {
        this.cuit = cuit;
        this.razonSocial = razonSocial;
        this.empleados = empleados;
    }

    //getter y setter
    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

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

    //toString
    public String toStringEmpleados(){
        String res= "";
        for(Empleado e : this.empleados){
            res = res + e.toString()+"\n";
        }
        return res;
    }

    //otro metodo tostring
    @Override
    public String toString(){
        return this.razonSocial+", "+this.cuit+", \n"+this.toStringEmpleados();
    }

}
