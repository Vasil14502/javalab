package ua.util;  // пакет, де буде ValidationHelper

// Клас повинен бути public
public class ValidationHelper {

    private ValidationHelper() {} // Заборона створення екземплярів

    public static void requireNonEmpty(String value, String field) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(field + " cannot be empty");
        }
    }

    public static void requireNonNull(Object value, String field) {
        if (value == null) {
            throw new IllegalArgumentException(field + " cannot be null");
        }
    }

    public static void requirePositive(int value, String field) {
        if (value <= 0) {
            throw new IllegalArgumentException(field + " must be positive");
        }
    }
}
