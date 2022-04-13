public abstract class Empleado {
    private String nombre;
    private String apellido;
    private int numeroCuenta;

    //constructor
    public Empleado(String nombre, String apellido, int numeroCuenta) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroCuenta = numeroCuenta;
    }

    //getter y setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    //metodos
    public String liquidarSueldo() {
        calculo();
        imprimir();
        depositar();
        return "Se liquido el sueldo de: " + nombre;

    }

}
