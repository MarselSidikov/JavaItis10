package ru.itis.spring;

public class Main {
    public static void main(String[] args) {
        MessageRenderer renderer = new MessageRendererStandardImpl();
        PrefixUtils prefixUtils = new LocalDatePrefixUtilsImpl(renderer);
//        prefixUtils.setPrefix("MARSEL: ");
        prefixUtils.render("Hello, World");
    }
}
