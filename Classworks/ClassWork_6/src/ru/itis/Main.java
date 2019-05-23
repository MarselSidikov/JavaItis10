package ru.itis;

public class Main {

    public static void main(String[] args) {
        String text = "Hello,1234!";
        TextProcessor textProcessor = new TextProcessor();
        DigitsObserver digitsObserver = new DigitsObserverImpl();
        LettersObserver lettersObserver = new LettersObserverImpl();
        textProcessor.setLettersObserver(lettersObserver);
        textProcessor.setDigitsObserver(digitsObserver);
        textProcessor.setPMObserver(new PMObserverImpl());

        textProcessor.process(text);
    }
}
