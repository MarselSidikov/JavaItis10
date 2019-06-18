package ru.itis;

public class Main {

    public static void main(String[] args) {
	    List<String> strings = new LinkedList<>();

	    strings.add("Привет");
	    strings.add("Марсель");
	    strings.add("Как");
	    strings.add("Дела");

	    for (int i = 0; i < strings.size(); i++) {
            System.out.println(strings.get(i));
        }
    }
}
