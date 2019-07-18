package ds.trie;

import java.util.TreeMap;

public class Trie {

    private class Node {
        private boolean isWord;
        private TreeMap<Character, Node> next;

        public Node() {
            next = new TreeMap<>();
        }
    }

    private Node root;
    private int size;


    public Trie() {
        this.root = new Node();
        size = 0;
    }

    // return the word size
    public int getSize() {
        return this.size;
    }

    public void add(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char a = word.charAt(i); // {'a' : {'b': {}}}
            if (cur.next.get(a) == null) {
                cur.next.put(a, new Node());
            }
            cur = cur.next.get(a);
        }

        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    public boolean contains(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char a = word.charAt(i);
            if (!cur.next.containsKey(a)) return false;
            cur = cur.next.get(a);
        }
        return cur.isWord;
    }

    public boolean isPrefix(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char a = prefix.charAt(i);
            if (!cur.next.containsKey(a)) return false;
            cur = cur.next.get(a);
        }
        return true;
    }

    public static void main(String[] args) {
        Trie t = new Trie();
        t.add("abcde");
        System.out.println(t.size);
        System.out.println(t.contains("abcde"));
        System.out.println(t.isPrefix("abc"));
        System.out.println(t.isPrefix("abd"));
    }
}
