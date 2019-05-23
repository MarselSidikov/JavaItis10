package ru.itis;

public interface StringProcessorObservable {
    void setLettersObserver(LettersObserver lettersObserver);
    void setDigitsObserver(DigitsObserver digitsObserver);
    void setPMObserver(PMObserver pmObserver);
    void notifyLettersObserver(char c);
    void notifyDigitsObserver(char c);
    void notifyPmObserver(char c);
}
