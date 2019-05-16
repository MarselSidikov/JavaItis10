package ru.itis;

public class Logger {
    private static final Logger instance;

    private Logger() {
    }

    static {
        instance = new Logger();
    }

    public static Logger getLogger() {
        return instance;
    }
    // ------------

    private String prefix;

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void log(String message) {
        System.out.println(prefix + " " + message);
    }
}
