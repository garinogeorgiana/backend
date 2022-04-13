import org.apache.log4j.Logger;


public class TestLog {

    private static Logger logger=Logger.getLogger(TestLog.class);

    public static void main(String[] args) {
        logger.info("arrancando");
        try{
            String variable="hola";
            int division=1/0;
        }catch(Exception e){
            logger.error("error al dividir por cero",e);
        }
        logger.warn("advertencia al metodo main esta porr finalizar");
        logger.debug("esto va a finalizarse");
        logger.info("hello");

    }

}
