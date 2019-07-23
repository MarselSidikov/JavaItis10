package ru.itis;

public class Main {

    public static void main(String[] args) {
	    Xhr xhr = new Xhr();
	    xhr.onLoad = () -> {
            System.out.println("Мы получили результат!!!!!");
        };
	    xhr.send();
    }
}
