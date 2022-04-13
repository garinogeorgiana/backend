public abstract class Menu {
    private double precioBase;

    //constructor
    public Menu(double precioBase) {
        this.precioBase = precioBase;
    }

    //getter y setter
    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    //metodos
    public abstract double calcularPrecio();
    public abstract String informarArmadoPedido();


}
