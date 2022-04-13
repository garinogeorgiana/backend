public class Clasico extends Menu{

    //constructor
    public Clasico(double precioBase) {
        super(precioBase);
    }

    @Override
    public double calcularPrecio() {
        return getPrecioBase();
    }

    @Override
    public String informarArmadoPedido() {
        return null;
    }
}
