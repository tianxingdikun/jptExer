package controller;

import exception.SimpleException;
//import org.apache.log4j.Logger;
import java.util.logging.*;


public class SelfCreateExceptionExer {

    private static Logger logger = Logger.getLogger("");

    public void exerciseSimpleException() throws SimpleException {
        System.out.println("抛SimpleException");
        throw new SimpleException();
    }

    public void exerLog() {
        logger.severe("");
    }


}
