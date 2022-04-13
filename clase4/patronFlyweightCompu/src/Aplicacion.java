public class Aplicacion {

    public static void main(String[] args){

        ComputerFactory computer = new ComputerFactory();
        Computadora mac1 = computer.getComputadora(16,500);
        Computadora windows = computer.getComputadora(2,256);
        Computadora mac2 = computer.getComputadora(16,500);
        Computadora windows2 = computer.getComputadora(16,500);

        System.out.println(mac1.toString());
        System.out.println(mac2.toString());
        System.out.println(windows.toString());
        System.out.println(windows2.toString());

    }
}
