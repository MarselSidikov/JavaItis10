package ru.itis;

public class Main {
    public static void main(String[] args) {
        Button button = new Button("Space");
        Button button1 = new Button("Ctrl");

        Printer printer = new Printer();

        RedPrinter redPrinter = new RedPrinter();
        button.addObserver(printer);
        button.addObserver(redPrinter);
        button1.addObserver(printer);
        button1.addObserver(redPrinter);

        button.click();
        button1.click();
    }
}
