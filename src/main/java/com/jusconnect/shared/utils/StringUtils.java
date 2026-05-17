package com.jusconnect.shared.utils;

public final class StringUtils {

    private StringUtils() {
    }

    public static boolean isNullOrBlank(
            String value
    ) {

        return value == null ||
                value.trim().isEmpty();
    }

    public static String normalize(
            String value
    ) {

        if (isNullOrBlank(value)) {
            return "";
        }

        return value.trim()
                .replaceAll("\\s+", " ");
    }
}