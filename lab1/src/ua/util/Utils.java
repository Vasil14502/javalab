package ua.util;

public class Utils {

    public static String capitalize(String str) {
        ValidationHelper.requireNonEmpty(str, "String");
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }

    public static void printHeader(String text) {
        System.out.println("\n=== " + text + " ===");
    }
}
