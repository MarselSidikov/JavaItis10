package ru.itis.checked;

import java.io.FileNotFoundException;

public class SomeClass {
    public void doSomething() throws FileNotFoundException {
        throw new FileNotFoundException();
    }
}
