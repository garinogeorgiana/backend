import java.time.LocalDate;

public abstract class Tarjeta {

    private int nroFrente;
    private int codigoSeguridad;
    private boolean verificaciones;
    private LocalDate fechaDeExpiracion;

    //construccion
    public Tarjeta(int nroFrente, int codigoSeguridad, boolean verificaciones, LocalDate fechaDeExpiracion) {
        this.nroFrente = (int) (Math.random()*1000);
        this.codigoSeguridad = (int) (Math.random()*1000);
        this.verificaciones = verificaciones;
        this.fechaDeExpiracion = LocalDate.now().plusYears(5);
    }

    //getter y setter

    public int getNroFrente() {
        return nroFrente;
    }

    public void setNroFrente(int nroFrente) {
        this.nroFrente = nroFrente;
    }

    public int getCodigoSeguridad() {
        return codigoSeguridad;
    }

    public void setCodigoSeguridad(int codigoSeguridad) {
        this.codigoSeguridad = codigoSeguridad;
    }

    public boolean isVerificaciones() {
        return verificaciones;
    }

    public void setVerificaciones(boolean verificaciones) {
        this.verificaciones = verificaciones;
    }

    public LocalDate getFechaDeExpiracion() {
        return fechaDeExpiracion;
    }

    public void setFechaDeExpiracion(LocalDate fechaDeExpiracion) {
        this.fechaDeExpiracion = fechaDeExpiracion;
    }
}
