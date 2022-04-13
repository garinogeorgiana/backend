import java.time.LocalDate;

public class TarjetaDebito  extends Tarjeta{
    private double saldoDisponible;

    public TarjetaDebito(int nroFrente, int codigoSeguridad, boolean verificaciones, LocalDate fechaDeExpiracion) {
        super(nroFrente, codigoSeguridad, verificaciones, fechaDeExpiracion);
        this.saldoDisponible=saldoDisponible;
    }

    //getter y setter

    public double getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(double saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }
}
