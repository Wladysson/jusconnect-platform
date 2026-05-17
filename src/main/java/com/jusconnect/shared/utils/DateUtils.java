package com.jusconnect.shared.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class DateUtils {

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern(
                    "dd/MM/yyyy HH:mm:ss"
            );

    private DateUtils() {
    }

    public static String format(
            LocalDateTime dateTime
    ) {

        if (dateTime == null) {
            return null;
        }

        return dateTime.format(FORMATTER);
    }
}