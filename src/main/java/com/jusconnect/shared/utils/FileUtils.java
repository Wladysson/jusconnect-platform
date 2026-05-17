package com.jusconnect.shared.utils;

public final class FileUtils {

    private FileUtils() {
    }

    public static String getExtension(
            String filename
    ) {

        if (filename == null ||
                !filename.contains(".")) {
            return "";
        }

        return filename.substring(
                filename.lastIndexOf(".") + 1
        );
    }

    public static boolean isPdf(
            String filename
    ) {

        return "pdf".equalsIgnoreCase(
                getExtension(filename)
        );
    }
}