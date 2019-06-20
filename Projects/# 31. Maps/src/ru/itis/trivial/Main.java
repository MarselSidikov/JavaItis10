package ru.itis.trivial;

public class Main {

    public static void main(String[] args) {
        Map<String, Integer> map = new MapEntriesArrayImpl<>();
        map.put("Марсель", 25);
        map.put("Дамир", 19);
        map.put("Олег", 22);
        map.put("Кирилл", 28);
        map.put("Илья", 26);
        map.put("Марсель", 24);

        System.out.println(map.get("Марсель"));
        System.out.println(map.get("Дамир"));
        System.out.println(map.get("Кирилл"));
        System.out.println(map.get("Илья"));
    }
}
