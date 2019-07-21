package ds.hashtable;

import ds.avltree.AVLMap;

// AVL tree hash map
public class MyHashMap<K extends Comparable<K>, V> {

    private AVLMap<K, V>[] hashMap;
    private int M;
    private int size;

    public MyHashMap(int M) {
        this.M = M;
        size = 0;
        hashMap = new AVLMap[M];
        for (int i = 0; i < M; i++) {
            hashMap[i] = new AVLMap<>();
        }
    }

    public MyHashMap() {
        this(97);
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M; // take out the highest bit
    }

    public int getSize() {
        return size;
    }

    public V get(K key) {
        AVLMap<K, V> map = hashMap[hash(key)];
        if (!map.contains(key)) {
            throw new IllegalArgumentException("Key does not exists");
        }
        return map.get(key);
    }

    public void put(K key, V value) {
        AVLMap<K, V> map = hashMap[hash(key)];
        if (!map.contains(key))
            size++;
        map.put(key, value);
    }

    public void set(K key, V value) {
        AVLMap<K, V> map = hashMap[hash(key)];
        if (!map.contains(key)) {
            throw new IllegalArgumentException("key does not exist");
        }
        map.put(key, value);
    }

    public V remove(K key) {
        V res = null;
        AVLMap<K, V> map = hashMap[hash(key)];
        if (map.contains(key)) {
            res = map.remove(key);
            size--;
        }
        return res;
    }

    public boolean contains(K key) {
        return hashMap[hash(key)].contains(key);
    }

    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        String[] fruits = {"apple", "pear", "pineapple"};
        for (int i = 0; i < fruits.length; i++) {
            map.put(fruits[i], (i + 1) * 10);
        }
        System.out.println("size " + map.getSize());
        for (int i = 0; i < fruits.length; i++) {
            System.out.println(fruits[i] + " " + map.get(fruits[i]));
        }
        map.put(fruits[2], 90);
        System.out.println(fruits[2] + " " + map.get(fruits[2]));
//        map.set("random", 10); // throw exception
//        System.out.println(map.get("random")); // throw exception
    }
}
