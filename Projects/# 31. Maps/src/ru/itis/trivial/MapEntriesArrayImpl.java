package ru.itis.trivial;

public class MapEntriesArrayImpl<K, V> implements Map<K, V> {
    private static final int DEFAULT_ARRAY_SIZE = 10;

    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Entry<K, V> entries[];
    private int entriesCount;

    public MapEntriesArrayImpl() {
        entries = new Entry[DEFAULT_ARRAY_SIZE];
    }

    @Override
    public void put(K key, V value) {

        for (int i = 0; i < entriesCount; i++) {
            if (entries[i].key.equals(key)) {
                entries[i].value = value;
                return;
            }
        }

        Entry<K, V> newEntry = new Entry<>(key, value);
        entries[entriesCount] = newEntry;
        entriesCount++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < entriesCount; i++) {
            if (entries[i].key.equals(key)) {
                return entries[i].value;
            }
        }
        return null;
    }

    @Override
    public boolean containsKey(K key) {
        for (int i = 0; i < entriesCount; i++) {
            if (entries[i].key.equals(key)) {
                return true;
            }
        }
        return false;
    }
}
