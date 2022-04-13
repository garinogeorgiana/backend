public class Computadora {
    private int ram;
    private int disco;
    private int id;
    private static int contador;

    //constructor
    public Computadora(int ram, int disco) {
        this.ram = ram;
        this.disco = disco;
        contador++;
        System.out.println("contador"+ contador);
    }

    //getter y setter

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getDisco() {
        return disco;
    }

    public void setDisco(int disco) {
        this.disco = disco;
    }


    //tostring para mostrar mejor

    @Override
    public String toString() {
        return "Computadora{" +
                "ram=" + ram +
                ", disco=" + disco +
                '}';
    }
}



