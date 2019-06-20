package ru.itis.hashes;

public class HashSet<V> implements Set<V> {
    private static final Object EMPTY = new Object();
    private HashMap<V, Object> hashMap;

    public HashSet() {
        this.hashMap = new HashMap<>();
    }
    @Override
    public void add(V value) {
        hashMap.put(value, EMPTY);
    }

    @Override
    public void contains(V value) {
        hashMap.containsKey(value);
    }
}
