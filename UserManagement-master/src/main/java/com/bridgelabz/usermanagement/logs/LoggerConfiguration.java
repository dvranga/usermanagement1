package com.bridgelabz.usermanagement.logs;

import org.apache.logging.log4j.Logger;
import sun.applet.Main;
import static org.apache.logging.log4j.LogManager.getLogger;

public class LoggerConfiguration {
    private static Logger logger = null;
    static {
        System.setProperty("log4j2.properties",
                "C:\\Users\\Heros\\Desktop\\usermanagement\\New folder\\UserManagement-master\\src\\main\\resources\\log4j2.properties");
        logger = getLogger(Main.class.getName());
    }

    public static void main(String[] args) {
        logger.trace("This is trace message");
        logger.info(" this is information message");
        logger.error("this is an error message");
        logger.warn("this is a warning message");
        logger.fatal("this is a fatal message");
    }
}
