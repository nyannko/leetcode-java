package ds.hashtable;

import java.util.TreeMap;

public class MyHashMapPrimeCap<K extends Comparable<K>, V> {

    // capacity for resized hash map
    private final static int[] capacity = {
            53, 97, 193, 389, 769, 1543, 3079, 6151, 12289, 24593,
            49157, 98317, 196613, 393241, 786433, 1572869, 3145739, 6291469,
            12582917, 25165843, 50331653, 100663319, 201326611, 402653189, 805306457, 1610612741
    };

    private final static int upper = 10;
    private final static int lower = 2;
    private int capIndex = 0;

    private TreeMap<K, V>[] hashMap;
    private int M;
    private int size;

    public MyHashMapPrimeCap(int M) {
        this.M = M;
        size = 0;
        hashMap = new TreeMap[M];
        for (int i = 0; i < M; i++) {
            hashMap[i] = new TreeMap<>();
        }
    }

    public MyHashMapPrimeCap() {
        this(capacity[0]);
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M; // take out the highest bit
    }

    public int getSize() {
        return size;
    }

    public V get(K key) {
        TreeMap<K, V> map = hashMap[hash(key)];
        if (!map.containsKey(key)) {
            throw new IllegalArgumentException("Key does not exists");
        }
        return map.get(key);
    }

    public void put(K key, V value) {
        TreeMap<K, V> map = hashMap[hash(key)];
        if (!map.containsKey(key))
            size++;
        map.put(key, value);
        if (size >= upper * M && capIndex < capacity.length - 1) { //  N/M
            capIndex++; // shift to next capacity
            resize(capacity[capIndex]);
        }
    }

    private void resize(int newM) {
        TreeMap<K, V>[] newMap = new TreeMap[newM];
        for (int i = 0; i < newM; i++) {
            newMap[i] = new TreeMap<>();
        }

        int oldM = this.M;
        this.M = newM;
        for (int i = 0; i < oldM; i++) {
            TreeMap<K, V> map = hashMap[i];
            for (K key : map.keySet()) {
                newMap[hash(key)].put(key, map.get(key));
            }
        }
        this.hashMap = newMap;
    }

    public void set(K key, V value) {
        TreeMap<K, V> map = hashMap[hash(key)];
        if (!map.containsKey(key)) {
            throw new IllegalArgumentException("key does not exist");
        }
        map.put(key, value);
    }

    public V remove(K key) {
        V res = null;
        TreeMap<K, V> map = hashMap[hash(key)];
        if (map.containsKey(key)) {
            res = map.remove(key);
            size--;
        }
        if (size <= lower * M && capIndex - 1 >= 0) {
            capIndex--;
            resize(capacity[capIndex]);
        }
        return res;
    }

    public boolean contains(K key) {
        return hashMap[hash(key)].containsKey(key);
    }

    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        String[] fruits = {"apple", "pear", "pineapple", "Banana", "Orange", "Mango"};
        for (int i = 0; i < fruits.length; i++) {
            map.put(fruits[i], (i + 1) * 10);
        }
        System.out.println("size " + map.getSize());
        for (int i = 0; i < fruits.length; i++) {
            System.out.println(fruits[i] + " " + map.get(fruits[i]));
        }
        map.put(fruits[2], 90);
        System.out.println(fruits[2] + " " + map.get(fruits[2]));
    }
}
