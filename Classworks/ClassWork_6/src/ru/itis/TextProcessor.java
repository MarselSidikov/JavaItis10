package ru.itis;

public class TextProcessor implements StringProcessorObservable {

    private LettersObserver lettersObserver;
    private DigitsObserver digitsObserver;
    private PMObserver pmObserver;

    public void setLettersObserver(LettersObserver lettersObserver) {
        this.lettersObserver = lettersObserver;
    }

    public void setDigitsObserver(DigitsObserver digitsObserver) {
        this.digitsObserver = digitsObserver;
    }

    public void setPMObserver(PMObserver pmObserver) {
        this.pmObserver = pmObserver;
    }

    public void notifyLettersObserver(char c) {
        lettersObserver.handle(c);
    }

    public void notifyDigitsObserver(char c) {
        digitsObserver.handle(c);
    }

    public void notifyPmObserver(char c) {
        pmObserver.handle(c);
    }

    public void process(String text) {
        char textAsArray[] = text.toCharArray();
        for (int i = 0; i < text.length(); i++) {
            if (Character.isLetter(textAsArray[i])) {
                notifyLettersObserver(textAsArray[i]);
            } else if (Character.isDigit(textAsArray[i])) {
                notifyDigitsObserver(textAsArray[i]);
            } else {
                notifyPmObserver(textAsArray[i]);
            }
        }
    }
}
