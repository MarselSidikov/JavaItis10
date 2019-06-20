package ru.itis.hashes;

public class HashMap<K, V> implements Map<K, V> {
    private static final int DEFAULT_BUCKETS_COUNT = 16;

    private static class Entry<K, V> {
        K key;
        V value;
        int hash;
        Entry<K,V> next;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.hash = key.hashCode();
            this.next = null;
        }
    }

    private Entry<K, V> table[];

    public HashMap() {
        table = new Entry[DEFAULT_BUCKETS_COUNT];
    }

    @Override
    public void put(K key, V value) {
        int hashCode = key.hashCode();
        int indexInArray = hashCode & (table.length - 1);

        if (table[indexInArray] == null) {
            Entry<K, V> newEntry = new Entry<>(key, value);
            table[indexInArray] = newEntry;
            return;
        }

        // если в данном бакете уже были элементы, у нас возможны два исхода:
        // 1. Такого ключа еще там нет
        // 2. Такой кдюч уже есть и у него надо заменить значение

        // взяли первый элемент списка
        Entry<K, V> current = table[indexInArray];
        while (current != null) {
            // сначала сравниваем хеш код
            if (current.hash == key.hashCode()) {
                // если хеш-код совпал, значит высока вероятность, что эти
                // ключи одинаковые, проверяем через equals
                if (current.key.equals(key)) {
                    // если совпали - заменяем значение
                    current.value = value;
                    return;
                }
            }
            current = current.next;
        }
        // если дошли до сюда, значит - ключа такого не нашли, можно добавить новый
        Entry<K, V> newEntry = new Entry<>(key, value);
        newEntry.next = table[indexInArray];
        table[indexInArray] = newEntry;

    }

    @Override
    public V get(K key) {
        int hashCode = key.hashCode();
        int indexInArray = hashCode & (table.length - 1);

        Entry<K, V> current = table[indexInArray];

        while (current != null) {
            if (current.hash == key.hashCode()) {
                if (current.key.equals(key)) {
                    return current.value;
                }
            }
            current = current.next;
        }
        return null;
    }

    @Override
    public boolean containsKey(K key) {
        return false;
    }
}
