package ru.itis.hashes;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Марсель", 25);
        map.put("Дамир", 19);
        map.put("Олег", 22);
        map.put("Кирилл", 28);
        map.put("Илья", 26);
        map.put("Игорь", 40);
        map.put("Наиль", 37);
        map.put("Айдар", 29);
        map.put("Надир", 22);
        map.put("Александр", 31);
        map.put("Марсель", 26);

        System.out.println(map.get("Марсель"));
        System.out.println(map.get("Дамир"));
        System.out.println(map.get("Олег"));
        System.out.println(map.get("Кирилл"));
        System.out.println(map.get("Илья"));
        System.out.println(map.get("Игорь"));
        System.out.println(map.get("Наиль"));
        System.out.println(map.get("Айдар"));
        System.out.println(map.get("Надир"));
        System.out.println(map.get("Александр"));

        int i = 1;
    }
}
