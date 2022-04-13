public class Infantil extends Menu{
    private int cantJuguete;

    //constructor


    public Infantil(double precioBase, int cantJuguete) {
        super(precioBase);
        this.cantJuguete = cantJuguete;
    }

    @Override
    public double calcularPrecio() {
        return getPrecioBase()*cantJuguete*3;
    }

    @Override
    public String informarArmadoPedido() {
        return "armar un menu infantil";
    }
}
