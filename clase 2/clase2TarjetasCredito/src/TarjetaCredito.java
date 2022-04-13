import java.time.LocalDate;

public class TarjetaCredito extends Tarjeta{

    private double limite;
    private double saldoUsado;


    public TarjetaCredito(int nroFrente, int codigoSeguridad, boolean verificaciones, LocalDate fechaDeExpiracion) {
        super(nroFrente, codigoSeguridad, verificaciones, fechaDeExpiracion);
    }
}
