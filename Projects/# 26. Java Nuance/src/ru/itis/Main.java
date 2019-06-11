package ru.itis;

public class Main {

    public static void main(String[] args) {
	    Human marsel = new Human(25, "Марсель");
	    Human anotherMarsel = new Human(25, "Марсель");
	    Human anotherAnotherMarsel = marsel;
	    Object object = marsel;

        System.out.println(marsel);

        System.out.println(marsel == anotherMarsel);
        System.out.println(anotherAnotherMarsel == marsel);
        System.out.println(marsel.equals(anotherMarsel));
    }
}
