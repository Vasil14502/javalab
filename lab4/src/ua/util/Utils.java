package ua.util;

public class Utils {

    public static void checkNonEmpty(String value, String fieldName) {
        ValidationHelper.requireNonEmpty(value, fieldName);
    }

    public static void checkNonNull(Object value, String fieldName) {
        ValidationHelper.requireNonNull(value, fieldName);
    }

    public static void checkPositive(int value, String fieldName) {
        ValidationHelper.requirePositive(value, fieldName);
    }
}