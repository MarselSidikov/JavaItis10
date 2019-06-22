package ru.itis.custom;

public class Main {

    public static void main(String[] args) {
	    List<String> strings = new LinkedList<>();

	    strings.add("Привет");
	    strings.add("Марсель");
	    strings.add("Как");
	    strings.add("Дела");

//	    for (int i = 0; i < strings.size(); i++) {
//            System.out.println(strings.get(i));
//        }

		Iterator<String> iterator1 = strings.iterator();
		Iterator<String> iterator2 = strings.iterator();

		while (iterator1.hasNext()) {
			System.out.println(iterator1.next());
		}

		while (iterator2.hasNext()) {
			System.out.println(iterator2.next());
		}
    }
}
