package ua.util;

import java.util.logging.Logger;

public class Utils {
    private static final Logger logger = Logger.getLogger(Utils.class.getName());

    public static void logInfo(String msg) {
        logger.info(msg);
    }

    public static void logError(String msg) {
        logger.severe(msg);
    }

    public static void printHeader(String text) {
        System.out.println("\n=== " + text + " ===");
    }
}
