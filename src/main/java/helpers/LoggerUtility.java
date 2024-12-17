package helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtility {

    private static Logger logger = LogManager.getLogger();

    public static void startTest(String testName) {
        logger.info("************ EXECUTION STARTED: " + testName + " ************");
    }

    public void infoLog(String message) {
        logger.info(message);
    }

    public void errorLog(String message) {
        logger.error(message);
    }

    public void finishTest(String testName) {
        logger.info("************ EXECUTION FINISHED: " + testName + " ************");
    }

}