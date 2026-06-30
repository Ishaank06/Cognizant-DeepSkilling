package com.example.singleton;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static volatile Logger instance;

    private Logger() {
        if (instance != null) {
            throw new IllegalStateException("Logger instance already created.");
        }
    }

    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    public void log(String message) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
        System.out.println("[" + timestamp + "] [INFO] " + message);
    }
}
