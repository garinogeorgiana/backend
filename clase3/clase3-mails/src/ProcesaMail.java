public class ProcesaMail {
    public static void main(String[] args){

        CompruebaMail proceso = new CompruebaMail();
        proceso.comprobar(new Mail("mio@mail.com", "tecnica@digitalhouse.com", "gerencia"));
        proceso.comprobar(new Mail("mio@mail.com", "sds@digitalhouse.com", "tecnico"));
        proceso.comprobar(new Mail("mio@mail.com", "uan@pepe.com", "comercial"));
        proceso.comprobar(new Mail("mio@mail.com", "qqq@digitalhouse.com", "gerencia"));

    }
}
